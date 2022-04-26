package ru.itis.chat.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ru.itis.chat.Dto.CreateChatForm;
import ru.itis.chat.Dto.DialogDto;
import ru.itis.chat.Services.DialogService;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chats")
public class DialogController {
    private final DialogService chatRoomsService;

    @GetMapping
    public ResponseEntity<List<DialogDto>> getAllChats(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        } else {
            return ResponseEntity
                    .ok()
                    .body(chatRoomsService.getAllChats(userId));
        }
    }

    @PostMapping
    public ResponseEntity<DialogDto> createChatRoom(@RequestBody CreateChatForm createChatForm, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        } else {
            return ResponseEntity
                    .ok()
                    .body(chatRoomsService.createChatRoom(createChatForm, userId));
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<DialogDto> getChatRoom(@PathVariable("id") Long chatRoomId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        } else {
            return ResponseEntity
                    .ok()
                    .body(chatRoomsService.getChatRoom(chatRoomId));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChatRoom(@PathVariable("id") Long chatRoomId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        } else {
            chatRoomsService.deleteChatRoom(chatRoomId);
            return ResponseEntity.ok().build();
        }
    }

}

