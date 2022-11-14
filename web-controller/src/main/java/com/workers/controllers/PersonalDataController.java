package com.workers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalDataController {

    @GetMapping("/personal-data")
    public String index () {
        return "personal-data";
    }

}
