package com.education.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_ALL_STANDARDS")
@Data
public class AllStandards_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALLSTANDARDSIDVAL")
    @SequenceGenerator(allocationSize = 1, name = "ALLSTANDARDSIDVAL")
    @Column(name = "FLD_ID")
    private int fldId;

    @Column(name = "FLD_STANDARD")
    private String fldStandard;
}
