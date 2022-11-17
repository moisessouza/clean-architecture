package com.workers.gateway.impl.converter;

import com.workers.entities.AddressEntity;
import com.workers.orm.AddressORM;

public class AddressConverter {

    public static AddressEntity toEntity(AddressORM orm) {

        if (orm == null) {
            return null;
        }

        AddressEntity entity = new AddressEntity();
        entity.setId(orm.getId());
        entity.setCountry(orm.getCountry());
        entity.setZipPostal(orm.getZipPostal());
        entity.setState(orm.getState());
        entity.setCity(orm.getCity());
        entity.setNeighborhood(orm.getNeighborhood());
        entity.setStreet(orm.getStreet());
        entity.setNumber(orm.getNumber());
        entity.setComplement(orm.getComplement());

        entity.setPersonalData(PersonalDataConverter.toEntity(orm.getPersonalData()));

        return entity;

    }

    public static AddressORM toORM(AddressEntity entity) {

        if (entity == null) {
            return null;
        }

        AddressORM orm = new AddressORM();
        orm.setId(entity.getId());
        orm.setCountry(entity.getCountry());
        orm.setZipPostal(entity.getZipPostal());
        orm.setState(entity.getState());
        orm.setCity(entity.getCity());
        orm.setNeighborhood(entity.getNeighborhood());
        orm.setStreet(entity.getStreet());
        orm.setNumber(entity.getNumber());
        orm.setComplement(entity.getComplement());

        orm.setPersonalData(PersonalDataConverter.toORM(entity.getPersonalData()));

        return orm;

    }
}
