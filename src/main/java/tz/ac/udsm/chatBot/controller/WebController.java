package tz.ac.udsm.chatBot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tz.ac.udsm.chatBot.models.User;
import tz.ac.udsm.chatBot.services.UserService;

import java.util.List;

/**
 * @author James S. Michael
 * @created 07-11-2023 16:57:47
 */

@Controller
@RequestMapping("web")
public class WebController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView){

        List<User> users=userService.getAll();


        modelAndView.addObject("name","Home Page");

        modelAndView.addObject("users",users);

        modelAndView.setViewName("pages/index");

        return modelAndView;

    }
}
