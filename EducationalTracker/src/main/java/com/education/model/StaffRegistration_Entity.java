package com.education.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_STAFF_REG")
@Data
public class StaffRegistration_Entity {

    @Column(name = "FLD_CREATED_DATE", insertable = false, updatable = false)
    private String timeStampValue;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STAFFID")
    @SequenceGenerator(allocationSize = 1, name = "STAFFID")
    @Column(name = "FLD_STAFF_ID")
    private String fldStaffId;

    @Column(name = "FLD_FULL_NAME")
    private String fldFullName;

    @Column(name = "FLD_DATE_OF_BIRTH")
    private String fldDateOfBirth;

    @Column(name = "FLD_PHONE")
    private String fldPhone;

    @Column(name = "FLD_EMAIL_ID")
    private String fldEmailId;

    @Column(name = "FLD_GENDER")
    private String fldGender;

    @Column(name = "FLD_SPECIALIZATION")
    private String fldSpecialization;

    @Column(name = "FLD_PASSWORD")
    private String fldPassword;
}
