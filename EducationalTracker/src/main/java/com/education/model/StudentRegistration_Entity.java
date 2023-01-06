package com.education.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_STUDENT_REG")
public class StudentRegistration_Entity {

    @Column(name = "FLD_CREATED_DATE", insertable = false, updatable = false)
    private String timeStampValue;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTIDVAL")
    @SequenceGenerator(allocationSize = 1, name = "STUDENTIDVAL")
    @Column(name = "FLD_ID")
    private int fldId;

    @Column(name = "FLD_STUDENT_ID")
    private String fldStudentId;

    @Column(name = "FLD_FULL_NAME")
    private String fldFullName;

    @Column(name = "FLD_FATHER_NAME")
    private String fldFatherName;

    @Column(name = "FLD_MOTHER_NAME")
    private String fldMotherName;

    @Column(name = "FLD_DATE_OF_BIRTH")
    private String fldDateOfBirth;

    @Column(name = "FLD_PHONE")
    private String fldPhone;

    @Column(name = "FLD_GENDER")
    private String fldGender;

    @Column(name = "FLD_STANDARD")
    private String fldStandard;

    @Column(name = "FLD_TOTAL_FEE")
    private double fldTotalAmount;

    @Column(name = "FLD_AMOUNT_PAID")
    private double fldAmountPaid;

    @Column(name = "FLD_AMOUNT_DUE")
    private double fldAmountDue;

    public String getTimeStampValue() {
        return timeStampValue;
    }

    public void setTimeStampValue(String timeStampValue) {
        this.timeStampValue = timeStampValue;
    }

    public int getFldId() {
        return fldId;
    }

    public void setFldId(int fldId) {
        this.fldId = fldId;
    }

    public String getFldStudentId() {
        return fldStudentId;
    }

    public void setFldStudentId(String fldStudentId) {
        this.fldStudentId = fldStudentId;
    }

    public String getFldFullName() {
        return fldFullName;
    }

    public void setFldFullName(String fldFullName) {
        this.fldFullName = fldFullName;
    }

    public String getFldFatherName() {
        return fldFatherName;
    }

    public void setFldFatherName(String fldFatherName) {
        this.fldFatherName = fldFatherName;
    }

    public String getFldMotherName() {
        return fldMotherName;
    }

    public void setFldMotherName(String fldMotherName) {
        this.fldMotherName = fldMotherName;
    }

    public String getFldDateOfBirth() {
        return fldDateOfBirth;
    }

    public void setFldDateOfBirth(String fldDateOfBirth) {
        this.fldDateOfBirth = fldDateOfBirth;
    }

    public String getFldPhone() {
        return fldPhone;
    }

    public void setFldPhone(String fldPhone) {
        this.fldPhone = fldPhone;
    }

    public String getFldGender() {
        return fldGender;
    }

    public void setFldGender(String fldGender) {
        this.fldGender = fldGender;
    }

    public String getFldStandard() {
        return fldStandard;
    }

    public void setFldStandard(String fldStandard) {
        this.fldStandard = fldStandard;
    }

    public double getFldTotalAmount() {
        return fldTotalAmount;
    }

    public void setFldTotalAmount(double fldTotalAmount) {
        this.fldTotalAmount = fldTotalAmount;
    }

    public double getFldAmountPaid() {
        return fldAmountPaid;
    }

    public void setFldAmountPaid(double fldAmountPaid) {
        this.fldAmountPaid = fldAmountPaid;
    }

    public double getFldAmountDue() {
        return fldAmountDue;
    }

    public void setFldAmountDue(double fldAmountDue) {
        this.fldAmountDue = fldAmountDue;
    }
}
