package com.friends.controller;

import com.friends.dto.CommonResponse;
import com.friends.dto.Constants;
import com.friends.dto.EmpStaffInfo;
import com.friends.dto.SMSDto;
import com.friends.service.SendSMS;
import com.friends.utils.AdapterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@RestController
@RequestMapping("/attendanceTracking/friends/sms")
public class SMSController {

    private static final Logger logger = Logger.getLogger(SMSController.class.getName());

    @Autowired
    private SendSMS sendSMS;

    @Autowired
    private SimpMessagingTemplate webSocket;

    @Value("${topic_Destination}")
    private String TOPIC_DESTINATION;

    @GetMapping("/getEmpStaffInfo")
    public ResponseEntity<EmpStaffInfo> getEmpOrStaffInfo(@RequestParam("EmpStaffId") String empStaffId){
        return ResponseEntity.ok(sendSMS.getEmpStaffInfoFromDb(empStaffId));
    }

    @PostMapping("/sendOtpOnMobile")
    public ResponseEntity<CommonResponse> sendOtpOnMobile(@RequestBody SMSDto smsDto){
        CommonResponse commonResponse = null;
        try {
            commonResponse = sendSMS.sendSMSOnMobile(smsDto);
        }catch (Exception e){
            webSocket.convertAndSend(TOPIC_DESTINATION, AdapterUtils.getTimeStamp() + ": Error sending the SMS : " + e.getMessage());
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        webSocket.convertAndSend(TOPIC_DESTINATION, AdapterUtils.getTimeStamp() + ": SMS has been sent! : " + smsDto.getMobileNum());

        return ResponseEntity.ok(commonResponse);
    }

    @PostMapping("/verifyOtpOnMobile")
    public ResponseEntity<CommonResponse> verifyOTPOnMobile(@RequestBody SMSDto smsDto){

        return ResponseEntity.ok(sendSMS.verifyOtpOnMobile(smsDto));
    }
}
