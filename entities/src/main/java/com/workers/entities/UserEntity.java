package com.workers.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserEntity {
    private Long id;
    private String email;
    private String password;
}
