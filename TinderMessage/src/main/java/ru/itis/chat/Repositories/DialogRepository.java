package ru.itis.chat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.chat.Models.Dialog;
import ru.itis.chat.Models.User;

import java.util.List;

public interface DialogRepository extends JpaRepository<Dialog, Long>{
    List<Dialog> findAllByParticipantsContaining(User user);
}
