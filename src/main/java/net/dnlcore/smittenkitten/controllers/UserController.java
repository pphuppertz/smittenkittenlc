package net.dnlcore.smittenkitten.controllers;

import net.dnlcore.smittenkitten.models.User;
import net.dnlcore.smittenkitten.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.awt.*;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String displayRegisterUser(Model model, String passwordMatchError) {
        model.addAttribute("title", "register");
        model.addAttribute(new User());
        model.addAttribute("password", "");
        model.addAttribute("confirmPassword", "");
        return ("register");
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processUserRegistration(@Valid User newUser, BindingResult bindingResult, @RequestParam String password, @RequestParam String confirmPassword, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        //todo: verify password
        try {
            newUser.setPassword(password, confirmPassword);
        }
        catch (Exception e)
        {
            ObjectError error = new ObjectError("password","Passwords do not match.");
            bindingResult.addError(error);
            return "register";
        }
        userDao.save(newUser);
        return ("redirect:login");
    }

    @RequestMapping(value="login", method=RequestMethod.GET)
    public String loginUser() {
        return("login");
    }

    @RequestMapping(value="login", method=RequestMethod.POST)
    public String loginUser(@RequestParam String userName, @RequestParam String password, Model model) {
        User user = userDao.findByName(userName).get(0);
        if (user.verifyPassword(password)) {
            return("redirect:");
        }
        return("login");
    }

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "All unsmitten kittens");
        return("index");
    }

    @RequestMapping(value="view/{userId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int userId){
        //this is a change
        User user = userDao.findById(userId).get();
        model.addAttribute("user", user);
        return "view";
    }
}


