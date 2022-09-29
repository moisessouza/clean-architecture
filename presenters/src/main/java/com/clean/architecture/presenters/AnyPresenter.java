package com.clean.architecture.presenters;

import com.clean.architecture.dto.AnyDTO;
import com.clean.architecture.presenters.models.AnyOutput;

public interface AnyPresenter {

    AnyOutput createModelPresenter(AnyDTO modelDTO);

}
