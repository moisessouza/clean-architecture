package com.workers.controllers;

import com.workers.models.request.UserPostRequest;
import com.workers.models.response.UserPostResponse;
import com.workers.presenters.models.user.UserInputImpl;
import com.workers.presenters.models.user.UserOutputImpl;
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
        return new ModelAndView("user", "user", new UserPostResponse());
    }

    @PostMapping(value = "/user")
    public ModelAndView save(UserPostRequest model) {

        String passwordEncoded = null;

        if (StringUtils.hasText(model.getPassword())) {
            passwordEncoded = passwordEncoder.encode(model.getPassword());
        }

        UserInputImpl input = new UserInputImpl(
                model.getId(),
                model.getEmail(),
                passwordEncoded
        );

        UserOutputImpl userOutput = (UserOutputImpl) userService.save(input);

        UserPostResponse response = new UserPostResponse(
                userOutput.hasError(),
                userOutput.getMessage(),
                userOutput.getForward(),
                userOutput.getEmail(),
                userOutput.getPassword()
        );

        return new ModelAndView(response.getForward(), "user", response);
    }

}