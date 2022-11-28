package com.workers.gateway;

import com.workers.entities.WorkRequisitionEntity;
import com.workers.gateway.exceptions.WorkRegistrationNotFoundException;

import java.util.List;

public interface WorkRequisitionGateway {

    List<WorkRequisitionEntity> findByEmail(String email);

    WorkRequisitionEntity save (WorkRequisitionEntity entity);

    WorkRequisitionEntity delete (WorkRequisitionEntity entity);

    WorkRequisitionEntity findById(Long id) throws WorkRegistrationNotFoundException;
}
