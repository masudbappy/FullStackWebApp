package com.masudbappy.fullstackwebapp.controllers;

import com.masudbappy.fullstackwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("users",userService.findAll());
        return "views/list";
    }
}
