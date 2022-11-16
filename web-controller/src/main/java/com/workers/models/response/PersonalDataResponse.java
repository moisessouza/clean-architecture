package com.workers.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonalDataResponse {
    private String name;
    private String documentNumber;
    private String birthdate;
    private String ddi;
    private String ddd;
    private String phoneNumber;
    private String forward;
}
