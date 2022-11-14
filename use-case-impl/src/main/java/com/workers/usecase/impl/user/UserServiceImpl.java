package com.workers.usecase.impl.user;

import com.workers.entities.UserEntity;
import com.workers.gateway.UserGateway;
import com.workers.gateway.exceptions.UserNotFoundException;
import com.workers.presenters.UserPresenter;
import com.workers.presenters.models.user.UserInput;
import com.workers.presenters.models.user.UserOutput;
import com.workers.usecase.UserService;
import com.workers.usecase.impl.helper.EmailHelper;
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
        entity.setId(userInput.getId());
        entity.setEmail(userInput.getEmail());
        entity.setPassword(userInput.getPassword());

        entity = userGateway.save(entity);

        return userPresenter.createSuccess(entity,"user.save.success");

    }

    @Override
    public UserOutput findByEmail(UserInput userInput) {

        try {

            UserOutput output = verifyIfEmailContainsError(userInput);

            if (output.hasError()) {
                return output;
            }

            UserEntity userEntity = userGateway.findByEmail(userInput.getEmail());

            return userPresenter.findUserSuccess(userEntity,"user.success.find.email");

        } catch (UserNotFoundException e) {
            return userPresenter.findUserFail("user.error.find.email");
        }

    }

    private UserOutput verifyIfEmailContainsError(UserInput input) {

        if (!StringUtils.hasText(input.getEmail())) {
            return userPresenter.createError(input, "user.error.email.empty");
        }

        if (!EmailHelper.checkIsValidEmail(input.getEmail())) {
            return userPresenter.createError(input, "user.error.email.invalid");
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
