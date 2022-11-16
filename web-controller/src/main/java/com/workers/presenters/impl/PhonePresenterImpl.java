package com.workers.presenters.impl;

import com.workers.entities.PhoneEntity;
import com.workers.presenters.PhonePresenter;
import com.workers.presenters.models.phone.PhoneInput;
import com.workers.presenters.models.phone.PhoneOutput;
import com.workers.presenters.models.phone.PhoneOutputImpl;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class PhonePresenterImpl implements PhonePresenter {

    private MessageSource messageSource;

    public PhonePresenterImpl (MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public PhoneOutput createError(PhoneInput phoneInput, String messageCode) {
        PhoneOutputImpl impl = new PhoneOutputImpl(
                true,
                getMessage(messageCode),
                phoneInput.getId(),
                phoneInput.getDdi(),
                phoneInput.getDdd(),
                phoneInput.getPhoneNumber(),
                phoneInput.getUserEmail());
        return impl;
    }

    @Override
    public PhoneOutput createSuccess(PhoneEntity entity, String messageCode) {
        PhoneOutputImpl impl = new PhoneOutputImpl(
                false,
                getMessage(messageCode),
                entity.getId(),
                entity.getDdi(),
                entity.getDdd(),
                entity.getPhoneNumber(),
                entity.getPersonalData().getUser().getEmail());
        return impl;
    }

    @Override
    public PhoneOutput findByEmailError(String email, String messageCode) {
        PhoneOutputImpl impl = new PhoneOutputImpl(
                true,
                getMessage(messageCode),
                null,
                null,
                null,
                null,
                email);
        return impl;
    }

    @Override
    public PhoneOutput findByEmailSuccess(PhoneEntity entity) {
        PhoneOutputImpl impl = new PhoneOutputImpl(
                false,
                null,
                entity.getId(),
                entity.getDdi(),
                entity.getDdd(),
                entity.getPhoneNumber(),
                entity.getPersonalData().getUser().getEmail());
        return impl;
    }

    private String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null,  Locale.getDefault());
    }
}
