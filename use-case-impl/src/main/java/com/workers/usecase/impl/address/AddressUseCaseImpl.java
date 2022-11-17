package com.workers.usecase.impl.address;

import com.workers.entities.AddressEntity;
import com.workers.entities.PersonalDataEntity;
import com.workers.gateway.AddressGateway;
import com.workers.gateway.PersonalDataGateway;
import com.workers.gateway.exceptions.AddressNotFoundException;
import com.workers.gateway.exceptions.PersonalDataNotFoundException;
import com.workers.presenters.AddressPresenter;
import com.workers.presenters.models.address.AddressInput;
import com.workers.presenters.models.address.AddressOutput;
import com.workers.usecase.AddressUseCase;
import com.workers.usecase.impl.helper.EmailHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class AddressUseCaseImpl implements AddressUseCase {

    private AddressGateway addressGateway;

    private PersonalDataGateway personalDataGateway;
    private AddressPresenter presenter;

    public AddressUseCaseImpl(AddressGateway addressGateway, PersonalDataGateway personalDataGateway, AddressPresenter presenter) {
        this.addressGateway = addressGateway;
        this.personalDataGateway = personalDataGateway;
        this.presenter = presenter;
    }

    @Override
    public AddressOutput findByEmail(String email) {

        if (!checkEmailIsValid(email)) {
            return presenter.findByEmailError(email, "phone.error.invalid.email");
        }

        AddressEntity entity = findAddressByEmail(email);

        return presenter.findByEmailSuccess(entity);

    }

    @Override
    public AddressOutput saveByEmail(AddressInput input) {

        Optional<AddressOutput> optional = validateInput(input);

        if (optional.isPresent()) {
            return optional.get();
        }

        try {

            AddressEntity entity = getOrCreateAddressByEmail(input.getUserEmail());

            entity.setCountry(input.getCountry());
            entity.setZipPostal(input.getZipPostal());
            entity.setState(input.getState());
            entity.setCity(input.getCity());
            entity.setNeighborhood(input.getNeighborhood());
            entity.setStreet(input.getStreet());
            entity.setNumber(input.getNumber());
            entity.setComplement(input.getComplement());

            addressGateway.save(entity);

            return presenter.createSuccess(entity, "address.save.success");

        } catch (PersonalDataNotFoundException e) {
            return presenter.createError(input, "address.error.personal.data.not.found");
        }

    }

    private AddressEntity findAddressByEmail(String email) {
        try {
            AddressEntity entity = addressGateway.findByEmail(email);
            return entity;
        } catch (AddressNotFoundException e) {
            return new AddressEntity();
        }
    }

    private AddressEntity getOrCreateAddressByEmail(String email) throws PersonalDataNotFoundException {
        try {
            AddressEntity entity = addressGateway.findByEmail(email);
            return entity;
        } catch (AddressNotFoundException e) {
            AddressEntity entity = new AddressEntity();

            PersonalDataEntity personalDataEntity = personalDataGateway.findByEmail(email);
            entity.setPersonalData(personalDataEntity);

            return entity;
        }

    }

    private Optional<AddressOutput> validateInput(AddressInput addressInput) {

        if (!checkEmailIsValid(addressInput.getUserEmail())) {
            return Optional.of(presenter.createError(addressInput, "address.error.invalid.email"));
        }

        if (!checkCountryIsValid(addressInput.getCountry())) {
            return Optional.of(presenter.createError(addressInput, "address.error.invalid.country"));
        }

        if (!checkZipPostalIsValid(addressInput.getZipPostal())) {
            return Optional.of(presenter.createError(addressInput, "address.error.invalid.zip.postal"));
        }

        if (!checkStateIsValid(addressInput.getState())) {
            return Optional.of(presenter.createError(addressInput, "address.error.invalid.state"));
        }

        if (!checkCityIsValid(addressInput.getCity())) {
            return Optional.of(presenter.createError(addressInput, "address.error.invalid.city"));
        }

        if (!checkNeighborhoodIsValid(addressInput.getNeighborhood())) {
            return Optional.of(presenter.createError(addressInput, "address.error.invalid.neighborhood"));
        }

        if (!checkStreetIsValid(addressInput.getStreet())) {
            return Optional.of(presenter.createError(addressInput, "address.error.invalid.street"));
        }

        if (!checkNumberIsValid(addressInput.getNumber())) {
            return Optional.of(presenter.createError(addressInput, "address.error.invalid.number"));
        }

        if (!checkComplementIsValid(addressInput.getComplement())) {
            return Optional.of(presenter.createError(addressInput, "address.error.invalid.complement"));
        }

        return Optional.empty();

    }

    private boolean checkNumberIsValid(String number) {
        // TODO check if is a valid number
        return true;
    }

    private boolean checkEmailIsValid(String userEmail) {
        return EmailHelper.checkEmailIsValid(userEmail);
    }

    private boolean checkCountryIsValid(String country) {
        return StringUtils.hasText(country);
    }

    private boolean checkZipPostalIsValid(String zipPostal) {
        return StringUtils.hasText(zipPostal);
    }

    private boolean checkStateIsValid(String state) {
        return StringUtils.hasText(state);
    }

    private boolean checkNeighborhoodIsValid(String neighborhood) {
        return StringUtils.hasText(neighborhood);
    }

    private boolean checkCityIsValid(String city) {
        return StringUtils.hasText(city);
    }

    private boolean checkStreetIsValid(String street) {
        return StringUtils.hasText(street);
    }

    private boolean checkComplementIsValid(String complement) {
        return true;
    }

}
