package net.dnlcore.smittenkitten.controllers;

import net.dnlcore.smittenkitten.models.User;
import net.dnlcore.smittenkitten.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String displayRegisterUser(Model model) {
        model.addAttribute("title", "register");
        model.addAttribute(new User());
        model.addAttribute("password", "");
        model.addAttribute("confirmPassword", "");
        return ("register");
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processUserRegistration(Model model, @Valid User newUser, Errors errors) {
        userDao.save(newUser);
        return ("register");
    }
}


