package polygons.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Value("${upload.path}")
    private String uploadPath;

    /*public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }*/

   /* Отображение и раздача контента*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*Раздача изображений*/
        registry.addResourceHandler("/img/**").addResourceLocations("file://" + uploadPath + "/");
        /*Раздача стилей, поиск стилей в classpath*/
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
