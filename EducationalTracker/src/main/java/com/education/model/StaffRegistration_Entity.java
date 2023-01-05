package com.education.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_AUDIT_STAFF_REG")
@Data
public class StaffRegistration_Entity {

    @Column(name = "FLD_CREATED_DATE", insertable = false, updatable = false)
    private String timeStampValue;

    @Id
    @Column(name = "FLD_STAFF_ID")
    private String fldStaffId;

    @Column(name = "FLD_FULL_NAME")
    @JsonProperty("FullName")
    private String fldFullName;

    @Column(name = "FLD_DATE_OF_BIRTH")
    @JsonProperty("DateOfBirth")
    private String fldDateOfBirth;

    @Column(name = "FLD_PHONE")
    @JsonProperty("PhoneNumber")
    private String fldPhone;

    @Column(name = "FLD_EMAIL_ID")
    @JsonProperty("EmailId")
    private String fldEmailId;

    @Column(name = "FLD_GENDER")
    @JsonProperty("Gender")
    private String fldGender;

    @Column(name = "FLD_SPECIALIZATION")
    @JsonProperty("Role")
    private String fldSpecialization;

    @Column(name = "FLD_PASSWORD")
    @JsonProperty("Password")
    private String fldPassword;

    @JsonProperty("Standards")
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "FLD_STAFF_ID", referencedColumnName = "FLD_STAFF_ID")
    private List<Standard_Entity> fldStandard;

    @JsonProperty("Subjects")
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "FLD_STAFF_ID", referencedColumnName = "FLD_STAFF_ID")
    private List<Subject_Entity> fldSubject;
}
