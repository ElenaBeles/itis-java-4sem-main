package ru.itis.chat.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

