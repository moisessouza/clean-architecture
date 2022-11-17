package com.workers.usecase.impl.phone;

import com.workers.entities.PersonalDataEntity;
import com.workers.entities.PhoneEntity;
import com.workers.gateway.PersonalDataGateway;
import com.workers.gateway.PhoneGateway;
import com.workers.gateway.exceptions.PersonalDataNotFoundException;
import com.workers.gateway.exceptions.PhoneNotFoundException;
import com.workers.presenters.PhonePresenter;
import com.workers.presenters.models.phone.PhoneInput;
import com.workers.presenters.models.phone.PhoneOutput;
import com.workers.usecase.PhoneUseCase;
import com.workers.usecase.impl.helper.EmailHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PhoneUseCaseImpl implements PhoneUseCase {

    private PersonalDataGateway personalDataGateway;
    private PhoneGateway phoneGateway;
    private PhonePresenter presenter;

    public PhoneUseCaseImpl(PersonalDataGateway personalDataGateway, PhoneGateway phoneGateway, PhonePresenter presenter) {
        this.personalDataGateway = personalDataGateway;
        this.phoneGateway = phoneGateway;
        this.presenter = presenter;
    }

    @Override
    public PhoneOutput findByEmail(String email) {

        if (!checkEmailIsValid(email)) {
            return presenter.findByEmailError(email, "phone.error.invalid.email");
        }

        PhoneEntity entity = findPhoneByEmail(email);

        return presenter.findByEmailSuccess(entity);

    }



    @Override
    public PhoneOutput saveByUserEmail(PhoneInput input) {

        if (!checkEmailIsValid(input.getUserEmail())) {
            return presenter.createError(input, "phone.error.invalid.email");
        }

        if (!checkIsDdiValid(input.getDdi())) {
            return presenter.createError(input, "phone.error.ddi.invalid");
        }

        if (!checkIsDddValid(input.getDdd())) {
            return presenter.createError(input, "phone.error.ddd.invalid");
        }

        if (!checkIsPhoneNumberValid(input.getPhoneNumber())) {
            return presenter.createError(input, "phone.error.phone.number.invalid");
        }

        try {

            PhoneEntity entity = getPhoneEntityByEmail(input.getUserEmail());

            if (entity == null) {
                entity = new PhoneEntity();

                PersonalDataEntity personalDataEntity = personalDataGateway.findByEmail(input.getUserEmail());
                entity.setPersonalData(personalDataEntity);

            }

            entity.setDdd(input.getDdd());
            entity.setDdi(input.getDdi());
            entity.setPhoneNumber(input.getPhoneNumber());

            entity = phoneGateway.save(entity);

            return presenter.createSuccess(entity, "phone.save.success");
        } catch (PersonalDataNotFoundException e) {
            return presenter.createError(input, "phone.error.personal.data.not.found");
        }
    }

    private boolean checkEmailIsValid(String email) {
        return EmailHelper.checkEmailIsValid(email);
    }

    private boolean checkIsDdiValid(String input) {
        return StringUtils.hasText(input);
    }

    private boolean checkIsDddValid(String input) {
        return StringUtils.hasText(input);
    }

    private boolean checkIsPhoneNumberValid(String input) {
        return StringUtils.hasText(input);
    }

    private PhoneEntity findPhoneByEmail(String email) {
        try {
            PhoneEntity entity = phoneGateway.findByEmail(email);
            return entity;
        } catch (PhoneNotFoundException e) {
            return new PhoneEntity();
        }
    }

    private PhoneEntity getPhoneEntityByEmail(String email)  {
        try {
            PhoneEntity entity = phoneGateway.findByEmail(email);
            return entity;
        } catch (PhoneNotFoundException e){
            return new PhoneEntity();
        }
    }

}
