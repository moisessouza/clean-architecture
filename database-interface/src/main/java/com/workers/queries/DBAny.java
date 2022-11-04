package com.workers.queries;

import com.workers.orm.AnyORM;

public interface DBAny {
    AnyORM findAny();

    AnyORM saveAny(AnyORM anyORM);
}
