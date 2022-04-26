package ru.itis.chat.Services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.chat.Dto.DialogDto;
import ru.itis.chat.Dto.CreateMsgForm;
import ru.itis.chat.Mappers.DialogsMapper;
import ru.itis.chat.Mappers.MsgsMapper;
import ru.itis.chat.Models.Msg;
import ru.itis.chat.Repositories.DialogRepository;
import ru.itis.chat.Repositories.MsgRepository;
import ru.itis.chat.Repositories.UsersRepository;
import ru.itis.chat.Services.MsgService;

@RequiredArgsConstructor
@Service
public class MsgServiceImpl implements MsgService {
    private final MsgRepository msgRepository;
    private final UsersRepository usersRepository;
    private final DialogRepository dialogRepository;
    private final DialogsMapper dialogsMapper;

    @Override
    public DialogDto sendMessage(CreateMsgForm createMsgForm, Long authorId) {
        Msg msg = Msg.builder()
                .author(usersRepository.findById(authorId).get())
                .chat(dialogRepository.findById(createMsgForm.getChatRoomId()).get())
                .body(createMsgForm.getBody())
                .build();
        msgRepository.save(msg);
        return dialogsMapper.getDialogDto(dialogRepository.findById(createMsgForm.getChatRoomId()).get());
    }

    @Override
    public DialogDto editMessage(String newText, Long messageId) {
        Msg msg = msgRepository.findById(messageId).get();
        msg.setBody(newText);
        msgRepository.save(msg);
        return dialogsMapper.getDialogDto(dialogRepository.findById(msg.getChat().getId()).get());
    }

    @Override
    public void deleteMessage(Long messageId) {
        msgRepository.deleteById(messageId);
    }
}
