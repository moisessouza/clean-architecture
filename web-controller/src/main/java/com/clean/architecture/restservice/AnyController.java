package com.clean.architecture.restservice;

import com.clean.architecture.presenters.models.AnyModel;
import com.clean.architecture.usecase.AnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnyController {

    @Autowired
    private AnyService anyService;

    @GetMapping("/any")
    public AnyModel any() {
        AnyModel anyModel = anyService.executeSubstringForBusinessRules();
        return anyModel;
    }

}