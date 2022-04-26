package ru.itis.chat.Mappers;

import org.mapstruct.Mapper;
import ru.itis.chat.Dto.UserDto;
import ru.itis.chat.Models.User;

@Mapper (uses = {MsgsMapper.class, DialogsMapper.class})
public interface UsersMapper {
    UserDto getUserDto (User user);

    User getUser (UserDto userDto);
}
