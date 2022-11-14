package com.workers.controllers;

import com.workers.helper.DateHelper;
import com.workers.models.PersonalDataModel;
import com.workers.presenters.models.personaldata.PersonalDataInputImpl;
import com.workers.presenters.models.personaldata.PersonalDataOutputImpl;
import com.workers.usecase.PersonalDataService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonalDataController {

    private PersonalDataService personalDataService;

    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @GetMapping("/personal-data")
    public ModelAndView index () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonalDataOutputImpl output = (PersonalDataOutputImpl) personalDataService.findByEmail(authentication.getName());
        return new ModelAndView(output.getForward(), "personalData", output);
    }

    @PostMapping(value = "/personal-data")
    public ModelAndView save(PersonalDataModel model) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        PersonalDataInputImpl input = new PersonalDataInputImpl();

        input.setName(model.getName());
        input.setDocumentNumber(model.getDocumentNumber());
        input.setBirthdate(DateHelper.convertStringToDate(model.getBirthdate()));
        input.setUserEmail(authentication.getName());

        PersonalDataOutputImpl output = (PersonalDataOutputImpl) personalDataService.save(input);

        return new ModelAndView(output.getForward(), "personalData", output);

    }


}
