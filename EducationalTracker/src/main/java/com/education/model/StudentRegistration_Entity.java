package com.education.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_STUDENT_REG")
@Data
public class StudentRegistration_Entity {

    @Column(name = "FLD_CREATED_DATE", insertable = false, updatable = false)
    private String timeStampValue;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTIDVAL")
    @SequenceGenerator(allocationSize = 1, name = "STUDENTIDVAL")
    @Column(name = "FLD_ID")
    private int fldId;

    @Column(name = "FLD_STUDENT_ID")
    private String fldStudentId;

    @Column(name = "FLD_FULL_NAME")
    private String fldFullName;

    @Column(name = "FLD_FATHER_NAME")
    private String fldFatherName;

    @Column(name = "FLD_MOTHER_NAME")
    private String fldMotherName;

    @Column(name = "FLD_DATE_OF_BIRTH")
    private String fldDateOfBirth;

    @Column(name = "FLD_PHONE")
    private String fldPhone;

    @Column(name = "FLD_GENDER")
    private String fldGender;

    @Column(name = "FLD_STANDARD")
    private String fldStandard;

}
