package com.friends.service.impl;

import com.friends.dao.Sms_Info_Dao;
import com.friends.dto.CommonResponse;
import com.friends.dto.Constants;
import com.friends.dto.EmailDto;
import com.friends.dto.EmpStaffInfo;
import com.friends.model.Sms_Info_Entity;
import com.friends.service.SendEmail;
import com.friends.service.SendSMS;
import com.friends.utils.AdapterUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Service
public class SendEmail_Impl implements SendEmail {
    private static final Logger logger = Logger.getLogger(SendEmail_Impl.class.getName());

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Sms_Info_Dao smsInfoDao;

    @Autowired
    private SendSMS sendSMS;

    @Override
    public CommonResponse sendOtpOnEmail(EmailDto emailDto) {
        CommonResponse commonResponse = null;
        String greetingsMsg = "Hello,\n\n";
        try {
            if (emailDto != null && StringUtils.isNotBlank(emailDto.getEmpStaffId()) && StringUtils.isNotBlank(emailDto.getEmailId())) {
                String otpValue = AdapterUtils.generateOtpValue();
                EmpStaffInfo empStaffInfo = sendSMS.getEmpStaffInfoFromDb(emailDto.getEmpStaffId());
                if(empStaffInfo.getErrorCode().equalsIgnoreCase(Constants.status_Success)) {
                    greetingsMsg = "Hello " + empStaffInfo.getFullName() + ",\n\n";
                }
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(emailDto.getEmailId());
                mailMessage.setSubject(Constants.emailSubject);
                mailMessage.setText(greetingsMsg + otpValue + Constants.otpMsg);
                mailSender.send(mailMessage);
                Optional<Sms_Info_Entity> smsInfoEntity = smsInfoDao.findByFldEmpId(emailDto.getEmpStaffId());
                if(smsInfoEntity.isPresent()) {
                    smsInfoDao.updateFldOtpValueByFldEmpId(otpValue, emailDto.getEmpStaffId());
                }else {
                    Sms_Info_Entity smsInfoEntity1 = new Sms_Info_Entity();
                    smsInfoEntity1.setFldEmpId(emailDto.getEmpStaffId());
                    smsInfoEntity1.setFldOtpValue(otpValue);
                    smsInfoDao.save(smsInfoEntity1);
                }
                commonResponse = CommonResponse.builder()
                        .statusCode(Constants.status_Success)
                        .message(Constants.successOTPSent)
                        .build();
            } else {
                commonResponse = CommonResponse.builder()
                        .statusCode(Constants.status_Failure)
                        .message(Constants.emptyEmailId)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            commonResponse = CommonResponse.builder()
                    .statusCode(Constants.status_Failure)
                    .message(Constants.failureOtpSent)
                    .build();
        }

        return commonResponse;
    }
}
