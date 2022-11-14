package com.workers.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PersonalDataEntity {
    private Long id;
    private String name;
    private String documentNumber;
    private Date birthdate;
    private UserEntity user;
}
