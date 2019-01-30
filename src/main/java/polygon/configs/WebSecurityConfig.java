package polygon.configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import polygon.services.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    // Разрешения доступа
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Корень, регистрация и статик контент без авторизации
                .authorizeRequests()
                    .antMatchers(//"/",
                            "/registration",
                            "/static/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    // Аутентификация пользователя
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());


    }
}

/*
auth.jdbcAuthentication()
                // Подключиться к БД
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                // Найти пользователя в бд по имени
                .usersByUsernameQuery("select username, password, active from usr where username=?")
                // Получить список пользователей с ролями (Из таблицы usr и присоедененной к ней таблицей user_role через поле user_id и= id выбрать поля username и имя роли
                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=? ");
*/