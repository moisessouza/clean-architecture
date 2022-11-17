package com.workers.presenters.impl;

import com.workers.entities.AddressEntity;
import com.workers.presenters.AddressPresenter;
import com.workers.presenters.models.address.AddressInput;
import com.workers.presenters.models.address.AddressOutput;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AddressPresenterImpl implements AddressPresenter {

    private MessageSource messageSource;

    public AddressPresenterImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public AddressOutput createError(AddressInput addressInput, String messageCode) {
        return null;
    }

    @Override
    public AddressOutput createSuccess(AddressEntity entity, String messageCode) {
        return null;
    }

    @Override
    public AddressOutput findByEmailError(String email, String messageCode) {
        return null;
    }

    @Override
    public AddressOutput findByEmailSuccess(AddressEntity entity) {
        return null;
    }

    private String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null,  Locale.getDefault());
    }

}
