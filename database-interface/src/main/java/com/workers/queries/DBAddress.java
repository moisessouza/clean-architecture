package com.workers.queries;

import com.workers.orm.AddressORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBAddress extends JpaRepository<AddressORM, Long> {

    AddressORM findByPersonalDataUserEmail(String email);
    
}
