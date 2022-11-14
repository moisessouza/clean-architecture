package com.workers.queries;

import com.workers.orm.PersonalDataORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBPersonalData extends JpaRepository<PersonalDataORM, Long> {
}
