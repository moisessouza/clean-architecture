package com.clean.architecture.restservice;

import com.clean.architecture.dto.AnyDTO;
import com.clean.architecture.presenters.models.AnyModel;
import com.clean.architecture.usecase.AnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private AnyService anyService;

    @GetMapping("/greeting")
    public AnyModel greeting() {
        AnyModel anyModel = anyService.executeSubstringForBusinessRules();
        return anyModel;
    }

}