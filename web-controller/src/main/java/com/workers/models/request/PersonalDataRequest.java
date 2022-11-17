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

    private String country;
    private String zipPostal;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String complement;
    private String userEmail;
}
