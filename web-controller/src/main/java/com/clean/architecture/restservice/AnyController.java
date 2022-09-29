package com.clean.architecture.restservice;

import com.clean.architecture.presenters.models.AnyInput;
import com.clean.architecture.presenters.models.AnyInputImpl;
import com.clean.architecture.presenters.models.AnyOutput;
import com.clean.architecture.usecase.AnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnyController {

    @Autowired
    private AnyService anyService;

    @GetMapping("/any")
    public AnyOutput getAny() {
        AnyOutput anyOutput = anyService.executeSubstringForBusinessRules();
        return anyOutput;
    }

    @PostMapping("/any")
    public AnyOutput postAny(@RequestBody String value) {

        AnyInputImpl input = new AnyInputImpl();
        input.setValue(value);

        AnyOutput anyOutput = anyService.saveAndExecuteSubstringForBusinessRules(input);

        return anyOutput;
    }

}