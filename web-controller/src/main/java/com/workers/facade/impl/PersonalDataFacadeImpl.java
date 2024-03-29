package com.workers.facade.impl;

import com.workers.facade.PersonalDataFacade;
import com.workers.helper.DateHelper;
import com.workers.models.request.PersonalDataRequest;
import com.workers.models.response.PersonalDataResponse;
import com.workers.presenters.models.address.AddressInputImpl;
import com.workers.presenters.models.address.AddressOutputImpl;
import com.workers.presenters.models.personaldata.PersonalDataInputImpl;
import com.workers.presenters.models.personaldata.PersonalDataOutputImpl;
import com.workers.presenters.models.phone.PhoneInputImpl;
import com.workers.presenters.models.phone.PhoneOutputImpl;
import com.workers.usecase.AddressUseCase;
import com.workers.usecase.PersonalDataUseCase;
import com.workers.usecase.PhoneUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class PersonalDataFacadeImpl implements PersonalDataFacade {

    private PersonalDataUseCase personalDataUseCase;

    private PhoneUseCase phoneUseCase;

    private AddressUseCase addressUseCase;

    public PersonalDataFacadeImpl (PersonalDataUseCase personalDataUseCase, PhoneUseCase phoneUseCase, AddressUseCase addressUseCase) {
        this.personalDataUseCase = personalDataUseCase;
        this.phoneUseCase = phoneUseCase;
        this.addressUseCase = addressUseCase;
    }

    @Override
    public PersonalDataResponse findByEmail(String email) {

        PersonalDataOutputImpl personalDataOutput = (PersonalDataOutputImpl) personalDataUseCase.findByEmail(email);
        PhoneOutputImpl phoneOutput = (PhoneOutputImpl) phoneUseCase.findByEmail(email);
        AddressOutputImpl addressOutput = (AddressOutputImpl) addressUseCase.findByEmail(email);

        PersonalDataResponse response = createPersonalDataResponse(personalDataOutput, phoneOutput, addressOutput);
        return response;

    }

    @Override
    public PersonalDataResponse save(Authentication authentication, PersonalDataRequest model) throws Exception {

        PersonalDataInputImpl personalDataInput = createPersonalDataInput(authentication, model);
        PhoneInputImpl phoneInput = createPhoneInput(authentication, model);
        AddressInputImpl addressInput = createAddressInput(authentication, model);

        PersonalDataOutputImpl personalDataOutput = (PersonalDataOutputImpl) personalDataUseCase.saveByUserEmail(personalDataInput);

        if (personalDataOutput.isError()) {
            return createError(model, personalDataOutput.getMessage());
        }

        PhoneOutputImpl phoneOutput = (PhoneOutputImpl) phoneUseCase.saveByUserEmail(phoneInput);

        if (phoneOutput.isError()) {
            return createError(model, phoneOutput.getMessage());
        }

        AddressOutputImpl addressOutput = (AddressOutputImpl) addressUseCase.saveByEmail(addressInput);

        if (addressOutput.isError()) {
            return createError(model, addressOutput.getMessage());
        }

        PersonalDataResponse response = createPersonalDataResponse(personalDataOutput, phoneOutput, addressOutput);

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
    private AddressInputImpl createAddressInput(Authentication authentication, PersonalDataRequest model) {

        AddressInputImpl input = new AddressInputImpl();

        input.setCountry(model.getCountry());
        input.setZipPostal(model.getZipPostal());
        input.setState(model.getState());
        input.setCity(model.getCity());
        input.setNeighborhood(model.getNeighborhood());
        input.setStreet(model.getStreet());
        input.setNumber(model.getNumber());
        input.setComplement(model.getComplement());
        input.setUserEmail(authentication.getName());

        return input;

    }

    private PersonalDataResponse createError(PersonalDataRequest request, String message) {

        PersonalDataResponse response = new PersonalDataResponse();

        response.setName(request.getName());
        response.setDocumentNumber(request.getDocumentNumber());
        response.setBirthdate(request.getBirthdate());

        response.setPhoneNumber(request.getPhoneNumber());
        response.setDdd(request.getDdd());
        response.setDdi(request.getDdi());

        response.setCountry(request.getCountry());
        response.setZipPostal(request.getZipPostal());
        response.setState(request.getState());
        response.setCity(request.getCity());
        response.setNeighborhood(request.getNeighborhood());
        response.setStreet(request.getStreet());
        response.setNumber(request.getNumber());
        response.setComplement(request.getComplement());

        response.setForward("personal-data");
        response.setMessage(message);

        return response;

    }
    private PersonalDataResponse createPersonalDataResponse(PersonalDataOutputImpl personalDataOutput, PhoneOutputImpl phoneOutput, AddressOutputImpl addressOutput) {

        PersonalDataResponse response = new PersonalDataResponse();

        response.setName(personalDataOutput.getName());
        response.setDocumentNumber(personalDataOutput.getDocumentNumber());
        response.setBirthdate(personalDataOutput.getBirthdate());

        response.setPhoneNumber(phoneOutput.getPhoneNumber());
        response.setDdd(phoneOutput.getDdd());
        response.setDdi(phoneOutput.getDdi());

        response.setCountry(addressOutput.getCountry());
        response.setZipPostal(addressOutput.getZipPostal());
        response.setState(addressOutput.getState());
        response.setCity(addressOutput.getCity());
        response.setNeighborhood(addressOutput.getNeighborhood());
        response.setStreet(addressOutput.getStreet());
        response.setNumber(addressOutput.getNumber());
        response.setComplement(addressOutput.getComplement());

        response.setForward("personal-data");
        response.setMessage(personalDataOutput.getMessage());

        return response;

    }


}
