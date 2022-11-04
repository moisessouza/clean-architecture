package com.workers.queries.impl;

import com.workers.orm.AnyORM;
import com.workers.queries.DBAny;
import org.springframework.stereotype.Service;

@Service
public class DBAnyImpl implements DBAny {

    @Override
    public AnyORM findAny() {

        AnyORM value = new AnyORM();
        value.setValue("it is a sample of value");

        return value;

    }

    @Override
    public AnyORM saveAny(AnyORM anyORM) {
        // .....
        // SAVE
        // ....
        return anyORM;
    }
}
