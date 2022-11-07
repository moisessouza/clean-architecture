package com.workers.presenters.impl;

import com.workers.dto.UserDTO;
import com.workers.presenters.UserPresenter;
import com.workers.presenters.models.UserOutput;
import com.workers.presenters.models.UserOutputImpl;
import org.springframework.stereotype.Service;

@Service
public class UserPresenterImpl implements UserPresenter {
    @Override
    public UserOutput createModelPresenter(UserDTO modelPresenter) {
        return new UserOutputImpl(modelPresenter);
    }
}
