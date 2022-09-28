package com.clean.architecture.gateway.impl;

import com.clean.architecture.entities.AnyEntity;
import com.clean.architecture.gateway.AnyGateway;
import com.clean.architecture.gateway.impl.conversor.AnyConversor;
import com.clean.architecture.orm.AnyORM;
import com.clean.architecture.queries.DBAny;

public class AnyGatewayImpl implements AnyGateway {

    private DBAny dbAny;

    public AnyGatewayImpl(DBAny dbAny) {
        this.dbAny = dbAny;
    }

    @Override
    public AnyEntity findAny() {
        AnyORM any = dbAny.findAny();
        return AnyConversor.convertToEntity(any);
    }

}
