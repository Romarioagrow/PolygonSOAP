package polygon.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import polygon.entities.User;
import polygon.repos.Role;
import polygon.repos.UserRepo;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    // Отобразить страницу регистрации
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    // Добавить нового пользователя
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userDB = userRepo.findByUsername(user.getUsername());

        if (userDB != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        // Установить пользователю роль АДМИН
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ADMIN));
        userRepo.save(user);

        return "redirect:/login";
    }
}
