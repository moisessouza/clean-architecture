package com.workers.gateway.impl;

import com.workers.entities.AnyEntity;
import com.workers.gateway.AnyGateway;
import com.workers.gateway.impl.conversor.AnyConversor;
import com.workers.orm.AnyORM;
import com.workers.queries.DBAny;
import org.springframework.stereotype.Service;

@Service
public class AnyGatewayImpl implements AnyGateway {

    public DBAny dbAny;

    public AnyGatewayImpl(DBAny dbAny) {
        this.dbAny = dbAny;
    }

    @Override
    public AnyEntity findAny() {
        AnyORM any = dbAny.findAny();
        return AnyConversor.convertToEntity(any);
    }

    @Override
    public AnyEntity saveAny(AnyEntity anyEntity) {
        AnyORM anyORM = AnyConversor.convertToORM(anyEntity);
        dbAny.saveAny(anyORM);
        return AnyConversor.convertToEntity(anyORM);
    }

}
