package com.workers.presenters;

import com.workers.entities.RegisterEntity;
import com.workers.presenters.models.register.RegisterInput;
import com.workers.presenters.models.register.RegisterOutput;

public interface RegisterPresenter {

    RegisterOutput createError(RegisterInput registerInput, String messageCode);

    RegisterOutput createSuccess(RegisterEntity entity, String messageCode);
}
