package com.clean.architecture.queries;

import com.clean.architecture.orm.AnyORM;

public interface DBAny {
    AnyORM findAny();

    AnyORM saveAny(AnyORM anyORM);
}
