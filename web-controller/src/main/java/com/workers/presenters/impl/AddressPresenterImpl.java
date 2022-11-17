package com.workers.presenters.impl;

import com.workers.entities.AddressEntity;
import com.workers.presenters.AddressPresenter;
import com.workers.presenters.models.address.AddressInput;
import com.workers.presenters.models.address.AddressOutput;
import com.workers.presenters.models.address.AddressOutputImpl;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AddressPresenterImpl implements AddressPresenter {

    private MessageSource messageSource;

    public AddressPresenterImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public AddressOutput createError(AddressInput addressInput, String messageCode) {

        AddressOutputImpl impl = new AddressOutputImpl();

        impl.setError(true);
        impl.setMessage(getMessage(messageCode));

        impl.setCountry(addressInput.getCountry());
        impl.setZipPostal(addressInput.getZipPostal());
        impl.setState(addressInput.getState());
        impl.setCity(addressInput.getCity());
        impl.setNeighborhood(addressInput.getNeighborhood());
        impl.setStreet(addressInput.getStreet());
        impl.setNumber(addressInput.getNumber());
        impl.setComplement(addressInput.getComplement());
        impl.setUserEmail(addressInput.getUserEmail());

        return impl;
        
    }

    @Override
    public AddressOutput createSuccess(AddressEntity entity, String messageCode) {

        AddressOutputImpl impl = new AddressOutputImpl();

        impl.setError(false);
        impl.setMessage(getMessage(messageCode));

        impl.setCountry(entity.getCountry());
        impl.setZipPostal(entity.getZipPostal());
        impl.setState(entity.getState());
        impl.setCity(entity.getCity());
        impl.setNeighborhood(entity.getNeighborhood());
        impl.setStreet(entity.getStreet());
        impl.setNumber(entity.getNumber());
        impl.setComplement(entity.getComplement());
        impl.setUserEmail(getUserEmail(entity));

        return impl;

    }

    @Override
    public AddressOutput findByEmailError(String email, String messageCode) {

        AddressOutputImpl impl = new AddressOutputImpl();

        impl.setError(true);
        impl.setMessage(getMessage(messageCode));

        impl.setUserEmail(email);

        return impl;

    }

    @Override
    public AddressOutput findByEmailSuccess(AddressEntity entity) {

        AddressOutputImpl impl = new AddressOutputImpl();

        impl.setError(false);

        impl.setCountry(entity.getCountry());
        impl.setZipPostal(entity.getZipPostal());
        impl.setState(entity.getState());
        impl.setCity(entity.getCity());
        impl.setNeighborhood(entity.getNeighborhood());
        impl.setStreet(entity.getStreet());
        impl.setNumber(entity.getNumber());
        impl.setComplement(entity.getComplement());
        impl.setUserEmail(getUserEmail(entity));

        return impl;

    }

    private static String getUserEmail(AddressEntity entity) {

        if (entity.getPersonalData() == null) {
            return null;
        }

        if (entity.getPersonalData().getUser() == null) {
            return null;
        }

        return entity.getPersonalData().getUser().getEmail();

    }


    private String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null,  Locale.getDefault());
    }

}
