package com.clean.architecture.presenters.models;

import com.clean.architecture.dto.AnyDTO;

public class AnyOutputImpl implements AnyOutput {


    public AnyOutputImpl() {}

    public AnyOutputImpl(AnyDTO dto) {
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
