package com.workers.gateway;

import com.workers.entities.UserEntity;

public interface UserGateway {
    UserEntity findAny();

    UserEntity save(UserEntity userEntity);

}
