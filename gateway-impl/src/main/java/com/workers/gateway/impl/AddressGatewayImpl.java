package com.workers.gateway.impl;

import com.workers.entities.AddressEntity;
import com.workers.gateway.AddressGateway;
import com.workers.queries.DBAddress;

public class AddressGatewayImpl implements AddressGateway {

    private DBAddress dbAddress;

    public AddressGatewayImpl(DBAddress dbAddress) {
        this.dbAddress = dbAddress;
    }

    @Override
    public AddressEntity save(AddressEntity addressEntity) {



        return null;
    }

    @Override
    public AddressEntity findByEmail(String userEmail) {
        return null;
    }
}
