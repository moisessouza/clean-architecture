package com.clean.architecture.queries.impl;

import com.clean.architecture.orm.AnyORM;
import com.clean.architecture.queries.DBAny;
import org.springframework.stereotype.Service;

@Service
public class DBAnyImpl implements DBAny {

    @Override
    public AnyORM findAny() {

        AnyORM value = new AnyORM();
        value.setValue("it is a sample of value");

        return value;

    }
}
