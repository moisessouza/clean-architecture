package com.workers.controllers;

import com.workers.facade.PersonalDataFacade;
import com.workers.models.request.PersonalDataRequest;
import com.workers.models.response.PersonalDataResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonalDataController {

    PersonalDataFacade personalDataFacade;

    public PersonalDataController(PersonalDataFacade personalDataFacade) {
        this.personalDataFacade = personalDataFacade;
    }

    @GetMapping("/personal-data")
    public ModelAndView index () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonalDataResponse output = (PersonalDataResponse) personalDataFacade.findByEmail(authentication.getName());
        return new ModelAndView(output.getForward(), "personalData", output);
    }

    @PostMapping(value = "/personal-data")
    public ModelAndView save(PersonalDataRequest model) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonalDataResponse output = (PersonalDataResponse) personalDataFacade.save(authentication, model);
        return new ModelAndView(output.getForward(), "personalData", output);
    }


}
