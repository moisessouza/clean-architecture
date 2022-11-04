package com.workers.gateway;

import com.workers.entities.AnyEntity;

public interface AnyGateway {
    AnyEntity findAny();

    AnyEntity saveAny(AnyEntity anyEntity);

}
