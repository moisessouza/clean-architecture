package com.workers.gateway.impl.converter;

import com.workers.entities.RegisterEntity;
import com.workers.orm.RegisterORM;

public class RegisterConverter {

    public static final RegisterEntity toEntity(RegisterORM orm) {

        if (orm == null) {
            return null;
        }

        RegisterEntity entity = new RegisterEntity();
        entity.setId(orm.getId());
        entity.setName(orm.getName());
        entity.setDocumentNumber(orm.getDocumentNumber());
        entity.setBirthdate(orm.getBirthdate());
        entity.setUser(UserConverter.toEntity(orm.getUser()));

        return entity;

    }

    public static final RegisterORM toORM(RegisterEntity entity) {

        if (entity == null) {
            return null;
        }

        RegisterORM orm = new RegisterORM();
        orm.setId(entity.getId());
        orm.setName(entity.getName());
        orm.setDocumentNumber(entity.getDocumentNumber());
        orm.setBirthdate(entity.getBirthdate());
        orm.setUser(UserConverter.toORM(entity.getUser()));

        return orm;

    }


}
