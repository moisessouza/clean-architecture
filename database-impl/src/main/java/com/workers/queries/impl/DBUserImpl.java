package com.workers.queries.impl;

import com.workers.orm.UserORM;
import com.workers.queries.DBUser;
import org.springframework.stereotype.Service;

@Service
public class DBUserImpl implements DBUser {

    @Override
    public UserORM findByEmail(String email) {
        UserORM value = new UserORM();
        value.setEmail(email);
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
