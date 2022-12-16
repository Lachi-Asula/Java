package com.friends.service;

import com.friends.dto.Login_Req_Dto;
import com.friends.dto.Login_Res_Dto;

import java.util.Optional;

public interface GetEmpRole {

   Login_Res_Dto getEmpRoleServ(String empId);

   Login_Res_Dto getAllbatches();
}
