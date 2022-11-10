package com.workers.controllers;

import com.workers.models.UserPostModel;
import com.workers.presenters.models.UserInputImpl;
import com.workers.presenters.models.UserOutputImpl;
import com.workers.usecase.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/user")
    public ModelAndView index() {
        return new ModelAndView("user", "user", new UserOutputImpl());
    }

    @PostMapping(value = "/user")
    public ModelAndView save(UserPostModel userPostModel) {

        String passwordEncoded = null;

        if (StringUtils.hasText(userPostModel.getPassword())) {
            passwordEncoded = passwordEncoder.encode(userPostModel.getPassword())
        }

        UserInputImpl input = new UserInputImpl(
                userPostModel.getEmail(),
                passwordEncoded
        );

        UserOutputImpl userOutput = (UserOutputImpl) userService.save(input);

        return new ModelAndView(userOutput.getForward(), "user", userOutput);
    }

}