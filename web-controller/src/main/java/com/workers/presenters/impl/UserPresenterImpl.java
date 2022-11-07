package com.workers.presenters.impl;

import com.workers.presenters.models.UserOutputImpl;
import com.workers.presenters.UserPresenter;
import com.workers.presenters.models.UserOutput;
import org.springframework.stereotype.Service;

@Service
public class UserPresenterImpl implements UserPresenter {

    @Override
    public UserOutput createError(String message) {
        UserOutputImpl impl = new UserOutputImpl(true, message, "user");
        return impl;
    }

    @Override
    public UserOutput createValidateSuccess() {
        return  new UserOutputImpl(false, null, null);
    }

    @Override
    public UserOutput createSuccess(String message) {
        UserOutputImpl impl = new UserOutputImpl(false, message, "user");
        return impl;
    }
}
