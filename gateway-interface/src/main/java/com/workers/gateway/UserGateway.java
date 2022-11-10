package com.workers.gateway;

import com.workers.entities.UserEntity;
import com.workers.gateway.exceptions.UserNotFoundException;

public interface UserGateway {

    UserEntity save(UserEntity userEntity);

    UserEntity findByEmail(String email) throws UserNotFoundException;

}
