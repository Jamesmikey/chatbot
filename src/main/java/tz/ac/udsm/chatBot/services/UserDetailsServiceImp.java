package tz.ac.udsm.chatBot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tz.ac.udsm.chatBot.configs.UserDetailsImp;
import tz.ac.udsm.chatBot.models.Role;
import tz.ac.udsm.chatBot.models.User;
import tz.ac.udsm.chatBot.repository.UserRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author James S. Michael
 * @created 10-11-2023 16:58:09
 */

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional=userRepository.findByEmail(username);
        User user=userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<String> roles = new ArrayList<>();

        if(user.getRoles()!=null){

            for (Role role : user.getRoles()) {
                String name = role.getName();
                roles.add(name);
            }
        }

        UserDetails userDetails=new UserDetailsImp(user.getEmail(),user.getPassword(),roles);

        return userDetails;
    }
}
