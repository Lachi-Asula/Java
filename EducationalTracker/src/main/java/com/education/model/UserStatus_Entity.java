package com.education.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_AUDIT_USER_STATUS")
@Data
public class UserStatus_Entity {

    @Column(name = "FLD_CREATED_DATE", insertable = false, updatable = false)
    private String timeStampValue;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUSIDVAL")
    @SequenceGenerator(allocationSize = 1, name = "STATUSIDVAL")
    @Column(name = "FLD_ID")
    private int fldId;

    @Column(name = "FLD_USER_ID")
    private String fldUserId;

    @Column(name = "FLD_BLOCKED_TIME")
    private Date fldBlockedTime;

    @Column(name = "FLD_TEMP_COUNT")
    private int fldTempCount;

    @Column(name = "FLD_PERM_COUNT")
    private int fldPermCount;
}
