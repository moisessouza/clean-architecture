package com.workers.usecase;

import com.workers.presenters.models.register.RegisterInput;
import com.workers.presenters.models.register.RegisterOutput;

public interface RegisterService {
    RegisterOutput save(RegisterInput registerInput);
}
