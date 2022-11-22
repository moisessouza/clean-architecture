package com.workers.queries;

import com.workers.orm.CityORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBCity extends JpaRepository<CityORM, Long> {
}
