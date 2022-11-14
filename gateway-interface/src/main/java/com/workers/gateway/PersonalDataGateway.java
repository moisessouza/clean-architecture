package com.workers.gateway;

import com.workers.entities.PersonalDataEntity;

public interface PersonalDataGateway {
    public PersonalDataEntity findByEmail(String email);
    public PersonalDataEntity save(PersonalDataEntity personalDataEntity);
}
