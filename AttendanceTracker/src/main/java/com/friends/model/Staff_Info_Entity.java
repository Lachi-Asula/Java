package com.friends.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_AUDIT_STAFF_INFO")
@Data
public class Staff_Info_Entity {

    @Id
    @Column(name = "FLD_EMP_ID")
    private String fldEmpId;

    @Column(name = "FLD_FULL_NAME")
    private String fldFullName;

    @Column(name = "FLD_EMAIL_ID")
    private String fldEmailId;

    @Column(name = "FLD_PHONE")
    private String fldPhone;

    @Column(name = "FLD_GENDER")
    private String fldGender;

    @Column(name = "FLD_SPECIALIZATION")
    private String fldSpecialization;

    @Column(name = "FLD_PASSWORD")
    private String fldPassword;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FLD_STAFF_ID", referencedColumnName = "FLD_EMP_ID")
    private List<Batch_Info_Entity> fld_Staff_Id;
}
