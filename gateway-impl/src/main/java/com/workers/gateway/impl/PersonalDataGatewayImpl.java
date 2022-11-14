package com.workers.gateway.impl;

import com.workers.entities.PersonalDataEntity;
import com.workers.gateway.PersonalDataGateway;
import com.workers.orm.PersonalDataORM;
import com.workers.queries.DBPersonalData;
import org.springframework.stereotype.Service;

import static com.workers.gateway.impl.converter.PersonalDataConverter.toEntity;
import static com.workers.gateway.impl.converter.PersonalDataConverter.toORM;

@Service
public class PersonalDataGatewayImpl implements PersonalDataGateway {

    public DBPersonalData dbPersonalData;

    public PersonalDataGatewayImpl(DBPersonalData dbPersonalData) {
        this.dbPersonalData = dbPersonalData;
    }


    @Override
    public PersonalDataEntity findByEmail(String email) {
        PersonalDataORM orm = dbPersonalData.findByUserEmail(email);
        return toEntity(orm);
    }

    @Override
    public PersonalDataEntity save(PersonalDataEntity personalDataEntity) {
        PersonalDataORM orm = toORM(personalDataEntity);
        orm = dbPersonalData.save(orm);
        return toEntity(orm);
    }
}
