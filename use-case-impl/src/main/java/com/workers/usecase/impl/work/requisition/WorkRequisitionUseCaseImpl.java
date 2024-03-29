package com.workers.usecase.impl.work.requisition;

import com.workers.entities.WorkRequisitionEntity;
import com.workers.gateway.WorkRequisitionGateway;
import com.workers.gateway.exceptions.WorkRegistrationNotFoundException;
import com.workers.presenters.WorkRequisitionPresenter;
import com.workers.presenters.models.work.requisition.WorkRequisitionInput;
import com.workers.presenters.models.work.requisition.WorkRequisitionOutput;
import com.workers.usecase.impl.helper.EmailHelper;
import com.workers.usecase.work.requisition.WorkRequisitionUseCase;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public WorkRequisitionOutput findById(WorkRequisitionInput input) {

        try {

            if (!checkIsValidId(input.getId())){
                return presenter.createError(input, "work.requisition.error.invalid.id");
            }

            WorkRequisitionEntity entity = workRequisitionGateway.findById(input.getId());

            return presenter.createSuccessFindId(entity, "work.requisition.success.find.id");

        } catch (WorkRegistrationNotFoundException e) {
            return presenter.createErrorFindId(input, "work.requisition.error.not.found");
        }

    }

    @Override
    public WorkRequisitionOutput save(WorkRequisitionInput input) {

        if (!checkIsValidTitle(input.getTitle())) {
            return presenter.createError(input, "work.requisition.error.invalid.title");
        }

        if (!checkIsValidDescription(input.getDescription())) {
            return presenter.createError(input, "work.requisition.error.invalid.description");
        }

        WorkRequisitionEntity entity = new WorkRequisitionEntity();

        entity.setId(input.getId());
        entity.setTitle(input.getTitle());
        entity.setDescription(input.getDescription());

        workRequisitionGateway.save(entity);

        return presenter.createSuccess(entity, "work.requisition.success.save");

    }

    @Override
    public WorkRequisitionOutput delete(WorkRequisitionInput input) {
        try {

            if (!checkIsValidId(input.getId())){
                return presenter.createError(input, "work.requisition.error.invalid.id");
            }

            WorkRequisitionEntity entity = workRequisitionGateway.delete(input.getId());

            return presenter.createSuccessFindId(entity, "work.requisition.success.delete");

        } catch (WorkRegistrationNotFoundException e) {
            return presenter.createErrorFindId(input, "work.requisition.error.not.found");
        }
    }

    private boolean checkIsValidId(Long id) {
        return id != null;
    }

    private boolean checkIsValidTitle(String title) {
        return StringUtils.hasText(title);
    }

    private boolean checkIsValidDescription(String description) {
        return StringUtils.hasText(description);
    }

}
