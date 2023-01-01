package com.projects.recipesservice.controller;

import com.projects.recipesservice.entity.User;
import com.projects.recipesservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/register")
    private User saveUser(@RequestBody @Validated User user){
        return userService.saveUser(user);
    }
}
