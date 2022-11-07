package com.workers.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserEntity {

    private String email;
    private String password;

    public String getValue() {
        return email;
    }

}
