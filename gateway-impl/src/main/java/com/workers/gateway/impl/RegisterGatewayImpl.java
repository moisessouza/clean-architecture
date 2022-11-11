package com.workers.gateway.impl;

import com.workers.entities.RegisterEntity;
import com.workers.gateway.RegisterGateway;
import com.workers.orm.RegisterORM;
import com.workers.queries.DBRegister;
import org.springframework.stereotype.Service;

import static com.workers.gateway.impl.converter.RegisterConverter.toEntity;
import static com.workers.gateway.impl.converter.RegisterConverter.toORM;

@Service
public class RegisterGatewayImpl implements RegisterGateway {

    public DBRegister dbRegister;

    public RegisterGatewayImpl(DBRegister dbRegister) {
        this.dbRegister = dbRegister;
    }

    @Override
    public RegisterEntity save(RegisterEntity registerEntity) {
        RegisterORM orm = toORM(registerEntity);
        orm = dbRegister.save(orm);
        return toEntity(orm);
    }
}
