package ru.itis.chat.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.itis.chat.Exceptions.ErrEntity;
import ru.itis.chat.Exceptions.ValidationException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public ResponseEntity<ErrEntity> handle(ValidationException ex) {
        return ResponseEntity.status(ex.getEntity().getStatus()).body(ex.getEntity());
    }
}