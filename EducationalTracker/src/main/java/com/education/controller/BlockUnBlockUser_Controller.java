package com.education.controller;

import com.education.dto.CommonResponseDto;
import com.education.dto.UserIdReqDto;
import com.education.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educational/friends/userStatus")
public class BlockUnBlockUser_Controller {

    @Autowired
    private UserInfo userInfo;

    @PostMapping("/blockUser")
    public ResponseEntity<CommonResponseDto> blockUser(@RequestBody UserIdReqDto userIdReqDto){
        return ResponseEntity.ok(userInfo.blockUser(userIdReqDto));
    }

    @PostMapping("/unBlockUser")
    public ResponseEntity<CommonResponseDto> unBlockUser(@RequestBody UserIdReqDto userIdReqDto){
        return ResponseEntity.ok(userInfo.unBlockUser(userIdReqDto));
    }
}
