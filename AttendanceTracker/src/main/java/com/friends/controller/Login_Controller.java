package com.friends.controller;

import com.friends.dto.Login_Req_Dto;
import com.friends.dto.Login_Res_Dto;
import com.friends.service.GetEmpRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/attendanceTracking/friends/login")
public class Login_Controller {

    @Autowired
    private GetEmpRole getEmpRole;

    @PostMapping("/getEmpRole")
    public ResponseEntity<Login_Res_Dto> getEmpRole(@Valid @RequestBody Login_Req_Dto loginReqDto){
        Login_Res_Dto loginResDto = getEmpRole.getEmpRoleServ(loginReqDto);
        return ResponseEntity.ok(loginResDto);
    }
}
