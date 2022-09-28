package com.clean.architecture.presenters.impl;

import com.clean.architecture.dto.AnyDTO;
import com.clean.architecture.presenters.models.AnyModel;
import com.clean.architecture.presenters.AnyPresenter;
import com.clean.architecture.presenters.models.AnyModelImpl;

public class AnyPresenterImpl implements AnyPresenter {
    @Override
    public AnyModel createModelPresenter(AnyDTO modelPresenter) {
        return new AnyModelImpl(modelPresenter);
    }
}
