package com.workers.presenters.impl;

import com.workers.entities.PersonalDataEntity;
import com.workers.presenters.PersonalDataPresenter;
import com.workers.presenters.models.personaldata.PersonalDataInput;
import com.workers.presenters.models.personaldata.PersonalDataOutput;
import org.springframework.stereotype.Service;

@Service
public class PersonalDataPresenterImpl implements PersonalDataPresenter {

    @Override
    public PersonalDataOutput createError(PersonalDataInput personalDataInput, String messageCode) {
        return null;
    }

    @Override
    public PersonalDataOutput createSuccess(PersonalDataEntity entity, String messageCode) {
        return null;
    }

}
