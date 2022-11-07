package com.workers.controllers;

import com.workers.presenters.models.UserInputImpl;
import com.workers.presenters.models.UserOutput;
import com.workers.usecase.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String index() {
        return "user";
    }

    @PostMapping("/user")
    public UserOutput save(@RequestBody String value) {

        UserInputImpl input = new UserInputImpl();
        input.setValue(value);

        UserOutput userOutput = userService.save(input);

        return userOutput;
    }

}