package com.workers.usecase.impl;

import com.workers.entities.AnyEntity;
import com.workers.gateway.AnyGateway;
import com.workers.dto.AnyDTO;
import com.workers.presenters.models.AnyInput;
import com.workers.presenters.models.AnyOutput;
import com.workers.presenters.AnyPresenter;
import com.workers.usecase.AnyService;
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
