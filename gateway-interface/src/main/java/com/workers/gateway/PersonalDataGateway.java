package com.workers.gateway;

import com.workers.entities.PersonalDataEntity;

public interface PersonalDataGateway {
    public PersonalDataEntity save(PersonalDataEntity personalDataEntity);
}
