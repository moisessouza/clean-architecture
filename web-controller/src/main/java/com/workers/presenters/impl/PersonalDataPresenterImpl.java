package com.workers.presenters.impl;

import com.workers.entities.PersonalDataEntity;
import com.workers.helper.DateHelper;
import com.workers.presenters.PersonalDataPresenter;
import com.workers.presenters.models.personaldata.PersonalDataInput;
import com.workers.presenters.models.personaldata.PersonalDataOutput;
import com.workers.presenters.models.personaldata.PersonalDataOutputImpl;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class PersonalDataPresenterImpl implements PersonalDataPresenter {

    private MessageSource messageSource;
    public PersonalDataPresenterImpl (MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public PersonalDataOutput createError(PersonalDataInput personalDataInput, String messageCode) {

        PersonalDataOutputImpl impl = new PersonalDataOutputImpl();

        impl.setName(personalDataInput.getName());
        impl.setDocumentNumber(personalDataInput.getDocumentNumber());
        impl.setBirthdate(DateHelper.convertDateToString(personalDataInput.getBirthdate()));
        impl.setForward("personal-data");
        impl.setHasError(true);
        impl.setMessage(getMessage(messageCode));

        return impl;
    }

    @Override
    public PersonalDataOutput createSuccess(PersonalDataEntity entity, String messageCode) {

        PersonalDataOutputImpl impl = new PersonalDataOutputImpl();

        impl.setName(entity.getName());
        impl.setDocumentNumber(entity.getDocumentNumber());
        impl.setBirthdate(DateHelper.convertDateToString(entity.getBirthdate()));
        impl.setForward("personal-data");
        impl.setHasError(true);
        impl.setMessage(getMessage(messageCode));

        return impl;


    }

    @Override
    public PersonalDataOutput findByEmailError(String email, String messageCode) {

        PersonalDataOutputImpl impl = new PersonalDataOutputImpl();

        impl.setForward("personal-data");
        impl.setHasError(true);
        impl.setMessage(getMessage(messageCode));

        return impl;

    }

    @Override
    public PersonalDataOutput findByEmailSuccess(PersonalDataEntity entity) {

        PersonalDataOutputImpl impl = new PersonalDataOutputImpl();
        impl.setForward("personal-data");
        impl.setHasError(false);

        if (entity == null) {
            return impl;
        }

        impl.setName(entity.getName());
        impl.setDocumentNumber(entity.getDocumentNumber());
        impl.setBirthdate(DateHelper.convertDateToString(entity.getBirthdate()));

        return impl;

    }

    private String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null,  Locale.getDefault());
    }

}
