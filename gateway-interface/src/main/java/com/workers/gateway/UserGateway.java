package com.workers.gateway;

import com.workers.entities.UserEntity;

public interface UserGateway {

    UserEntity save(UserEntity userEntity);

    UserEntity findByEmail(String email);

}
