package com.workers.presenters.models;

import com.workers.presenters.models.user.UserInput;

public class UserInputImpl implements UserInput {

    private Long id;
    private String email;
    private String password;

    public UserInputImpl (Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Override
    public Long getId() {
        return id;
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
