package com.workers.presenters;

import com.workers.entities.PhoneEntity;
import com.workers.presenters.models.phone.PhoneInput;
import com.workers.presenters.models.phone.PhoneOutput;

public interface PhonePresenter {
    PhoneOutput createError(PhoneInput userInput, String messageCode);
    PhoneOutput createSuccess(PhoneEntity entity, String messageCode);
    PhoneOutput findByEmailError(String email, String messageCode);
    PhoneOutput findByEmailSuccess(PhoneEntity entity);
}
