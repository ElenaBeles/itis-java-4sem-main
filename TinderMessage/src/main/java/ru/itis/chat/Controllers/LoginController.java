package ru.itis.chat.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.chat.Dto.LoginForm;
import ru.itis.chat.Dto.UserDto;
import ru.itis.chat.Services.LoginService;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping("/signIn")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<UserDto> signIn(@RequestBody LoginForm loginForm, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            UserDto userDto = loginService.signIn(loginForm);
            if (userDto == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build();
            }

            session.setAttribute("userId", userDto.getId());
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(userDto);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
}
