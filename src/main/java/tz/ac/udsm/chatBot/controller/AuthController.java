package tz.ac.udsm.chatBot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import tz.ac.udsm.chatBot.models.User;
import tz.ac.udsm.chatBot.services.UserService;

import javax.naming.OperationNotSupportedException;

/**
 * @author James S. Michael
 * @created 09-11-2023 17:38:07
 */

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage(ModelAndView modelAndView){

        modelAndView.setViewName("auths/login");

        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView){

        User newUser=new User();
        newUser.setName("James");

        modelAndView.addObject("user",newUser);

        modelAndView.setViewName("auths/register");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute User user, ModelAndView modelAndView) throws OperationNotSupportedException {

        userService.add(user);

        modelAndView.setViewName("auths/register");

        return modelAndView;
    }
}
