package com.workers.presenters;

import com.workers.dto.UserDTO;
import com.workers.presenters.models.UserOutput;

public interface UserPresenter {

    UserOutput createEmailError(String message);
    UserOutput createPasswordError(String message);
    UserOutput createValidateSuccess();
    UserOutput createSuccess(String message);

}
