package com.workers.gateway.impl.conversor;

import com.workers.entities.UserEntity;
import com.workers.orm.UserORM;

public class UserConversor {

    public static final UserEntity convertToEntity(UserORM orm) {
        UserEntity value = new UserEntity();
        value.setEmail(orm.getEmail());
        value.setPassword(orm.getPassword());
        return value;
    }

    public static final UserORM convertToORM(UserEntity entity) {
        UserORM value = new UserORM();

        value.setEmail(entity.getEmail());
        value.setPassword(entity.getPassword());
        return value;
    }

}
