package com.workers.orm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personal_data")
@Getter @Setter
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
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserORM user;

}
