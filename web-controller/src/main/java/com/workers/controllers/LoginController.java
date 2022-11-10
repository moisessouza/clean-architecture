package com.workers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String  index() {
        return "login";
    }

    @PostMapping("/login")
    public String  login() {
        return "home";
    }
}
