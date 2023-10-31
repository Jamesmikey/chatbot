package tz.ac.udsm.chatBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tz.ac.udsm.chatBot.models.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {

}
