package com.friends.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_BATCH_INFO")
@Data
public class Batch_Info_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLD_ID")
    private int fldID;

    @Column(name = "FLD_BATCH_NAME")
    private String fldBatchName;
}
