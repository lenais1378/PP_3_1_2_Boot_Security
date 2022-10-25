package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;

import java.util.Set;

@Controller
//@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public AdminController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/admin")
    public String showAllUsers(Model model) {
        model.addAttribute("usersList", userServiceImp.listUsers());
        model.addAttribute("user", new User());
        model.addAttribute("roles", userServiceImp.roles());
        return "admin";
    }

//    @GetMapping("/new")
//    public String createUser(@ModelAttribute("user") User user, Model model) {
//        model.addAttribute("roles", new Role(2L, "USER"));
//        return "admin";
//    }

    @GetMapping(value = "/admin/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }
    @PostMapping("/admin/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImp.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}")
    public String userInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServiceImp.userById(id));

        return "useradmin";
    }


    @GetMapping(value = "/admin/update/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userServiceImp.userById(id);
        model.addAttribute("user", user);
        return "editUser";
    }
    @PostMapping("/admin/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userServiceImp.updateUser(user);
        return "redirect:/admin";
    }


    @RequestMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImp.delete(id);
        return "redirect:/admin";
    }
}
