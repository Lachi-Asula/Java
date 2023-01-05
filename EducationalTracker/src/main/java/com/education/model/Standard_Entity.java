package com.education.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_STANDARD")
@Data
public class Standard_Entity {

    @Column(name = "FLD_CREATED_DATE", insertable = false, updatable = false)
    private String timeStampValue;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STANDARDIDVAL")
    @SequenceGenerator(allocationSize = 1, name = "STANDARDIDVAL")
    @Column(name = "FLD_ID")
    private Long fldId;

    @Column(name = "FLD_STANDARD")
    private String fldStandard;

}
