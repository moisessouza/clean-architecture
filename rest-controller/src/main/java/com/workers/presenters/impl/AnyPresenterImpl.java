package com.workers.presenters.impl;

import com.workers.dto.AnyDTO;
import com.workers.presenters.AnyPresenter;
import com.workers.presenters.models.AnyOutput;
import com.workers.presenters.models.AnyOutputImpl;
import org.springframework.stereotype.Service;

@Service
public class AnyPresenterImpl implements AnyPresenter {
    @Override
    public AnyOutput createModelPresenter(AnyDTO modelPresenter) {
        return new AnyOutputImpl(modelPresenter);
    }
}
