package com.workers.queries;

import com.workers.orm.UserORM;

public interface DBAny {
    UserORM findAny();

    UserORM save(UserORM userORM);
}
