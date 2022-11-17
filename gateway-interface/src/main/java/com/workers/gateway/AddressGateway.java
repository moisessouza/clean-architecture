package com.workers.gateway;

import com.workers.entities.AddressEntity;
import com.workers.gateway.exceptions.AddressNotFoundException;

public interface AddressGateway {

    AddressEntity save(AddressEntity addressEntity);

    AddressEntity findByEmail(String userEmail) throws AddressNotFoundException;
}
