package com.friends.controller;

import com.friends.dto.Constants;
import com.friends.dto.GenerateTokenDto;
import com.friends.dto.Login_Req_Dto;
import com.friends.dto.Login_Res_Dto;
import com.friends.service.GetEmpRole;
import com.friends.utils.jwt.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/getEmpRole")
    public ResponseEntity<Login_Res_Dto> getEmpRole(@Valid @RequestBody Login_Req_Dto loginReqDto){
        Login_Res_Dto loginResDto = null;
        if(loginReqDto != null && StringUtils.isNotBlank(loginReqDto.getEmp_Id())) {
            loginResDto = getEmpRole.getEmpRoleServ(loginReqDto);
        }else {
            loginResDto = Login_Res_Dto.builder()
                    .statusCode(Constants.status_Failure)
                    .errorMsg(Constants.emptyLoginCred)
                    .build();
        }
        return ResponseEntity.ok(loginResDto);
    }
}
