package com.workers.gateway.impl;

import com.workers.entities.UserEntity;
import com.workers.gateway.UserGateway;
import com.workers.gateway.impl.conversor.UserConversor;
import com.workers.orm.UserORM;
import com.workers.queries.DBAny;
import org.springframework.stereotype.Service;

@Service
public class UserGatewayImpl implements UserGateway {

    public DBAny dbAny;

    public UserGatewayImpl(DBAny dbAny) {
        this.dbAny = dbAny;
    }

    @Override
    public UserEntity findAny() {
        UserORM any = dbAny.findAny();
        return UserConversor.convertToEntity(any);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        UserORM userORM = UserConversor.convertToORM(userEntity);
        dbAny.save(userORM);
        return UserConversor.convertToEntity(userORM);
    }

}
