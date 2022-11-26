package com.friends.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Staff_Info_Dto {
    private String fldEmpId;
    private String fldFullName;
    private String fldEmailId;
    private String fldGender;
    private String fldSpecialization;
    private String fldPassword;
    private List<Batch_Info_Dto> fld_Staff_Id;
}
