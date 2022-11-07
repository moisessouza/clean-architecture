package com.workers.restservice;

import com.workers.presenters.models.UserInputImpl;
import com.workers.presenters.models.UserOutput;
import com.workers.usecase.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnyController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public UserOutput postAny(@RequestBody String value) {

        UserInputImpl input = new UserInputImpl();
        input.setValue(value);

        UserOutput userOutput = userService.save(input);

        return userOutput;
    }

}