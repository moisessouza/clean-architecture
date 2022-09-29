package com.clean.architecture.presenters.impl;

import com.clean.architecture.dto.AnyDTO;
import com.clean.architecture.presenters.AnyPresenter;
import com.clean.architecture.presenters.models.AnyOutput;
import com.clean.architecture.presenters.models.AnyOutputImpl;
import org.springframework.stereotype.Service;

@Service
public class AnyPresenterImpl implements AnyPresenter {
    @Override
    public AnyOutput createModelPresenter(AnyDTO modelPresenter) {
        return new AnyOutputImpl(modelPresenter);
    }
}
