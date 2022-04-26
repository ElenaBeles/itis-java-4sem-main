package ru.itis.chat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.chat.Models.Msg;

public interface MsgRepository extends JpaRepository<Msg, Long> {
}
