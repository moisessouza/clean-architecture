package com.workers.presenters;

import com.workers.entities.AddressEntity;
import com.workers.presenters.models.address.AddressInput;
import com.workers.presenters.models.address.AddressOutput;

public interface AddressPresenter {

    AddressOutput createError(AddressInput addressInput, String messageCode);

    AddressOutput createSuccess(AddressEntity entity, String messageCode);

    AddressOutput findByEmailError(String email, String s);

    AddressOutput findByEmailSuccess(AddressEntity entity);
}
