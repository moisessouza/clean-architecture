package com.workers.orm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "user")
@Getter @Setter
public class UserORM {
    private Long id;
    private String email;
    private String password;
}
