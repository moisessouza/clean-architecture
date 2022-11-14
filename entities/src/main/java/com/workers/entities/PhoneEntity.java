package com.workers.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneEntity {
    private Long id;
    private String ddi;
    private String ddd;
    private String phoneNumber;
    private PersonalDataEntity personalData;
}
