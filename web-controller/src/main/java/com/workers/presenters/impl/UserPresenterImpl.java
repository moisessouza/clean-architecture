package com.workers.presenters.impl;

import com.workers.entities.UserEntity;
import com.workers.presenters.UserPresenter;
import com.workers.presenters.models.user.UserInput;
import com.workers.presenters.models.user.UserOutput;
import com.workers.presenters.models.user.UserOutputImpl;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserPresenterImpl implements UserPresenter {

    private MessageSource messageSource;
    public UserPresenterImpl (MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public UserOutput createError(UserInput userInput, String messageCode) {
        UserOutputImpl impl = new UserOutputImpl(true, getMessage(messageCode), "user", userInput.getEmail(), userInput.getPassword());
        return impl;
    }

    @Override
    public UserOutput createValidateSuccess() {
        return  new UserOutputImpl(false, null, null, null, null);
    }

    @Override
    public UserOutput createSuccess(UserEntity userEntity, String messageCode) {
        UserOutputImpl impl = new UserOutputImpl(false, getMessage(messageCode), "user", userEntity.getEmail(), userEntity.getPassword());
        return impl;
    }

    @Override
    public UserOutput findUserSuccess(UserEntity userEntity, String messageCode) {
        UserOutputImpl impl = new UserOutputImpl(false, getMessage(messageCode), "user", userEntity.getEmail(), userEntity.getPassword());;
        return impl;
    }

    @Override
    public UserOutput findUserFail(String messageCode) {
        UserOutputImpl impl = new UserOutputImpl(true, getMessage(messageCode), "user", null, null);
        return impl;
    }

    private String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null,  Locale.getDefault());
    }
}
