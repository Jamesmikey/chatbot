package tz.ac.udsm.chatBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tz.ac.udsm.chatBot.models.Address;
import tz.ac.udsm.chatBot.models.User;


public interface AddressRepository extends JpaRepository<Address,Long> {
}
