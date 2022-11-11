package com.workers.usecase;

import com.workers.presenters.models.user.UserInput;
import com.workers.presenters.models.user.UserOutput;

public interface UserService {
    UserOutput save(UserInput userInput);

    UserOutput findByEmail(UserInput userInput);
}
