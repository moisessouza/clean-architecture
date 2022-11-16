package com.workers.presenters.models.personaldata;

import lombok.Setter;

import java.util.Date;

@Setter
public class PersonalDataInputImpl implements PersonalDataInput {

    private String name;
    private String documentNumber;
    private Date birthdate;
    private String userEmail;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDocumentNumber() {
        return documentNumber;
    }

    @Override
    public Date getBirthdate() {
        return birthdate;
    }

    @Override
    public String getUserEmail() {
        return userEmail;
    }

}
