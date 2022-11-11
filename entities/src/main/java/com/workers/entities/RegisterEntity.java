package com.workers.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class RegisterEntity {
    private String name;
    private String documentNumber;
    private Date birthdate;
    private Long userId;
}
