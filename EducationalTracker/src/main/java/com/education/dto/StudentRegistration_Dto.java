package com.education.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.education.utils.SpringUtils.trimStr;


@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentRegistration_Dto {

    @JsonProperty("ID")
    private int fldId;

    @JsonProperty("StudentId")
    private String fldStudentId;

    @JsonProperty("FullName")
    private String fldFullName;

    @JsonProperty("FatherName")
    private String fldFatherName;

    @JsonProperty("MotherName")
    private String fldMotherName;

    @JsonProperty("DateOfBirth")
    private String fldDateOfBirth;

    @JsonProperty("PhoneNumber")
    private String fldPhone;

    @JsonProperty("Gender")
    private String fldGender;

    @JsonProperty("Standard")
    private String fldStandard;

    @JsonProperty("TotalAmount")
    private double fldTotalAmount;

    @JsonProperty("AmountPaid")
    private double fldAmountPaid;

    @JsonProperty("AmountDue")
    private double fldAmountDue;

    public int getFldId() {
        return fldId;
    }

    public void setFldId(int fldId) {
        this.fldId = fldId;
    }

    public String getFldStudentId() {
        return trimStr(fldStudentId);
    }

    public void setFldStudentId(String fldStudentId) {
        this.fldStudentId = trimStr(fldStudentId);
    }

    public String getFldFullName() {
        return trimStr(fldFullName);
    }

    public void setFldFullName(String fldFullName) {
        this.fldFullName = trimStr(fldFullName);
    }

    public String getFldFatherName() {
        return trimStr(fldFatherName);
    }

    public void setFldFatherName(String fldFatherName) {
        this.fldFatherName = trimStr(fldFatherName);
    }

    public String getFldMotherName() {
        return trimStr(fldMotherName);
    }

    public void setFldMotherName(String fldMotherName) {
        this.fldMotherName = trimStr(fldMotherName);
    }

    public String getFldDateOfBirth() {
        return trimStr(fldDateOfBirth);
    }

    public void setFldDateOfBirth(String fldDateOfBirth) {
        this.fldDateOfBirth = trimStr(fldDateOfBirth);
    }

    public String getFldPhone() {
        return trimStr(fldPhone);
    }

    public void setFldPhone(String fldPhone) {
        this.fldPhone = trimStr(fldPhone);
    }

    public String getFldGender() {
        return trimStr(fldGender);
    }

    public void setFldGender(String fldGender) {
        this.fldGender = trimStr(fldGender);
    }

    public String getFldStandard() {
        return trimStr(fldStandard);
    }

    public void setFldStandard(String fldStandard) {
        this.fldStandard = trimStr(fldStandard);
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
