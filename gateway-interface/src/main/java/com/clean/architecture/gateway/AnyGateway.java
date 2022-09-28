package com.clean.architecture.gateway;

import com.clean.architecture.entities.AnyEntity;
import com.clean.architecture.orm.AnyORM;

public interface AnyGateway {

    AnyEntity findAny();

}
