package com.workers.usecase.impl.phone;

import com.workers.entities.PersonalDataEntity;
import com.workers.entities.PhoneEntity;
import com.workers.gateway.PersonalDataGateway;
import com.workers.gateway.PhoneGateway;
import com.workers.gateway.exceptions.PersonalDataNotFoundException;
import com.workers.presenters.PhonePresenter;
import com.workers.presenters.models.phone.PhoneInput;
import com.workers.presenters.models.phone.PhoneOutput;
import com.workers.usecase.PhoneService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PhoneServiceImpl implements PhoneService {

    private PersonalDataGateway personalDataGateway;
    private PhoneGateway phoneGateway;
    private PhonePresenter presenter;

    public PhoneServiceImpl(PersonalDataGateway personalDataGateway, PhoneGateway phoneGateway, PhonePresenter presenter) {
        this.personalDataGateway = personalDataGateway;
        this.phoneGateway = phoneGateway;
        this.presenter = presenter;
    }

    @Override
    public PhoneOutput findByEmail(String email) {
        return null;
    }

    @Override
    public PhoneOutput save(PhoneInput input) {

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

            PersonalDataEntity personalDataEntity = personalDataGateway.findByEmail(input.getUserEmail());

            PhoneEntity entity = phoneGateway.findByEmail(input.getUserEmail());

            if (entity == null) {
                entity = new PhoneEntity();
            }

            entity.setDdd(input.getDdd());
            entity.setDdi(input.getDdi());
            entity.setPhoneNumber(input.getPhoneNumber());
            entity.setPersonalData(personalDataEntity);

            entity = phoneGateway.save(entity);

            return presenter.createSuccess(entity, "phone.save.success");
        } catch (PersonalDataNotFoundException e) {
            return presenter.createError(input, "phone.error.personal.data.not.found");
        }
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
}