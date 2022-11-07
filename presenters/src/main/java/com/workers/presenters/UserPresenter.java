package com.workers.presenters;

import com.workers.presenters.models.UserOutput;

public interface UserPresenter {

    UserOutput createError(String message);
    UserOutput createValidateSuccess();
    UserOutput createSuccess(String message);

}
