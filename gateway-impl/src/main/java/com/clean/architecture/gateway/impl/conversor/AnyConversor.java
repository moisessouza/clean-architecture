package com.clean.architecture.gateway.impl.conversor;

import com.clean.architecture.entities.AnyEntity;
import com.clean.architecture.orm.AnyORM;

public class AnyConversor {

    public static final AnyEntity convertToEntity(AnyORM orm) {
        AnyEntity value = new AnyEntity();
        value.setValue(orm.getValue());
        return value;
    }

}
