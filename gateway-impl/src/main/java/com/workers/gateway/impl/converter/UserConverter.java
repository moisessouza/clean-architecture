package com.workers.gateway.impl.converter;

import com.workers.entities.UserEntity;
import com.workers.orm.UserORM;

public class UserConverter {

    public static final UserEntity toEntity(UserORM orm) {
        UserEntity value = new UserEntity();
        value.setEmail(orm.getEmail());
        value.setPassword(orm.getPassword());
        return value;
    }

    public static final UserORM toORM(UserEntity entity) {
        UserORM value = new UserORM();

        value.setEmail(entity.getEmail());
        value.setPassword(entity.getPassword());
        return value;
    }

}
