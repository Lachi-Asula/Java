package com.friends.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.apache.commons.lang3.StringUtils;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenerateTokenDto {
    @JsonProperty("Token")
    private String token;

    @JsonProperty("UserName")
    private String userName;

    @JsonProperty("TokenExpiryDate")
    private String tokenExpiryDate;

    @JsonProperty("IssuerName")
    private String issuedBy;

    @JsonProperty("ErrorCode")
    private String errorCode;

    @JsonProperty("ErrorMessage")
    private String errorMsg;

    public String getToken() {
        return trimStr(token);
    }

    public void setToken(String token) {
        this.token = trimStr(token);
    }

    public String getUserName() {
        return trimStr(userName);
    }

    public void setUserName(String userName) {
        this.userName = trimStr(userName);
    }

    public String getTokenExpiryDate() {
        return trimStr(tokenExpiryDate);
    }

    public void setTokenExpiryDate(String tokenExpiryDate) {
        this.tokenExpiryDate = trimStr(tokenExpiryDate);
    }

    public String getIssuedBy() {
        return trimStr(issuedBy);
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = trimStr(issuedBy);
    }

    public String getErrorCode() {
        return trimStr(errorCode);
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = trimStr(errorCode);
    }

    public String getErrorMsg() {
        return trimStr(errorMsg);
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = trimStr(errorMsg);
    }

    public GenerateTokenDto() {
    }

    public GenerateTokenDto(String token, String userName, String tokenExpiryDate, String issuedBy, String errorCode, String errorMsg) {
        this.token = trimStr(token);
        this.userName = trimStr(userName);
        this.tokenExpiryDate = trimStr(tokenExpiryDate);
        this.issuedBy = trimStr(issuedBy);
        this.errorCode = trimStr(errorCode);
        this.errorMsg = trimStr(errorMsg);
    }

    private String trimStr(String value){
        if(StringUtils.isNotBlank(value)){
            return value.trim();
        }else {
            return null;
        }
    }
}
