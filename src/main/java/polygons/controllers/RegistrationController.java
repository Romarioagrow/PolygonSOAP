package polygons.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import polygons.entities.User;
import polygons.services.UserService;

import java.util.Map;

@Log
@Controller
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;

    /*Отобразить страницу Login*/
    @GetMapping("/login")
    public String loginError(
            Model model,
            @RequestParam(value = "error", required = false) String loginError
    ){
        log.info("Login get mapping");

        if (loginError != null) {
            log.warning("loginError!");
            model.addAttribute("loginError", true);
        }

        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    /*Добавить нового пользователя*/
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model)
    {
        if (!userService.addUser(user))
        {
            model.put("message", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}
