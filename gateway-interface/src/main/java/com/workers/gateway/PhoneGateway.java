package com.workers.gateway;

import com.workers.entities.PhoneEntity;
import com.workers.gateway.exceptions.PhoneNotFoundException;

public interface PhoneGateway {
    PhoneEntity findByEmail(String email) throws PhoneNotFoundException;
    PhoneEntity save(PhoneEntity entity);
}
