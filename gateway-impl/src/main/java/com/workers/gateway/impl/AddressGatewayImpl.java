package com.workers.gateway.impl;

import com.workers.entities.AddressEntity;
import com.workers.gateway.AddressGateway;
import com.workers.gateway.exceptions.AddressNotFoundException;
import com.workers.orm.AddressORM;
import com.workers.queries.DBAddress;

import static com.workers.gateway.impl.converter.AddressConverter.toEntity;
import static com.workers.gateway.impl.converter.AddressConverter.toORM;

public class AddressGatewayImpl implements AddressGateway {

    private DBAddress dbAddress;

    public AddressGatewayImpl(DBAddress dbAddress) {
        this.dbAddress = dbAddress;
    }

    @Override
    public AddressEntity save(AddressEntity addressEntity) {

        AddressORM orm = toORM(addressEntity);
        orm = dbAddress.save(orm);
        return toEntity(orm);
    }

    @Override
    public AddressEntity findByEmail(String userEmail) throws AddressNotFoundException {

        AddressORM orm = dbAddress.findByPersonalDataUserEmail(userEmail);

        if (orm == null) {
            throw new AddressNotFoundException();
        }

        return toEntity(orm);
    }
}
