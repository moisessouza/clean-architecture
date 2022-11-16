package com.workers.presenters.models.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputImpl implements UserOutput {

    public boolean error;
    public String message;
    public String forward;

    public String email;
    public String password;

    @Override
    public boolean isError() {
        return error;
    }

}
