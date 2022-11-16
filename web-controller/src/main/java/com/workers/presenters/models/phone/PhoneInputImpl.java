package com.workers.presenters.models.phone;

import lombok.Setter;

@Setter
public class PhoneInputImpl implements PhoneInput {

    private Long id;
    private String ddi;
    private String ddd;
    private String phoneNumber;
    private String userEmail;

    @Override
    public Long getId() {
        return id;
    }
    @Override
    public String getDdi() {
        return ddi;
    }

    @Override
    public String getDdd() {
        return ddd;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getUserEmail() {
        return userEmail;
    }
}
