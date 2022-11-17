package com.workers.presenters.models.address;

import lombok.Setter;

@Setter
public class AddressInputImpl implements AddressInput {

    private Long id;
    private String country;
    private String zipPostal;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String complement;
    private String userEmail;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getZipPostal() {
        return zipPostal;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getNeighborhood() {
        return neighborhood;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getComplement() {
        return complement;
    }

    @Override
    public String getUserEmail() {
        return userEmail;
    }

}
