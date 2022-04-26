package ru.itis.chat.Controllers;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/signOut")
public class LogoutController {

    @PostMapping
    public void sigOut(HttpSession session) {
        session.invalidate();
    }

}
