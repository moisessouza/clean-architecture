package com.workers.usecase;

import com.workers.presenters.models.phone.PhoneInput;
import com.workers.presenters.models.phone.PhoneOutput;

public interface PhoneService {
    PhoneOutput findByEmail(String email);
    PhoneOutput saveByUserEmail(PhoneInput personalDataInput);
}
