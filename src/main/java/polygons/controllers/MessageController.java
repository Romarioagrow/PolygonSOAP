package polygons.controllers;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import polygons.entities.Message;
import polygons.entities.User;
import polygons.repos.MessageRepo;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Log
@Controller
public class MessageController {
    private final MessageRepo messageRepo;

    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    /*Путь поиска выкладываемых изображений*/
    @Value("${upload.path}")
    private String uploadPath;
    /// private static final String uploadPATH = "D:\\Storage\\Dev\\Projects\\IdeaProject\\UNIQUE\\PolygonSOAP\\src\\main\\resources\\static\\img\\posts";

    /* Отобразить список сообщений*/
    @GetMapping("/messages")
    public String listMessages(
            Model model,
            @AuthenticationPrincipal User user

    ){
        List<Message> messages = messageRepo.findByAuthor(user);
        messages.sort(Comparator.comparing(Message::getDate).reversed());

        model.addAttribute("messages", messages);
        return "messages";
    }

    /*Сохранить новый пост*/
    @PostMapping("/messages")
    public String postMessage(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "no message") String text,
            @RequestParam(required = false) String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException
    {
        log.info("Upload post path: " + uploadPath);

        Message message = new Message(text, tag, user);

        /*Добавление файла
        Проверка директории файла*/
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            /*Присовить файлу уникальное имя*/
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            /*Переименовать файл*/
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            message.setFilename(resultFileName);
            log.info("Result file name: " + resultFileName);
        }

        message.setDate(LocalDateTime.now());
        messageRepo.save(message);

        List<Message> messages = messageRepo.findByAuthor(user);
        messages.sort(Comparator.comparing(Message::getDate).reversed());
        model.put("messages", messages);
        return "messages";
    }

    /*Переадресовать и отобразить список пользователей*/
    @PostMapping("allUsers")
    public String allUsers() {
        return "redirect:/users/all";
    }
}
