package mybase.controllers;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import mybase.entities.User;

import java.util.Map;

@Controller
public class MainController {
    // Стартовая страница приложения
    @GetMapping("/")
    public String greeting(
            @AuthenticationPrincipal User user,
            @RequestParam(name="name", required=false, defaultValue="Sir")
            String name, Map<String, Object> model)

    {
        // Отобразить имя пользователя
        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            String userName = user.getUsername();
            model.put("userName", userName);
        }
        else {
            model.put("userName", "Sir");
        }

        return "main";
    }
}
