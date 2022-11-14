package com.workers.usecase.impl.personaldata;

import com.workers.entities.PersonalDataEntity;
import com.workers.entities.UserEntity;
import com.workers.gateway.PersonalDataGateway;
import com.workers.gateway.UserGateway;
import com.workers.gateway.exceptions.UserNotFoundException;
import com.workers.presenters.PersonalDataPresenter;
import com.workers.presenters.models.personaldata.PersonalDataInput;
import com.workers.presenters.models.personaldata.PersonalDataOutput;
import com.workers.usecase.PersonalDataService;
import com.workers.usecase.impl.helper.EmailHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    private PersonalDataGateway personalDataGateway;

    private UserGateway userGateway;

    private PersonalDataPresenter presenter;

    public PersonalDataServiceImpl(PersonalDataGateway personalDataGateway,
                                   UserGateway userGateway,
                                   PersonalDataPresenter presenter) {
        this.personalDataGateway = personalDataGateway;
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

    @Override
    public PersonalDataOutput save(PersonalDataInput personalDataInput) {

        if (checkIsValidEmail(personalDataInput.getUserEmail())) {
            return presenter.createError(personalDataInput, "register.error.invalid.email");
        }

        if (checkIsValidName(personalDataInput.getName())) {
            return presenter.createError(personalDataInput, "register.error.invalid.name");
        }

        if (checkIsDocumentNumberValid(personalDataInput.getDocumentNumber())) {
            return presenter.createError(personalDataInput, "register.error.invalid.document.number");
        }

        if (checkIsBirthdateValid(personalDataInput.getBirthdate())) {
            return presenter.createError(personalDataInput, "register.error.invalid.birthdate");
        }

        try {

            UserEntity userEntity = userGateway.findByEmail(personalDataInput.getUserEmail());

            PersonalDataEntity entity = new PersonalDataEntity();
            entity.setName(personalDataInput.getName());
            entity.setBirthdate(personalDataInput.getBirthdate());
            entity.setDocumentNumber(personalDataInput.getDocumentNumber());
            entity.setUser(userEntity);

            entity = personalDataGateway.save(entity);

            return presenter.createSuccess(entity, "register.save.success");

        } catch (UserNotFoundException e) {
            return presenter.createError(personalDataInput, "register.error.user.not.found");
        }

    }

    private boolean checkIsValidEmail(String email) {
        return EmailHelper.checkIsValidEmail(email);
    }

    private boolean checkIsBirthdateValid(Date birthdate) {
        return birthdate != null;
    }

    private boolean checkIsDocumentNumberValid(String documentNumber) {
        return !StringUtils.hasText(documentNumber);
    }

    private boolean checkIsValidName(String name) {
        return !StringUtils.hasText(name);
    }

}
