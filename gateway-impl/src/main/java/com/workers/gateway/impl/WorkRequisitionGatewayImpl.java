package com.workers.gateway.impl;

import com.workers.entities.WorkRequisitionEntity;
import com.workers.gateway.WorkRequisitionGateway;
import com.workers.gateway.exceptions.WorkRegistrationNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRequisitionGatewayImpl implements WorkRequisitionGateway {

    @Override
    public List<WorkRequisitionEntity> findByEmail(String email) {
        return List.of();
    }

    @Override
    public WorkRequisitionEntity save(WorkRequisitionEntity entity) {
        return null;
    }

    @Override
    public WorkRequisitionEntity delete(Long id) throws WorkRegistrationNotFoundException {
        return null;
    }

    @Override
    public WorkRequisitionEntity findById(Long id) throws WorkRegistrationNotFoundException {
        return null;
    }
}
