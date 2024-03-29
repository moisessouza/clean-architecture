package com.workers.gateway.impl.converter;

import com.workers.entities.UserEntity;
import com.workers.orm.UserORM;

public class UserConverter {

    public static final UserEntity toEntity(UserORM orm) {

        if (orm == null) {
            return null;
        }

        UserEntity value = new UserEntity();
        value.setId(orm.getId());
        value.setEmail(orm.getEmail());
        value.setPassword(orm.getPassword());
        return value;
    }

    public static final UserORM toORM(UserEntity entity) {

        if (entity == null) {
            return null;
        }

        UserORM value = new UserORM();
        value.setId(entity.getId());
        value.setEmail(entity.getEmail());
        value.setPassword(entity.getPassword());
        return value;
    }

}
