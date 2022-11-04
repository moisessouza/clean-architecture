package com.workers.presenters;

import com.workers.dto.AnyDTO;
import com.workers.presenters.models.AnyOutput;

public interface AnyPresenter {

    AnyOutput createModelPresenter(AnyDTO modelDTO);

}
