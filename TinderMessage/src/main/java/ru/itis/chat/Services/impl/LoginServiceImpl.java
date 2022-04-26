package ru.itis.chat.Services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.chat.Dto.LoginForm;
import ru.itis.chat.Dto.UserDto;
import ru.itis.chat.Mappers.UsersMapper;
import ru.itis.chat.Models.User;
import ru.itis.chat.Repositories.UsersRepository;
import ru.itis.chat.Services.LoginService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;
    private final UsersMapper usersMapper;

    @Override
    public UserDto signIn(LoginForm loginForm) {
        Optional<User> optionalUser = usersRepository.findByEmail(loginForm.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginForm.getPassword(), user.getPassword())) {
                return usersMapper.getUserDto(user);
            }
        }
        return null;
    }
}
