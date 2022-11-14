package com.workers.gateway.impl;

import com.workers.entities.PhoneEntity;
import com.workers.gateway.PhoneGateway;
import com.workers.gateway.exceptions.PhoneNotFoundException;
import com.workers.orm.PhoneORM;
import com.workers.queries.DBPhone;

import static com.workers.gateway.impl.converter.PhoneConverter.toEntity;
import static com.workers.gateway.impl.converter.PhoneConverter.toORM;

public class PhoneGatewayImpl implements PhoneGateway {

    private DBPhone dbPhone;

    public PhoneGatewayImpl(DBPhone dbPhone) {
        this.dbPhone = dbPhone;
    }
    @Override
    public PhoneEntity findByEmail(String email) throws PhoneNotFoundException {
        PhoneORM orm = dbPhone.findByPersonalDataUserEmail(email);

        if (orm == null) {
            throw new PhoneNotFoundException();
        }

        return toEntity(orm);
        
    }

    @Override
    public PhoneEntity save(PhoneEntity entity) {
        PhoneORM orm = toORM(entity);
        orm = dbPhone.save(orm);
        return toEntity(orm);
    }

}
