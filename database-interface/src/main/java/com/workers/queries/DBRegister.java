package com.workers.queries;

import com.workers.orm.RegisterORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBRegister extends JpaRepository<RegisterORM, Long> {
}
