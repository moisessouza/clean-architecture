package com.workers.facade;

import com.workers.models.request.PersonalDataRequest;
import com.workers.models.response.PersonalDataResponse;
import org.springframework.security.core.Authentication;

public interface PersonalDataFacade {
    public PersonalDataResponse save(Authentication authentication, PersonalDataRequest model) throws Exception;
    Object findByEmail(String email);

}
