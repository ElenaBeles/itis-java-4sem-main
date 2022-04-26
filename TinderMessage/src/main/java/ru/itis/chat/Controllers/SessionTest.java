package ru.itis.chat.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionTest {

    @GetMapping
    public Long getUserId(HttpSession session) {
        return (Long) session.getAttribute("userId");
    }
}
