package com.workers.controllers;

import com.workers.models.UserPostModel;
import com.workers.presenters.models.UserInputImpl;
import com.workers.presenters.models.UserOutputImpl;
import com.workers.usecase.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ModelAndView index() {
        return new ModelAndView("user", "user", new UserOutputImpl());
    }

    @PostMapping(value = "/user")
    public ModelAndView save(UserPostModel userPostModel) {

        UserInputImpl input = new UserInputImpl(userPostModel.getEmail(), userPostModel.getPassword());

        UserOutputImpl userOutput = (UserOutputImpl) userService.save(input);

        return new ModelAndView(userOutput.getForward(), "user", userOutput);
    }

}