package com.workers.presenters.impl;

import com.workers.presenters.UserPresenter;
import com.workers.presenters.models.UserInput;
import com.workers.presenters.models.UserOutput;
import com.workers.presenters.models.UserOutputImpl;
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
    public UserOutput createSuccess(UserInput userInput, String messageCode) {
        UserOutputImpl impl = new UserOutputImpl(false, getMessage(messageCode), "user", userInput.getEmail(), userInput.getPassword());
        return impl;
    }

    private String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null,  Locale.getDefault());
    }
}
