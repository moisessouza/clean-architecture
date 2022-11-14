package com.workers.gateway;

import com.workers.entities.PhoneEntity;

public interface PhoneGateway {
    PhoneEntity findByEmail(String email);
    PhoneEntity save(PhoneEntity entity);
}
