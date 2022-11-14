package com.workers.presenters;

import com.workers.entities.PersonalDataEntity;
import com.workers.presenters.models.personaldata.PersonalDataInput;
import com.workers.presenters.models.personaldata.PersonalDataOutput;

public interface PersonalDataPresenter {

    PersonalDataOutput createError(PersonalDataInput personalDataInput, String messageCode);

    PersonalDataOutput createSuccess(PersonalDataEntity entity, String messageCode);
}
