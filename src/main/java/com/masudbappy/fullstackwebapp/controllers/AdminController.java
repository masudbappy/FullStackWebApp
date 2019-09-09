package com.masudbappy.fullstackwebapp.controllers;

import com.masudbappy.fullstackwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/deleteUser/{email}")
    public String deleteUser(@PathVariable("email") String email, BindingResult bindingResult, HttpSession session){
            if (bindingResult.hasErrors()){
                return "redirect:/users";
            }
//        String email1 = (String) session.getAttribute("email");
            userService.deleteUser(email);
            return "redirect:/users";
        }

}
