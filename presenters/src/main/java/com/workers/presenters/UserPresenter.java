package com.workers.presenters;

import com.workers.entities.UserEntity;
import com.workers.presenters.models.UserInput;
import com.workers.presenters.models.UserOutput;

public interface UserPresenter {

    UserOutput createError(UserInput userInput, String messageCode);
    UserOutput createValidateSuccess();
    UserOutput createSuccess(UserEntity entity, String messageCode);
    UserOutput findEmailSuccess(UserEntity entity, String messageCode);

}
