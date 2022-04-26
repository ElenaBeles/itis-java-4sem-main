package ru.itis.chat.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.chat.Dto.DialogDto;
import ru.itis.chat.Dto.CreateMsgForm;
import ru.itis.chat.Dto.MsgDto;
import ru.itis.chat.Services.MsgService;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@RequestMapping("/message")
public class MsgController {

    private final MsgService msgService;

    @PostMapping
    public ResponseEntity<DialogDto> sendMessage(@RequestBody CreateMsgForm createMsgForm, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        } else {
            return ResponseEntity
                    .ok()
                    .body(msgService.sendMessage(createMsgForm, userId));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DialogDto> editMessage(@RequestBody MsgDto msgDto, @PathVariable("id") Long id) {
        return ResponseEntity
                .ok()
                .body(msgService.editMessage(msgDto.getBody(), id));
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") Long messageId) {
        msgService.deleteMessage(messageId);
    }
}
