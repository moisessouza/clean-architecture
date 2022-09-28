package com.clean.architecture.usecase.impl;

import com.clean.architecture.entities.AnyEntity;
import com.clean.architecture.gateway.AnyGateway;
import com.clean.architecture.usecase.AnyService;

public class AnyServiceImpl implements AnyService {

    public AnyGateway anyGateway;

    public AnyServiceImpl(AnyGateway anyGateway) {
        this.anyGateway = anyGateway;
    }

    @Override
    public String executeSubstringForBusinessRules() {

        AnyEntity any = anyGateway.findAny();

        String value = any.getValue();

        if (value.length() > 10) {
            return value.substring(0, 10);
        } else {
            return value;
        }

    }

}
