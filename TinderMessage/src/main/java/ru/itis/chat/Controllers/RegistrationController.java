package ru.itis.chat.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.chat.Dto.RegistrationForm;
import ru.itis.chat.Services.RegistrationService;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping("/signUp")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody RegistrationForm registrationForm, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            registrationService.signUp(registrationForm);
        }
    }

}
