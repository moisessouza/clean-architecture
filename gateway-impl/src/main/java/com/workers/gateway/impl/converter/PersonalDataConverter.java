package com.workers.gateway.impl.converter;

import com.workers.entities.PersonalDataEntity;
import com.workers.orm.PersonalDataORM;

public class PersonalDataConverter {

    public static final PersonalDataEntity toEntity(PersonalDataORM orm) {

        if (orm == null) {
            return null;
        }

        PersonalDataEntity entity = new PersonalDataEntity();
        entity.setId(orm.getId());
        entity.setName(orm.getName());
        entity.setDocumentNumber(orm.getDocumentNumber());
        entity.setBirthdate(orm.getBirthdate());
        entity.setUser(UserConverter.toEntity(orm.getUser()));

        return entity;

    }

    public static final PersonalDataORM toORM(PersonalDataEntity entity) {

        if (entity == null) {
            return null;
        }

        PersonalDataORM orm = new PersonalDataORM();
        orm.setId(entity.getId());
        orm.setName(entity.getName());
        orm.setDocumentNumber(entity.getDocumentNumber());
        orm.setBirthdate(entity.getBirthdate());
        orm.setUser(UserConverter.toORM(entity.getUser()));

        return orm;

    }


}
