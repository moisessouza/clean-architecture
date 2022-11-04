package com.workers.controllers;

import com.workers.presenters.models.AnyInputImpl;
import com.workers.presenters.models.AnyOutput;
import com.workers.usecase.AnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AnyController {

    @Autowired
    private AnyService anyService;

    @GetMapping("/any")
    public String getAny(Model model) {
        AnyOutput anyOutput = anyService.executeSubstringForBusinessRules();

        model.addAttribute("any", anyOutput);

        return "any";
    }

    @PostMapping("/any")
    public AnyOutput postAny(@RequestBody String value) {

        AnyInputImpl input = new AnyInputImpl();
        input.setValue(value);

        AnyOutput anyOutput = anyService.save(input);

        return anyOutput;
    }

}