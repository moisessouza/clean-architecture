package com.workers.presenters.models;

import com.workers.dto.AnyDTO;

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
