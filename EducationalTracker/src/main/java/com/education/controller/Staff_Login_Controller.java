package com.education.controller;

import com.education.dto.Constants;
import com.education.dto.GenerateTokenReqDto;
import com.education.dto.GenerateTokenResDto;
import com.education.utils.jwt.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.education.utils.SpringUtils.getStackTrace;

@RestController
@RequestMapping("/educational/friends/login")
public class Staff_Login_Controller {
    private static final Logger logger = Logger.getLogger(Staff_Login_Controller.class.getName());

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticateUser")
    public ResponseEntity<GenerateTokenResDto> authenticateUser(@RequestBody GenerateTokenReqDto generateTokenReqDto){
        GenerateTokenResDto generateTokenResDto = null;
        try{
            if(generateTokenReqDto != null && StringUtils.isNotBlank(generateTokenReqDto.getUserName()) && StringUtils.isNotBlank(generateTokenReqDto.getPassword())){
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(generateTokenReqDto.getUserName(), generateTokenReqDto.getPassword()));
                String token = jwtUtil.generateToken(generateTokenReqDto.getUserName());
                generateTokenResDto = GenerateTokenResDto.builder()
                        .statusCode(Constants.statusCode_Success)
                        .token(token)
                        .build();
            }else {
                generateTokenResDto = GenerateTokenResDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.userNameAndPassword_Empty_Error)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            throw new UsernameNotFoundException("User not Found, Invalid Employee Id or Password");
        }

        return ResponseEntity.ok(generateTokenResDto);
    }

}
