package com.workers.queries;

import com.workers.orm.PersonalDataORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBPhone  extends JpaRepository<PersonalDataORM, Long> {
}
