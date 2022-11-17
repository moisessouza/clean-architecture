package com.workers.gateway;

import com.workers.entities.AddressEntity;

public interface AddressGateway {

    AddressEntity save(AddressEntity addressEntity);

    AddressEntity findByEmail(String userEmail);
}
