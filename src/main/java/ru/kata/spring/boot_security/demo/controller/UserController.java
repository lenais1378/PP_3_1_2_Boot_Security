package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;


@Controller
public class UserController {
    private UserServiceImp userServiceImp;

    @Autowired
    public void setUserService(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping(value = "/")
    public String welcome() {
        return "redirect:/user";
    }


}