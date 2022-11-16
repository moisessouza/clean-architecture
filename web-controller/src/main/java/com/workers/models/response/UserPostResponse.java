package com.workers.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPostResponse {

    public boolean hasError;
    public String message;
    public String forward;

    public String email;
    public String password;

}
