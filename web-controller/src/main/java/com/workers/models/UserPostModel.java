package com.workers.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostModel {
    private Long id;
    private String email;
    private String password;
}
