package com.workers.presenters;

import com.workers.entities.WorkRequisitionEntity;
import com.workers.presenters.models.work.requisition.WorkRequisitionInput;
import com.workers.presenters.models.work.requisition.WorkRequisitionOutput;

import java.util.List;

public interface WorkRequisitionPresenter {
    WorkRequisitionOutput createError(WorkRequisitionInput input, String messageCode);

    WorkRequisitionOutput createSuccessFindEmail(List<WorkRequisitionEntity> workRequisitions, String s);
}
