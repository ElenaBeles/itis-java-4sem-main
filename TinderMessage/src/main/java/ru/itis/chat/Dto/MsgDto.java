package ru.itis.chat.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.chat.Models.Msg;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MsgDto {
    private Long id;
    private String body;
    private UserDto author;
    private Long chatRoomId;
}
