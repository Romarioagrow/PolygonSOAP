package polygon.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import polygon.entities.User;
import polygon.repos.Role;
import polygon.repos.UserRepo;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')") // Проверка наличия прав доступа у пользователей к контроллеру
public class UserController {
    @Autowired
    private UserRepo userRepo;

    // Отобразить сообщения пользователя
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());

        return "userList";
    }

    // Редактировать пользователя
    @GetMapping("{user}")
    public String userEdit(
            @PathVariable User user, Model model)
    {
        model.addAttribute( "user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    // Сохранить пользователя в БД
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String > form,
            @RequestParam("userId") User user)
    {
        user.setUsername(username);

        // Проверка ролей пользователя
        // Первод ролей из enum в строковый вид
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();

        // Проверка формы на содержание ролей
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);

        return "redirect:/user";
    }
}
