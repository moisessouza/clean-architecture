package com.workers.presenters.impl;

import com.workers.entities.WorkRequisitionEntity;
import com.workers.presenters.WorkRequisitionPresenter;
import com.workers.presenters.models.work.requisition.WorkRequisitionInput;
import com.workers.presenters.models.work.requisition.WorkRequisitionOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRequisitionPresenterImpl implements WorkRequisitionPresenter {
    @Override
    public WorkRequisitionOutput createError(WorkRequisitionInput input, String messageCode) {
        return null;
    }

    @Override
    public WorkRequisitionOutput createSuccessFindEmail(List<WorkRequisitionEntity> workRequisitions, String messageCode) {
        return null;
    }

    @Override
    public WorkRequisitionOutput createSuccessFindId(WorkRequisitionEntity entity, String messageCode) {
        return null;
    }

    @Override
    public WorkRequisitionOutput createErrorFindId(WorkRequisitionInput input, String messageCode) {
        return null;
    }

    @Override
    public WorkRequisitionOutput createSuccess(WorkRequisitionEntity entity, String messageCode) {
        return null;
    }
}
