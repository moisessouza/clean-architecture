package com.workers.gateway.impl.conversor;

import com.workers.entities.UserEntity;
import com.workers.orm.UserORM;

public class UserConversor {

    public static final UserEntity convertToEntity(UserORM orm) {
        UserEntity value = new UserEntity();
        value.setValue(orm.getValue());
        return value;
    }

    public static final UserORM convertToORM(UserEntity entity) {
        UserORM value = new UserORM();
        value.setValue(entity.getValue());
        return value;
    }

}
