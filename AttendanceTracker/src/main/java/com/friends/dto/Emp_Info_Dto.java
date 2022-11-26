package com.friends.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Emp_Info_Dto {
    private int id;
    private String fldEmpId;
    private String fldFullName;
    private String fldEmailId;
    private String fldGender;
    private String fldBatchNum;
    private String fldPhoneNum;
    private String fldStatus;
}
