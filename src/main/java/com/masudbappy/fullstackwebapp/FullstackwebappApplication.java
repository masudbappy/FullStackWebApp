package com.masudbappy.fullstackwebapp;

import com.masudbappy.fullstackwebapp.entities.User;
import com.masudbappy.fullstackwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullstackwebappApplication implements CommandLineRunner{

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(FullstackwebappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        {
            User newAdmin = new User("admin@gmail.com","Admin","admin");
            userService.createAdmin(newAdmin);
        }
    }
}
