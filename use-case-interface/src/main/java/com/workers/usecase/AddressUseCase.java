package com.workers.usecase;

import com.workers.presenters.models.address.AddressInput;
import com.workers.presenters.models.address.AddressOutput;

public interface AddressUseCase {
    AddressOutput findByEmail(String email);
    AddressOutput saveByEmail(AddressInput input);
}
