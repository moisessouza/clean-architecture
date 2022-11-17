package com.workers.presenters.models.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressOutputImpl implements AddressOutput {

    private boolean error;
    private String message;

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

}
