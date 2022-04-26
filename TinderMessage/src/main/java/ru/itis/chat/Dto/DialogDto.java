package ru.itis.chat.Dto;

import lombok.*;
import ru.itis.chat.Models.Dialog;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DialogDto {

    private Long id;

    private Set<UserDto> participants;

    private List<MsgDto> messages;
}
