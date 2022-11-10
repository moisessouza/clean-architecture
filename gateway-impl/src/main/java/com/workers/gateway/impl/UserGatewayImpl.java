package com.workers.gateway.impl;

import com.workers.entities.UserEntity;
import com.workers.gateway.UserGateway;
import com.workers.gateway.exceptions.UserNotFoundException;
import com.workers.orm.UserORM;
import com.workers.queries.DBUser;
import org.springframework.stereotype.Service;

import static com.workers.gateway.impl.converter.UserConverter.toEntity;
import static com.workers.gateway.impl.converter.UserConverter.toORM;

@Service
public class UserGatewayImpl implements UserGateway {

    public DBUser dbUser;

    public UserGatewayImpl(DBUser dbUser) {
        this.dbUser = dbUser;
    }


    @Override
    public UserEntity save(UserEntity userEntity) {
        UserORM userORM = toORM(userEntity);
        dbUser.save(userORM);
        return toEntity(userORM);
    }

    @Override
    public UserEntity findByEmail(String email) throws UserNotFoundException {
        UserORM orm = dbUser.findByEmail(email);

        if (orm == null) {
            throw new UserNotFoundException();
        }

        return toEntity(orm);
    }

}
