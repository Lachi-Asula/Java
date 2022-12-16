package com.friends.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_MCA203")
@Data
@Builder
public class Batch_MCA203_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch03")
    @SequenceGenerator(allocationSize = 1, name = "batch03")
    @Column(name = "FLD_ID")
    private int id;

    @Column(name = "FLD_EMP_ID")
    private String fldEmpId;

    @Column(name = "FLD_FULL_NAME")
    private String fldFullName;

    @Column(name = "FLD_STAFF_NAME")
    private String fldStaffName;

    @Column(name = "FLD_YEAR")
    private String fldYear;

    @Column(name = "FLD_MONTH")
    private String fldMonth;

    @Column(name = "FLD_STATUS")
    private String fldStatus;

    public Batch_MCA203_Entity() {
    }

    public Batch_MCA203_Entity(int id, String fldEmpId, String fldFullName, String fldStaffName, String fldYear, String fldMonth, String fldStatus) {
        this.id = id;
        this.fldEmpId = fldEmpId;
        this.fldFullName = fldFullName;
        this.fldStaffName = fldStaffName;
        this.fldYear = fldYear;
        this.fldMonth = fldMonth;
        this.fldStatus = fldStatus;
    }
}
