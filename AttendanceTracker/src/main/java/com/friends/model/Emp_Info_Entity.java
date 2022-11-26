package com.friends.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_EMP_INFO")
@Data
public class Emp_Info_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDVAL")
    @SequenceGenerator(allocationSize = 1, name = "IDVAL")
    @Column(name = "FLD_ID")
    private int id;

    @Column(name = "FLD_EMP_ID")
    private String fldEmpId;

    @Column(name = "FLD_FULL_NAME")
    private String fldFullName;

    @Column(name = "FLD_EMAIL_ID")
    private String fldEmailId;

    @Column(name = "FLD_GENDER")
    private String fldGender;

    @Column(name = "FLD_BATCH_NUM")
    private String fldBatchNum;

    @Column(name = "FLD_PHONE_NUM")
    private String fldPhoneNum;

    @Column(name = "FLD_STATUS")
    private String fldStatus;
}
