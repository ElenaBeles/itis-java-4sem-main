package ru.itis.chat.Services;

import ru.itis.chat.Dto.DialogDto;
import ru.itis.chat.Dto.CreateMsgForm;

public interface MsgService {
    DialogDto sendMessage(CreateMsgForm createMsgForm, Long authorId);
    DialogDto editMessage(String newText, Long messageId);

    void deleteMessage(Long messageId);
}
