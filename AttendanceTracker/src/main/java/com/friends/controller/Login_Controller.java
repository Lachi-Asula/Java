package com.friends.controller;

import com.friends.dto.*;
import com.friends.service.GetEmpRole;
import com.friends.utils.AdapterUtils;
import com.friends.utils.exception.BadRequestException;
import com.friends.utils.jwt.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@RestController
@RequestMapping("/attendanceTracking/friends/login")
public class Login_Controller {
    private static final Logger logger = Logger.getLogger(Login_Controller.class.getName());

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private GetEmpRole getEmpRole;

    @PostMapping("/authenticateUser")
    public ResponseEntity<GenerateTokenDto> generateToken(@Valid @RequestBody Login_Req_Dto loginReqDto){

        GenerateTokenDto generateTokenDto = null;
        try {
            if(loginReqDto != null && StringUtils.isNotBlank(loginReqDto.getEmp_Id()) && StringUtils.isNotBlank(loginReqDto.getPassword())) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReqDto.getEmp_Id(), loginReqDto.getPassword()));
                String token = jwtUtil.generateToken(loginReqDto.getEmp_Id());
                generateTokenDto = GenerateTokenDto.builder()
                        .token(token)
                        .errorMsg(Constants.status_Success)
                        .build();
            }else {
                generateTokenDto = GenerateTokenDto.builder()
                        .errorCode(Constants.status_Failure)
                        .errorMsg(Constants.emptyLoginCred)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            throw new UsernameNotFoundException("User not Found, Invalid Employee Id or Password");
        }

        return ResponseEntity.ok(generateTokenDto);
    }

    @GetMapping("/getEmpRole")
    public ResponseEntity<Login_Res_Dto> getEmpRole(@RequestParam("StaffOrEmployeeId") String empId){
        Login_Res_Dto loginResDto = null;
        if(StringUtils.isNotBlank(empId)) {
            loginResDto = getEmpRole.getEmpRoleServ(empId);
        }else {
            loginResDto = Login_Res_Dto.builder()
                    .statusCode(Constants.status_Failure)
                    .errorMsg(Constants.emptyLoginCred)
                    .build();
        }
        return ResponseEntity.ok(loginResDto);
    }

    @GetMapping("/getCalenderInfo")
    public ResponseEntity<GetCalenderInfo> getCalenderInfo(){
        GetCalenderInfo getCalenderInfo = GetCalenderInfo.builder()
                .yearInfo(AdapterUtils.getYears())
                .monthInfo(AdapterUtils.getMonths())
                .build();

        return ResponseEntity.ok(getCalenderInfo);
    }
}
