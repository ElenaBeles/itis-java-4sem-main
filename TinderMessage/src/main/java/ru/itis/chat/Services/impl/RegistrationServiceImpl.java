package ru.itis.chat.Services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.chat.Dto.RegistrationForm;
import ru.itis.chat.Dto.UserDto;
import ru.itis.chat.Exceptions.ValidationException;
import ru.itis.chat.Models.User;
import ru.itis.chat.Repositories.UsersRepository;
import ru.itis.chat.Services.RegistrationService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    private final Validator validator;

    @Override
    public void signUp(RegistrationForm registrationForm) {
        User user = User.builder()
                .firstName(registrationForm.getFirstName())
                .lastName(registrationForm.getLastName())
                .email(registrationForm.getEmail())
                .password(passwordEncoder.encode(registrationForm.getPassword()))
                .build();

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if(!violations.isEmpty()) {
            throw new ValidationException(violations.stream().findFirst().get().getMessage());
        }

        usersRepository.save(user);
    }

}
