package net.dnlcore.smittenkitten.controllers;

import net.dnlcore.smittenkitten.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

    @Controller
    public class RootController {
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String index() {
            return ("indexold");
        }
    }

