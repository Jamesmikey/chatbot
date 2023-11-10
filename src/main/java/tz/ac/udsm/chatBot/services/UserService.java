package tz.ac.udsm.chatBot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tz.ac.udsm.chatBot.models.Address;
import tz.ac.udsm.chatBot.models.Message;
import tz.ac.udsm.chatBot.models.Role;
import tz.ac.udsm.chatBot.models.User;
import tz.ac.udsm.chatBot.repository.AddressRepository;
import tz.ac.udsm.chatBot.repository.RoleRepository;
import tz.ac.udsm.chatBot.repository.UserRepository;


import javax.naming.OperationNotSupportedException;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public List<User> getAll(){

        List<User> users=userRepository.findAll();

//        for (User user:users){
//            user.getAddress().setUser(null);
//            for(Message message:user.getMessages()){
//                message.setUser(null);
//            }
//        }

        return users;
    }


    public void add(User newUser) throws OperationNotSupportedException {

        Set<Role> databaseRoles=new HashSet<>();

        for (Role role:newUser.getRoles()){
            Role existRole=roleRepository.findById(role.getId()).orElseThrow(() -> new OperationNotSupportedException("Role not found"));
            databaseRoles.add(existRole);
        }

        newUser.setPassword(encoder.encode(newUser.getPassword()));

        newUser.setRoles(databaseRoles);

        userRepository.save(newUser);
    }


    public void edit(Long id,User newUser) throws OperationNotSupportedException {

            User existUser= userRepository.findById(id).orElseThrow(() -> new OperationNotSupportedException("User not exist"));

            existUser.setName(newUser.getName());

            existUser.setEmail(newUser.getEmail());

            userRepository.save(existUser);



//        for(User user:users){
//            if(user.getId().equals(id)){
//                user.setName(newUser.getName());
//                user.setEmail(newUser.getEmail());
//                break;
//            }
//        }

    }

    public void deleteById(Long id) throws OperationNotSupportedException {

        User existUser= userRepository.findById(id).orElseThrow(() -> new OperationNotSupportedException("User not exist"));

//        userRepository.deleteById(id);
        userRepository.delete(existUser);



//        for(User user:users){
//            if(user.getId().equals(id)){
//                users.remove(user);
//                break;
//            }
//        }
    }

}
