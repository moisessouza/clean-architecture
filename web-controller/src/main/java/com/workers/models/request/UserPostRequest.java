package com.workers.models.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostRequest {
    private Long id;
    private String email;
    private String password;
}
