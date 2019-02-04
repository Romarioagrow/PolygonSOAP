package mybase.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import mybase.entities.User;
import mybase.repos.Role;
import mybase.services.UserService;
import java.util.Map;

@Controller
@RequestMapping("/user")
// @PreAuthorize("hasAuthority('ADMIN')") // Проверка наличия прав доступа у пользователей к контроллеру
public class UserController {
    @Autowired
    private UserService userService;

    // Отобразить сообщения пользователя
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());

        return "userList";
    }

    // Редактировать пользователя
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEdit(
            @PathVariable User user, Model model)
    {
        model.addAttribute( "user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    // Сохранить пользователя в БД
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String > form,
            @RequestParam("userId") User user)
    {
        userService.saveUser(user, username, form);

        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());

        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String username,
            @RequestParam String password
    ){
        userService.updateProfile(user, username, password);

        return "redirect:/user/profile";
    }
}
