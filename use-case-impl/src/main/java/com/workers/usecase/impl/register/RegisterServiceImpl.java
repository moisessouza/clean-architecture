package com.workers.usecase.impl.register;

import com.workers.entities.RegisterEntity;
import com.workers.entities.UserEntity;
import com.workers.gateway.RegisterGateway;
import com.workers.gateway.UserGateway;
import com.workers.gateway.exceptions.UserNotFoundException;
import com.workers.presenters.RegisterPresenter;
import com.workers.presenters.models.register.RegisterInput;
import com.workers.presenters.models.register.RegisterOutput;
import com.workers.usecase.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class RegisterServiceImpl implements RegisterService {

    private RegisterGateway registerGateway;

    private UserGateway userGateway;

    private RegisterPresenter presenter;

    public RegisterServiceImpl (RegisterGateway registerGateway,
                                UserGateway userGateway,
                                RegisterPresenter presenter) {
        this.registerGateway = registerGateway;
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

    @Override
    public RegisterOutput save(RegisterInput registerInput) {

        if (checkIsValidEmail(registerInput.getUserEmail())) {
            return presenter.createError(registerInput, "register.error.invalid.email");
        }

        if (checkIsValidName(registerInput.getName())) {
            return presenter.createError(registerInput, "register.error.invalid.name");
        }

        if (checkIsDocumentNumberValid(registerInput.getDocumentNumber())) {
            return presenter.createError(registerInput, "register.error.invalid.document.number");
        }

        if (checkIsBirthdateValid(registerInput.getBirthdate())) {
            return presenter.createError(registerInput, "register.error.invalid.birthdate");
        }

        try {

            UserEntity userEntity = userGateway.findByEmail(registerInput.getUserEmail());

            RegisterEntity entity = new RegisterEntity();
            entity.setName(registerInput.getName());
            entity.setBirthdate(registerInput.getBirthdate());
            entity.setDocumentNumber(registerInput.getDocumentNumber());
            entity.setUser(userEntity);

            entity = registerGateway.save(entity);

            return presenter.createSuccess(entity, "register.save.success");

        } catch (UserNotFoundException e) {
            return presenter.createError(registerInput, "register.error.user.not.found");
        }

    }

    private boolean checkIsValidEmail(String email) {
        return !StringUtils.hasText(email);
    }

    private boolean checkIsBirthdateValid(Date birthdate) {
        return birthdate != null;
    }

    private boolean checkIsDocumentNumberValid(String documentNumber) {
        return !StringUtils.hasText(documentNumber);
    }

    private boolean checkIsValidName(String name) {
        return !StringUtils.hasText(name);
    }

}
