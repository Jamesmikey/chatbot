package tz.ac.udsm.chatBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tz.ac.udsm.chatBot.models.Role;
import tz.ac.udsm.chatBot.models.User;


public interface RoleRepository extends JpaRepository<Role,Long> {
}
