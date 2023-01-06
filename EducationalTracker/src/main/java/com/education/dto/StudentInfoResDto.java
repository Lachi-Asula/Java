package com.education.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import static com.education.utils.SpringUtils.trimStr;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StudentInfoResDto {

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("ErrorMessage")
    private String errorMsg;

    @JsonProperty("UserId")
    private String userId;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("FatherName")
    private String fatherName;

    @JsonProperty("PhoneNumber")
    private String phoneNum;

    @JsonProperty("MotherName")
    private String motherName;

    @JsonProperty("DateOfBirth")
    private String dateOfBirth;

    @JsonProperty("Gender")
    private String gender;

    @JsonProperty("Standard")
    private String standard;

    @JsonProperty("TotalAmount")
    private double totalAmount;

    @JsonProperty("AmountPaid")
    private double amountPaid;

    @JsonProperty("AmountDue")
    private double amountDue;

    public String getStatusCode() {
        return trimStr(statusCode);
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = trimStr(statusCode);
    }

    public String getErrorMsg() {
        return trimStr(errorMsg);
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = trimStr(errorMsg);
    }

    public String getUserId() {
        return trimStr(userId);
    }

    public void setUserId(String userId) {
        this.userId = trimStr(userId);
    }

    public String getFullName() {
        return trimStr(fullName);
    }

    public void setFullName(String fullName) {
        this.fullName = trimStr(fullName);
    }

    public String getFatherName() {
        return trimStr(fatherName);
    }

    public void setFatherName(String fatherName) {
        this.fatherName = trimStr(fatherName);
    }

    public String getPhoneNum() {
        return trimStr(phoneNum);
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = trimStr(phoneNum);
    }

    public String getMotherName() {
        return trimStr(motherName);
    }

    public void setMotherName(String motherName) {
        this.motherName = trimStr(motherName);
    }

    public String getDateOfBirth() {
        return trimStr(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = trimStr(dateOfBirth);
    }

    public String getGender() {
        return trimStr(gender);
    }

    public void setGender(String gender) {
        this.gender = trimStr(gender);
    }

    public String getStandard() {
        return trimStr(standard);
    }

    public void setStandard(String standard) {
        this.standard = trimStr(standard);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }
}
