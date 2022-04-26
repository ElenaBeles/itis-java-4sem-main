package ru.itis.chat.Mappers;

import org.mapstruct.Mapper;
import ru.itis.chat.Dto.MsgDto;
import ru.itis.chat.Models.Msg;

@Mapper (uses = {DialogsMapper.class, UsersMapper.class})
public interface MsgsMapper {
    MsgDto getMsgDto (Msg message);

    Msg getMessage (MsgDto msgDto);
}
