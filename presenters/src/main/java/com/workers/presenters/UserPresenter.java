package com.workers.presenters;

import com.workers.entities.UserEntity;
import com.workers.presenters.models.user.UserInput;
import com.workers.presenters.models.user.UserOutput;

public interface UserPresenter {

    UserOutput createError(UserInput userInput, String messageCode);
    UserOutput createValidateSuccess();
    UserOutput createSuccess(UserEntity entity, String messageCode);
    UserOutput findUserSuccess(UserEntity entity, String messageCode);

    UserOutput findUserFail(String messageCode);

}
