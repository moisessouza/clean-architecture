package com.workers.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    private Long id;
    private String country;
    private String zipPostal;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String complement;

    private PersonalDataEntity personalData;

}
