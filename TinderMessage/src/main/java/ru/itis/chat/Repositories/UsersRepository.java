package ru.itis.chat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.chat.Models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
