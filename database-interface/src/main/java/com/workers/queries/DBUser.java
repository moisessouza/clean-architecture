package com.workers.queries;

import com.workers.orm.UserORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBUser extends JpaRepository<UserORM, Long> {
    UserORM findByEmail(String email);
}
