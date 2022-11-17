package com.workers.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonalDataResponse {

    private boolean hasError;
    private String message;

    private String name;
    private String documentNumber;
    private String birthdate;

    private String ddi;
    private String ddd;
    private String phoneNumber;

    private String country;
    private String zipPostal;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String complement;

    private String forward;
}
