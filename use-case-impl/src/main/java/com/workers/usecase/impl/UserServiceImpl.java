package com.workers.usecase.impl;

import com.workers.entities.UserEntity;
import com.workers.gateway.UserGateway;
import com.workers.presenters.UserPresenter;
import com.workers.presenters.models.UserInput;
import com.workers.presenters.models.UserOutput;
import com.workers.usecase.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    public UserGateway userGateway;
    public UserPresenter userPresenter;

    public UserServiceImpl(UserGateway userGateway, UserPresenter userPresenter) {
        this.userGateway = userGateway;
        this.userPresenter = userPresenter;

    }

    @Override
    public UserOutput save(UserInput userInput) {

        UserOutput output = verifyIfEmailContainsError(userInput);

        if (output.hasError()) {
            return output;
        }

        output = verifyIfPasswordContainsError(userInput);

        if (output.hasError()) {
            return output;
        }

        UserEntity entity = new UserEntity();
        entity.setEmail(userInput.getEmail());
        entity.setPassword(userInput.getPassword());

        userGateway.save(entity);

        return userPresenter.createSuccess(entity,"user.success.register");

    }

    @Override
    public UserOutput findByEmail(UserInput userInput) {

        UserOutput output = verifyIfEmailContainsError(userInput);

        if (output.hasError()) {
            return output;
        }

        UserEntity userEntity = userGateway.findByEmail(userInput.getEmail());

        return userPresenter.findEmailSuccess(userEntity,"user.success.find.email");
    }

    private UserOutput verifyIfEmailContainsError(UserInput input) {

        if (!StringUtils.hasText(input.getEmail())) {
            return userPresenter.createError(input, "user.error.email.empty");
        }

        return userPresenter.createValidateSuccess();

    }

    private UserOutput verifyIfPasswordContainsError(UserInput input) {

        if (!StringUtils.hasText(input.getPassword())) {
            return userPresenter.createError(input,"user.error.password.empty");
        }

        return userPresenter.createValidateSuccess();

    }

}
