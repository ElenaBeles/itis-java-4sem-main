package ru.itis.chat.Mappers;

import org.mapstruct.Mapper;
import ru.itis.chat.Dto.DialogDto;
import ru.itis.chat.Models.Dialog;

@Mapper (uses = {MsgsMapper.class, UsersMapper.class})
public interface DialogsMapper {
    DialogDto getDialogDto (Dialog dialog);

    Dialog getDialog (DialogDto dialogDto);
}
