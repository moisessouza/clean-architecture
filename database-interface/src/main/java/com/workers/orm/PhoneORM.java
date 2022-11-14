package com.workers.orm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@Getter @Setter
public class PhoneORM {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ddi", nullable = false)
    private String ddi;

    @Column(name = "ddd", nullable = false)
    private String ddd;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "personal_data_id")
    private PersonalDataORM user;

}
