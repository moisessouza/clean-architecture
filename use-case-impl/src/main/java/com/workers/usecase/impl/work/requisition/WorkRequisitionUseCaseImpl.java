package com.workers.usecase.impl.work.requisition;

import com.workers.entities.WorkRequisitionEntity;
import com.workers.gateway.WorkRequisitionGateway;
import com.workers.presenters.WorkRequisitionPresenter;
import com.workers.presenters.models.work.requisition.WorkRequisitionInput;
import com.workers.presenters.models.work.requisition.WorkRequisitionOutput;
import com.workers.usecase.impl.helper.EmailHelper;
import com.workers.usecase.work.requisition.WorkRequisitionUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRequisitionUseCaseImpl implements WorkRequisitionUseCase {

    private WorkRequisitionGateway workRequisitionGateway;
    private WorkRequisitionPresenter presenter;

    public WorkRequisitionUseCaseImpl(WorkRequisitionGateway workRequisitionGateway,
                                      WorkRequisitionPresenter presenter) {
        this.workRequisitionGateway = workRequisitionGateway;
        this.presenter = presenter;
    }

    @Override
    public WorkRequisitionOutput findByEmail(WorkRequisitionInput input) {

        if (!EmailHelper.checkEmailIsValid(input.getEmail())) {
            return presenter.createError(input, "work.requisition.error.invalid.email");
        }

        List<WorkRequisitionEntity> workRequisitions = workRequisitionGateway.findByEmail(input.getEmail());

        return presenter.createSuccessFindEmail(workRequisitions, "work.requisition.success.find.email");

    }

    @Override
    public WorkRequisitionOutput save(WorkRequisitionInput input) {
        return null;
    }

    @Override
    public WorkRequisitionOutput delete(WorkRequisitionInput input) {
        return null;
    }
}
