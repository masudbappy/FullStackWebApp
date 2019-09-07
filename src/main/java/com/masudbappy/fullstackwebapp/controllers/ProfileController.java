package com.masudbappy.fullstackwebapp.controllers;

import com.masudbappy.fullstackwebapp.entities.User;
import com.masudbappy.fullstackwebapp.services.TaskService;
import com.masudbappy.fullstackwebapp.services.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal){
        String email = principal.getName();
        User user = userService.findOne(email);
        model.addAttribute("tasks", taskService.findUserTask(user));

        return "views/profile";
    }
}
