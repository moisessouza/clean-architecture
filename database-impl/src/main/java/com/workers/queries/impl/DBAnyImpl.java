package com.workers.queries.impl;

import com.workers.orm.UserORM;
import com.workers.queries.DBAny;
import org.springframework.stereotype.Service;

@Service
public class DBAnyImpl implements DBAny {

    @Override
    public UserORM findAny() {

        UserORM value = new UserORM();
        value.setValue("it is a sample of value");

        return value;

    }

    @Override
    public UserORM save(UserORM userORM) {
        // .....
        // SAVE
        // ....
        return userORM;
    }
}
