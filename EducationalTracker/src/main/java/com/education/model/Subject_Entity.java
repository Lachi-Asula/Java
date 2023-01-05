package com.education.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_SUBJECT")
@Data
public class Subject_Entity {

    @Column(name = "FLD_CREATED_DATE", insertable = false, updatable = false)
    private String timeStampValue;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBJECTIDVAL")
    @SequenceGenerator(allocationSize = 1, name = "SUBJECTIDVAL")
    @Column(name = "FLD_ID")
    private Long fldId;

    @Column(name = "FLD_SUBJECT")
    private String fldSubject;
}
