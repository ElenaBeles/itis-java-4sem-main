package ru.itis.chat.Services;

import ru.itis.chat.Dto.DialogDto;
import ru.itis.chat.Dto.CreateChatForm;

import java.util.List;

public interface DialogService {
    List<DialogDto> getAllChats(Long userId);
    DialogDto createChatRoom(CreateChatForm createChatForm, Long userId);
    DialogDto getChatRoom(Long id);
    void deleteChatRoom(Long id);
}
