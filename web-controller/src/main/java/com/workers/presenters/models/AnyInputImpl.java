package com.workers.presenters.models;

public class AnyInputImpl implements AnyInput {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
