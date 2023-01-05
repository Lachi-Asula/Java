package com.education.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_ALL_SUBJECTS")
@Data
public class AllSubjects_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALLSUBJECTSIDVAL")
    @SequenceGenerator(allocationSize = 1, name = "ALLSUBJECTSIDVAL")
    @Column(name = "FLD_ID")
    private int fldId;

    @Column(name = "FLD_SUBJECT")
    private String fldSubject;
}
