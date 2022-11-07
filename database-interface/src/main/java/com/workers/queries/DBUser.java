package com.workers.queries;

import com.workers.orm.UserORM;

public interface DBUser {
    UserORM findByEmail(String email);

    UserORM save(UserORM userORM);
}
