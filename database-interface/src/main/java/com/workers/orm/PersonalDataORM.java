package com.workers.orm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PersonalData")
@Getter
@Setter
public class PersonalDataORM {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="document_number", nullable = false)
    private String documentNumber;

    @Column(name="birthdate", nullable = false)
    private Date birthdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserORM user;

}
