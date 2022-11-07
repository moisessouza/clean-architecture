package com.workers.presenters.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserOutputImpl implements UserOutput {

    public UserOutputImpl() {}

    public boolean hasError;
    public String message;
    public String forward;

    public String email;
    public String password;

    @Override
    public boolean hasError() {
        return hasError;
    }

}
