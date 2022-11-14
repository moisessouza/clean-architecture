package com.workers.queries;

import com.workers.orm.PhoneORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBPhone extends JpaRepository<PhoneORM, Long> {
    PhoneORM findByPersonalDataUserEmail(String email);

}
