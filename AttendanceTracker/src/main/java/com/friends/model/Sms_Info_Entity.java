package com.friends.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_AUDIT_SMS_INFO")
@Data
public class Sms_Info_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SMSIDVAL")
    @SequenceGenerator(allocationSize = 1, name = "SMSIDVAL")
    @Column(name = "FLD_ID")
    private int id;

    @Column(name = "FLD_EMP_ID")
    private String fldEmpId;

    @Column(name = "FLD_OTP_VALUE")
    private String fldOtpValue;

}
