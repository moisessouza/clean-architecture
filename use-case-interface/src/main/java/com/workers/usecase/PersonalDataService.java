package com.workers.usecase;

import com.workers.presenters.models.personaldata.PersonalDataInput;
import com.workers.presenters.models.personaldata.PersonalDataOutput;

public interface PersonalDataService {
    PersonalDataOutput findByEmail(String email);
    PersonalDataOutput saveByUserEmail(PersonalDataInput personalDataInput);
}
