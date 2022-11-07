package com.workers.controllers;

import com.workers.models.UserPostModel;
import com.workers.presenters.models.UserInputImpl;
import com.workers.presenters.models.UserOutput;
import com.workers.usecase.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public UserOutput save(UserPostModel userPostModel) {

        UserInputImpl input = new UserInputImpl(userPostModel.getEmail(), userPostModel.getPassword());

        UserOutput userOutput = userService.save(input);

        return userOutput;
    }

}