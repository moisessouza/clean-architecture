package com.workers.queries;

import com.workers.orm.StateORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBState extends JpaRepository<StateORM, Long> {
}
