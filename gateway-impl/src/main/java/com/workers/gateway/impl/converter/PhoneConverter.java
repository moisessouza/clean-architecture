package com.workers.gateway.impl.converter;

import com.workers.entities.PhoneEntity;
import com.workers.orm.PhoneORM;

public class PhoneConverter {

    public static final PhoneEntity toEntity(PhoneORM orm) {

        if (orm == null) {
            return null;
        }

        PhoneEntity entity = new PhoneEntity();

        entity.setId(orm.getId());
        entity.setDdi(orm.getDdi());
        entity.setDdd(orm.getDdd());
        entity.setPhoneNumber(orm.getPhoneNumber());
        entity.setPersonalData(PersonalDataConverter.toEntity(orm.getPersonalData()));

        return entity;

    }

    public static final PhoneORM toORM(PhoneEntity entity) {

        if (entity == null) {
            return null;
        }

        PhoneORM orm = new PhoneORM();
        orm.setId(entity.getId());
        orm.setDdi(entity.getDdi());
        orm.setDdd(entity.getDdd());
        orm.setPhoneNumber(entity.getPhoneNumber());
        orm.setPersonalData(PersonalDataConverter.toORM(entity.getPersonalData()));

        return orm;

    }
}
