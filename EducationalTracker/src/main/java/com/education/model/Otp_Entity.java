package com.education.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_OTP_INFO")
@Data
public class Otp_Entity {

    @Column(name = "FLD_CREATED_DATE", insertable = false, updatable = false)
    private String timeStampValue;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OTPIDVAL")
    @SequenceGenerator(allocationSize = 1, name = "OTPIDVAL")
    @Column(name = "FLD_ID")
    private int fldId;

    @Column(name = "FLD_USER_ID")
    private String fldUserId;

    @Column(name = "FLD_OTP_VALUE")
    private String fldOtpValue;
}
