package com.clean.architecture.usecase.impl;

import com.clean.architecture.entities.AnyEntity;
import com.clean.architecture.gateway.AnyGateway;
import com.clean.architecture.dto.AnyDTO;
import com.clean.architecture.presenters.models.AnyInput;
import com.clean.architecture.presenters.models.AnyOutput;
import com.clean.architecture.presenters.AnyPresenter;
import com.clean.architecture.usecase.AnyService;
import org.springframework.stereotype.Service;

@Service
public class AnyServiceImpl implements AnyService {

    public AnyGateway anyGateway;
    public AnyPresenter anyPresenter;

    public AnyServiceImpl(AnyGateway anyGateway, AnyPresenter anyPresenter) {

        this.anyGateway = anyGateway;
        this.anyPresenter = anyPresenter;
    }

    @Override
    public AnyOutput executeSubstringForBusinessRules() {

        AnyEntity any = anyGateway.findAny();

        String value = any.getValue();

        if (value.length() > 10) {
            value = value.substring(0, 10);
        }

        AnyDTO anyDTO = new AnyDTO();
        anyDTO.setValue(value);

        return anyPresenter.createModelPresenter(anyDTO);

    }

    @Override
    public AnyOutput save(AnyInput anyInput) {

        AnyEntity entity = new AnyEntity();
        entity.setValue(anyInput.getValue());

        anyGateway.saveAny(entity);

        AnyDTO anyDTO = new AnyDTO();
        anyDTO.setValue(entity.getValue());

        return anyPresenter.createModelPresenter(anyDTO);

    }

}
