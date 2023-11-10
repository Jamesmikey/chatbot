package tz.ac.udsm.chatBot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.chatBot.models.User;
import tz.ac.udsm.chatBot.services.UserService;


import javax.naming.OperationNotSupportedException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }


    @PostMapping
    public String add(@RequestBody User user) throws OperationNotSupportedException {

        userService.add(user);

        return "User ameongezwa";
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public String edit( @PathVariable Long id,@RequestBody User newUser) throws OperationNotSupportedException {

        userService.edit(id,newUser);

        return "User with ID "+id+" edited";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Long id) throws OperationNotSupportedException {

        userService.deleteById(id);

        return id+" User deleted ";
    }
}
