package com.workers.presenters.models;

public class UserInputImpl implements UserInput {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
