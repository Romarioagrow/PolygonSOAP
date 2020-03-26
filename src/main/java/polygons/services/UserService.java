package polygons.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import polygons.entities.User;
import polygons.repos.Role;
import polygons.repos.UserRepo;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userDB = userRepo.findByUsername(user.getUsername());
        LocalDateTime now = LocalDateTime.now();

        if (userDB != null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ADMIN));
        user.setRegistrationDate(now);

        userRepo.save(user);
        return true;
    }

    /*Для сохранения изменений при редактировании пользователя*/
    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);

        /*Проверка ролей пользователя
        Первод ролей из enum в строковый вид*/
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();

        /*Проверка формы на содержание ролей*/
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void updateProfile(User user, String username, String password) {
        String newName = user.getUsername();

        boolean isNameChanged = (username != null && !username.equals(newName)) ||
                (newName != null && !newName.equals(username));

        if (isNameChanged) {
            user.setUsername(username);
        }

        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }

        userRepo.save(user);
    }
}
