package com.workers.usecase.work.requisition;

import com.workers.presenters.models.work.requisition.WorkRequisitionInput;
import com.workers.presenters.models.work.requisition.WorkRequisitionOutput;

public interface WorkRequisitionUseCase {

    WorkRequisitionOutput findByEmail(WorkRequisitionInput input);

    WorkRequisitionOutput save(WorkRequisitionInput input);

    WorkRequisitionOutput delete(WorkRequisitionInput input);

}
