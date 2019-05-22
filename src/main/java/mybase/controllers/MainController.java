package mybase.controllers;
import mybase.entities.vk.VKUser;
import mybase.repos.VKRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import mybase.entities.User;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    VKRepo vkRepo;

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
        else model.put("userName", "Sir");
        return "main";
    }

    @PostMapping("/")
    public String profile(
            @AuthenticationPrincipal User user,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String city,
            @RequestParam Integer age
    ){
        VKUser vkUser = new VKUser();
        vkUser.setFirstName(firstName);
        vkUser.setLastName(lastName);
        vkUser.setCity(city);
        vkUser.setAge(age);
        vkUser.setUser_id(user.getId());

        vkRepo.save(vkUser);
        return "main";
    }
}
