package polygon.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import polygon.entities.Message;
import polygon.entities.User;
import polygon.repos.MessageRepo;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class MessageController {
    @Autowired
    private MessageRepo messageRepo;

    // Путь поиска выкладываемых изображений
    @Value("${upload.path}")
    private String uploadPath;

    // Отобразить список сообщений
    @GetMapping("/messages")
    public String listMessages(
            @AuthenticationPrincipal User user,
            Model model)
    {
        Iterable<Message> messages = messageRepo.findByAuthor(user);

        model.addAttribute("messages", messages);

        return "messages";
    }

    // Отправить сообщение
    @PostMapping("/messages")
    public String postMessage(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "no message") String text,
            @RequestParam(required = false) String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException
    {
        Message message = new Message(text, tag, user);

        // Добавление файла
        // Проверка директории файла
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            // Присовить файлу уникальное имя
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            // Переименовать файл
            file.transferTo(new File(uploadPath + "/" + resultFileName));

            message.setFilename(resultFileName);
        }

        // Сохранить сообщение в БД
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findByAuthor(user);

        model.put("messages", messages);

        return "messages";
    }

    // Переадресовать и отобразить список пользователей
    @PostMapping("allUsers")
    public String allUsers() {
        return "redirect:/users/all";
    }
}
