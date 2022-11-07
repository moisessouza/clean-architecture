package com.workers.presenters.models;

public class UserInputImpl implements UserInput {

    private String email;
    private String password;

    public UserInputImpl (String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
