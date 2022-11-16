package com.workers.models.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalDataRequest {
    private String name;
    private String documentNumber;
    private String birthdate;
    private String ddi;
    private String ddd;
    private String phoneNumber;
}
