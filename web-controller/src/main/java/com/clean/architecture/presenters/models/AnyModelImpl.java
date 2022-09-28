package com.clean.architecture.presenters.models;

import com.clean.architecture.dto.AnyDTO;

public class AnyModelImpl implements AnyModel {


    public AnyModelImpl () {}

    public AnyModelImpl(AnyDTO dto) {
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
