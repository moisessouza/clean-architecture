package com.workers.usecase;

import com.workers.presenters.models.UserInput;
import com.workers.presenters.models.UserOutput;

public interface UserService {
    UserOutput save(UserInput userInput);
}
