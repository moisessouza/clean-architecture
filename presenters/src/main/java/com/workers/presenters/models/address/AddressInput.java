package com.workers.presenters.models.address;

public interface AddressInput {
    Long getId();
    String getCountry();
    String getZipPostal();
    String getState();
    String getCity();
    String getNeighborhood();
    String getStreet();
    String getNumber();
    String getComplement();
    String getUserEmail();
}
