package com.workers.presenters;

import com.workers.presenters.models.UserInput;
import com.workers.presenters.models.UserOutput;

public interface UserPresenter {

    UserOutput createError(UserInput userInput, String message);
    UserOutput createValidateSuccess();
    UserOutput createSuccess(UserInput userInput, String message);

}
