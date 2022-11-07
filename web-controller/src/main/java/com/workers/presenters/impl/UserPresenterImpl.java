package com.workers.presenters.impl;

import com.workers.presenters.models.UserInput;
import com.workers.presenters.models.UserOutputImpl;
import com.workers.presenters.UserPresenter;
import com.workers.presenters.models.UserOutput;
import org.springframework.stereotype.Service;

@Service
public class UserPresenterImpl implements UserPresenter {

    @Override
    public UserOutput createError(UserInput userInput, String message) {
        UserOutputImpl impl = new UserOutputImpl(true, message, "user", userInput.getEmail(), userInput.getPassword());
        return impl;
    }

    @Override
    public UserOutput createValidateSuccess() {
        return  new UserOutputImpl(false, null, null, null, null);
    }

    @Override
    public UserOutput createSuccess(UserInput userInput, String message) {
        UserOutputImpl impl = new UserOutputImpl(false, message, "user", userInput.getEmail(), userInput.getPassword());
        return impl;
    }
}
