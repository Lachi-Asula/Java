package com.friends.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_CSE402")
@Data
@Builder
public class Batch_CSE402_Entity {

    @Column(name = "FLD_CREATED_DATE", insertable = false, updatable = false)
    private String timeStampValue;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch05")
    @SequenceGenerator(allocationSize = 1, name = "batch05")
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

    public String getTimeStampValue() {
        return timeStampValue;
    }

    public void setTimeStampValue(String timeStampValue) {
        this.timeStampValue = timeStampValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFldEmpId() {
        return fldEmpId;
    }

    public void setFldEmpId(String fldEmpId) {
        this.fldEmpId = fldEmpId;
    }

    public String getFldFullName() {
        return fldFullName;
    }

    public void setFldFullName(String fldFullName) {
        this.fldFullName = fldFullName;
    }

    public String getFldStaffName() {
        return fldStaffName;
    }

    public void setFldStaffName(String fldStaffName) {
        this.fldStaffName = fldStaffName;
    }

    public String getFldYear() {
        return fldYear;
    }

    public void setFldYear(String fldYear) {
        this.fldYear = fldYear;
    }

    public String getFldMonth() {
        return fldMonth;
    }

    public void setFldMonth(String fldMonth) {
        this.fldMonth = fldMonth;
    }

    public String getFldStatus() {
        return fldStatus;
    }

    public void setFldStatus(String fldStatus) {
        this.fldStatus = fldStatus;
    }
}
