package com.workers.presenters;

import com.workers.dto.UserDTO;
import com.workers.presenters.models.UserOutput;

public interface UserPresenter {

    UserOutput createModelPresenter(UserDTO modelDTO);

}
