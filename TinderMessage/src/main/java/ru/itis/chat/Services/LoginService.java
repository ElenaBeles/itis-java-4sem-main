package ru.itis.chat.Services;

import ru.itis.chat.Dto.LoginForm;
import ru.itis.chat.Dto.UserDto;

public interface LoginService {
    UserDto signIn(LoginForm loginForm);
}
