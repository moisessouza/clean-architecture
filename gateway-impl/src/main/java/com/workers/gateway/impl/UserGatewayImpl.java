package com.workers.gateway.impl;

import com.workers.entities.UserEntity;
import com.workers.gateway.UserGateway;
import com.workers.gateway.impl.conversor.UserConversor;
import com.workers.orm.UserORM;
import com.workers.queries.DBUser;
import org.springframework.stereotype.Service;

@Service
public class UserGatewayImpl implements UserGateway {

    public DBUser dbUser;

    public UserGatewayImpl(DBUser dbUser) {
        this.dbUser = dbUser;
    }


    @Override
    public UserEntity save(UserEntity userEntity) {
        UserORM userORM = UserConversor.convertToORM(userEntity);
        dbUser.save(userORM);
        return UserConversor.convertToEntity(userORM);
    }

}
