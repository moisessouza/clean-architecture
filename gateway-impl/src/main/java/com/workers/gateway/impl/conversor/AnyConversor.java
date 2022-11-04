package com.workers.gateway.impl.conversor;

import com.workers.entities.AnyEntity;
import com.workers.orm.AnyORM;

public class AnyConversor {

    public static final AnyEntity convertToEntity(AnyORM orm) {
        AnyEntity value = new AnyEntity();
        value.setValue(orm.getValue());
        return value;
    }

    public static final AnyORM convertToORM(AnyEntity entity) {
        AnyORM value = new AnyORM();
        value.setValue(entity.getValue());
        return value;
    }

}
