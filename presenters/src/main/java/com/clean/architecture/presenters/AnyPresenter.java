package com.clean.architecture.presenters;

import com.clean.architecture.dto.AnyDTO;
import com.clean.architecture.presenters.models.AnyModel;

public interface AnyPresenter {

    AnyModel createModelPresenter(AnyDTO modelDTO);

}
