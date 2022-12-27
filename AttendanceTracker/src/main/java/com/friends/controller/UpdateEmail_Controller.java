package com.friends.controller;

import com.friends.dto.UpdateEmailIdReqDto;
import com.friends.dto.UpdateEmailIdResDto;
import com.friends.service.UpdateEmailId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendanceTracking/friends/update/")
public class UpdateEmail_Controller {

    @Autowired
    private UpdateEmailId updateEmailId;

    @PostMapping("/emailIdUpdate")
    public ResponseEntity<UpdateEmailIdResDto> updateNewEmailId(@RequestBody UpdateEmailIdReqDto updateEmailIdReqDto){
        return ResponseEntity.ok(updateEmailId.updateEmailId(updateEmailIdReqDto));
    }
}
