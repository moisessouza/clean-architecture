package com.workers.presenters.models;

import com.workers.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserOutputImpl implements UserOutput {

    public boolean hasError;
    public String message;
    public String forward;
    @Override
    public boolean hasError() {
        return hasError;
    }

}
