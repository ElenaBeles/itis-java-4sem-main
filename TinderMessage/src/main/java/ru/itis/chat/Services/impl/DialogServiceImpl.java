package ru.itis.chat.Services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.chat.Dto.DialogDto;
import ru.itis.chat.Dto.CreateChatForm;
import ru.itis.chat.Mappers.DialogsMapper;
import ru.itis.chat.Models.Dialog;
import ru.itis.chat.Models.User;
import ru.itis.chat.Repositories.DialogRepository;
import ru.itis.chat.Repositories.UsersRepository;
import ru.itis.chat.Services.DialogService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DialogServiceImpl implements DialogService {
    private final DialogRepository dialogRepository;
    private final UsersRepository usersRepository;
    private final DialogsMapper dialogsMapper;

    @Override
    public List<DialogDto> getAllChats(Long userId) {
        return dialogRepository.findAllByParticipantsContaining(usersRepository.getById(userId))
                .stream()
                .map(dialogsMapper::getDialogDto)
                .collect(Collectors.toList());
    }

    @Override
    public DialogDto createChatRoom(CreateChatForm createChatForm, Long userId) {
        Set<User> participants = new HashSet<>();
        participants.add(usersRepository.findById(userId).get());
        participants.add(usersRepository.findById(createChatForm.getReceiverId()).get());
        Dialog dialog = Dialog.builder()
                .participants(participants)
                .msgs(new ArrayList<>())
                .build();

        return dialogsMapper.getDialogDto(dialogRepository.save(dialog));
    }

    @Override
    public DialogDto getChatRoom(Long id) {
        return dialogsMapper.getDialogDto(dialogRepository.findById(id).get());
    }

    @Override
    public void deleteChatRoom(Long id) {
        dialogRepository.deleteById(id);
    }
}
