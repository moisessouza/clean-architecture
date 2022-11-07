package com.workers.usecase.impl;

import com.workers.entities.UserEntity;
import com.workers.gateway.UserGateway;
import com.workers.dto.UserDTO;
import com.workers.presenters.models.UserInput;
import com.workers.presenters.models.UserOutput;
import com.workers.presenters.UserPresenter;
import com.workers.usecase.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public UserGateway userGateway;
    public UserPresenter userPresenter;

    public UserServiceImpl(UserGateway userGateway, UserPresenter userPresenter) {
        this.userGateway = userGateway;
        this.userPresenter = userPresenter;
    }

    @Override
    public UserOutput save(UserInput userInput) {

        UserEntity entity = new UserEntity();
        entity.setValue(userInput.getValue());

        userGateway.save(entity);

        UserDTO userDTO = new UserDTO();
        userDTO.setValue(entity.getValue());

        return userPresenter.createModelPresenter(userDTO);

    }

}
