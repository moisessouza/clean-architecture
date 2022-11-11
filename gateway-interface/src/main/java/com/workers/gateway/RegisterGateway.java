package com.workers.gateway;

import com.workers.entities.RegisterEntity;

public interface RegisterGateway {
    public RegisterEntity save(RegisterEntity registerEntity);
}
