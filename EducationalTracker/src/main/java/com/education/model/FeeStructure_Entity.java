package com.education.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_FEE_STRUCTURE")
@Data
public class FeeStructure_Entity {

    @Column(name = "FLD_CREATED_DATE", insertable = false, updatable = false)
    private String timeStampValue;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FEEIDVAL")
    @SequenceGenerator(allocationSize = 1, name = "FEEIDVAL")
    @Column(name = "FLD_ID")
    private int fldId;

    @Column(name = "FLD_STANDARD")
    private String fldStandard;

    @Column(name = "FLD_FEE_AMOUNT")
    private double fldFeeAmount;
}
