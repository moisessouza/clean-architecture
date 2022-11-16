package com.workers.facade.impl;

import com.workers.facade.PersonalDataFacade;
import com.workers.helper.DateHelper;
import com.workers.models.request.PersonalDataRequest;
import com.workers.models.response.PersonalDataResponse;
import com.workers.presenters.models.personaldata.PersonalDataInputImpl;
import com.workers.presenters.models.personaldata.PersonalDataOutputImpl;
import com.workers.presenters.models.phone.PhoneInputImpl;
import com.workers.presenters.models.phone.PhoneOutputImpl;
import com.workers.usecase.PersonalDataService;
import com.workers.usecase.PhoneService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class PersonalDataFacadeImpl implements PersonalDataFacade {

    private PersonalDataService personalDataService;

    private PhoneService phoneService;

    public PersonalDataFacadeImpl (PersonalDataService personalDataService, PhoneService phoneService) {
        this.personalDataService = personalDataService;
        this.phoneService = phoneService;
    }

    @Override
    public PersonalDataResponse findByEmail(String email) {

        PersonalDataOutputImpl personalDataOutput = (PersonalDataOutputImpl) personalDataService.findByEmail(email);
        PhoneOutputImpl phoneOutput = (PhoneOutputImpl) phoneService.findByEmail(email);

        PersonalDataResponse response = createPersonalDataResponse(personalDataOutput, phoneOutput);
        return response;

    }

    @Override
    public PersonalDataResponse save(Authentication authentication, PersonalDataRequest model) throws Exception {

        PersonalDataInputImpl personalDataInput = createPersonalDataInput(authentication, model);
        PhoneInputImpl phoneInput = createPhoneInput(authentication, model);

        PersonalDataOutputImpl personalDataOutput = (PersonalDataOutputImpl) personalDataService.saveByUserEmail(personalDataInput);

        if (personalDataOutput.isError()) {
            return createError(model, personalDataOutput.getMessage());
        }

        PhoneOutputImpl phoneOutput = (PhoneOutputImpl) phoneService.saveByUserEmail(phoneInput);

        if (phoneOutput.isError()) {
            return createError(model, phoneOutput.getMessage());
        }

        PersonalDataResponse response = createPersonalDataResponse(personalDataOutput, phoneOutput);

        return response;

    }

    private PersonalDataInputImpl createPersonalDataInput(Authentication authentication, PersonalDataRequest model) throws Exception {

        PersonalDataInputImpl personalDataInput = new PersonalDataInputImpl();

        personalDataInput.setName(model.getName());
        personalDataInput.setDocumentNumber(model.getDocumentNumber());
        personalDataInput.setBirthdate(DateHelper.convertStringToDate(model.getBirthdate()));
        personalDataInput.setUserEmail(authentication.getName());

        return personalDataInput;

    }
    private PhoneInputImpl createPhoneInput(Authentication authentication, PersonalDataRequest model) {

        PhoneInputImpl phoneInput = new PhoneInputImpl();

        phoneInput.setDdi(model.getDdi());
        phoneInput.setDdd(model.getDdd());
        phoneInput.setPhoneNumber(model.getPhoneNumber());
        phoneInput.setUserEmail(authentication.getName());

        return phoneInput;

    }

    private PersonalDataResponse createError(PersonalDataRequest request, String message) {

        PersonalDataResponse response = new PersonalDataResponse();

        response.setName(request.getName());
        response.setDocumentNumber(request.getDocumentNumber());
        response.setBirthdate(request.getBirthdate());
        response.setPhoneNumber(request.getPhoneNumber());
        response.setDdd(request.getDdd());
        response.setDdi(request.getDdi());
        response.setForward("personal-data");
        response.setMessage(message);

        return response;

    }
    private PersonalDataResponse createPersonalDataResponse(PersonalDataOutputImpl personalDataOutput, PhoneOutputImpl phoneOutput) {

        PersonalDataResponse response = new PersonalDataResponse();

        response.setName(personalDataOutput.getName());
        response.setDocumentNumber(personalDataOutput.getDocumentNumber());
        response.setBirthdate(personalDataOutput.getBirthdate());
        response.setPhoneNumber(phoneOutput.getPhoneNumber());
        response.setDdd(phoneOutput.getDdd());
        response.setDdi(phoneOutput.getDdi());
        response.setForward("personal-data");
        response.setMessage(personalDataOutput.getMessage());

        return response;

    }


}
