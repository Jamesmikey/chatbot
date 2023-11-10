package tz.ac.udsm.chatBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tz.ac.udsm.chatBot.models.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
