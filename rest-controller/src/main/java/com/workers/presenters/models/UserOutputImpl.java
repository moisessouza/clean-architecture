package com.workers.presenters.models;

import com.workers.dto.UserDTO;

public class UserOutputImpl implements UserOutput {


    public UserOutputImpl() {}

    public UserOutputImpl(UserDTO dto) {
        this.value = dto.getValue();
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
