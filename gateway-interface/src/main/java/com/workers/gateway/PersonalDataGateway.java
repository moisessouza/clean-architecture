package com.workers.gateway;

import com.workers.entities.PersonalDataEntity;
import com.workers.gateway.exceptions.PersonalDataNotFoundException;

public interface PersonalDataGateway {
    public PersonalDataEntity findByEmail(String email) throws PersonalDataNotFoundException;
    public PersonalDataEntity save(PersonalDataEntity personalDataEntity);
}
