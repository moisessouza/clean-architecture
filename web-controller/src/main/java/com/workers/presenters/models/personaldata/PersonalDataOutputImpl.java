package com.workers.presenters.models.personaldata;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalDataOutputImpl implements PersonalDataOutput {

    public boolean hasError;
    public String message;

    private String name;
    private String documentNumber;
    private String birthdate;

    private String forward;

}
