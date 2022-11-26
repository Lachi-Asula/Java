package com.friends.service;

import com.friends.dto.CommonResponse;
import com.friends.dto.Emp_Info_Dto;

public interface Emp_Register {

    CommonResponse Emp_Registration(Emp_Info_Dto empInfoDto);
}
