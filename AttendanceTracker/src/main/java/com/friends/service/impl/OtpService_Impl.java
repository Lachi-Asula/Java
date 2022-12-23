package com.friends.service.impl;

import com.friends.dao.Emp_Info_Dao;
import com.friends.dao.OTP_Info_Dao;
import com.friends.dao.Staff_Info_Dao;
import com.friends.dto.*;
import com.friends.model.Emp_Info_Entity;
import com.friends.model.Otp_Info_Entity;
import com.friends.model.Staff_Info_Entity;
import com.friends.service.OTPService;
import com.friends.utils.AdapterUtils;
import com.friends.utils.BeanUtilsDemo;
import com.friends.utils.encryption.EncryptDecryptRSAUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Service
public class OtpService_Impl implements OTPService {

    private static final Logger logger = Logger.getLogger(OtpService_Impl.class.getName());

    @Autowired
    private JavaMailSender mailSender;


    @Autowired
    private OTP_Info_Dao otpInfoDao;

    @Autowired
    private Emp_Info_Dao empInfoDao;

    @Autowired
    private Staff_Info_Dao staffInfoDao;

    @Autowired
    private EncryptDecryptRSAUtil encryptDecryptRSAUtil;

    @Autowired
    private BeanUtilsDemo beanUtils;

    @Override
    public EmpStaffInfo getEmpStaffInfoFromDb(String empId) {
        EmpStaffInfo empStaffInfo = null;
        try {
            if (StringUtils.isNotBlank(empId)) {
                if (empId.startsWith(Constants.idStart)) {
                    Optional<Emp_Info_Entity> empInfoEntity = empInfoDao.findByFldEmpId(empId);
                    if (empInfoEntity.isPresent()) {
                        Emp_Info_Dto empInfoDto = beanUtils.getEmpInfoDto(empInfoEntity.get());
                        empStaffInfo = EmpStaffInfo.builder()
                                .empStaffId(empId)
                                .fullName(empInfoDto.getFldFullName())
                                .phoneNum(empInfoDto.getFldPhoneNum())
                                .emailId(empInfoDto.getFldEmailId())
                                .errorCode(Constants.status_Success)
                                .build();
                    } else {
                        empStaffInfo = EmpStaffInfo.builder()
                                .empStaffId(empId)
                                .errorCode(Constants.status_Failure)
                                .errorMsg(Constants.invalidEmpStaffId)
                                .build();
                    }
                } else {
                    Optional<Staff_Info_Entity> staffInfoEntity = staffInfoDao.findByFldEmpId(empId);
                    if (staffInfoEntity.isPresent()) {
                        Staff_Info_Dto staffInfoDto = beanUtils.getStaffInfoDto(staffInfoEntity.get());
                        empStaffInfo = EmpStaffInfo.builder()
                                .empStaffId(empId)
                                .fullName(staffInfoDto.getFldFullName())
                                .phoneNum(staffInfoDto.getFldPhone())
                                .emailId(staffInfoDto.getFldEmailId())
                                .errorCode(Constants.status_Success)
                                .build();
                    } else {
                        empStaffInfo = EmpStaffInfo.builder()
                                .empStaffId(empId)
                                .errorCode(Constants.status_Failure)
                                .errorMsg(Constants.invalidEmpStaffId)
                                .build();
                    }
                }
            } else {
                empStaffInfo = EmpStaffInfo.builder()
                        .empStaffId(empId)
                        .errorCode(Constants.status_Failure)
                        .errorMsg(Constants.invalidEmpStaffId)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            empStaffInfo = EmpStaffInfo.builder()
                    .empStaffId(empId)
                    .errorCode(Constants.status_Failure)
                    .errorMsg(Constants.saveFailure)
                    .build();
        }
        return empStaffInfo;
    }

    @Override
    public CommonResponse forgotPassword(OTPDto otpDto) {
        CommonResponse commonResponse = null;
        String greetingsMsg = "Hello,\n\n";
        try {
            if (otpDto != null && StringUtils.isNotBlank(otpDto.getEmpStaffId()) && StringUtils.isNotBlank(otpDto.getEmailId())) {
                String otpValue = AdapterUtils.generateOtpValue();
                EmpStaffInfo empStaffInfo = getEmpStaffInfoFromDb(otpDto.getEmpStaffId());
                if(empStaffInfo.getErrorCode().equalsIgnoreCase(Constants.status_Success)) {
                    greetingsMsg = "Dear " + empStaffInfo.getFullName() + ",\n\n";
                }
                StringBuilder emailMsg = new StringBuilder();
                emailMsg.append(greetingsMsg).append(otpValue).append(Constants.otpMsg).append(Constants.emailThanks_Msg);
                sendMail(otpDto.getEmailId(), Constants.emailSubject_ForgotPassword, emailMsg.toString());
                Optional<Otp_Info_Entity> smsInfoEntity = otpInfoDao.findByFldEmpId(otpDto.getEmpStaffId());
                if(smsInfoEntity.isPresent()) {
                    otpInfoDao.updateFldOtpValueByFldEmpId(otpValue, otpDto.getEmpStaffId());
                }else {
                    Otp_Info_Entity smsInfoEntity1 = new Otp_Info_Entity();
                    smsInfoEntity1.setFldEmpId(otpDto.getEmpStaffId());
                    smsInfoEntity1.setFldOtpValue(otpValue);
                    otpInfoDao.save(smsInfoEntity1);
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

    @Override
    public void sendGreetingsToEmail(String emailId, String userId, String userName, String passWord) {
        StringBuilder greetingsMsg = new StringBuilder();
        greetingsMsg.append("Dear ").append(userName +", ").append(Constants.emailReg_Msg).append("\n\nEmployee ID : ").append(userId);
        greetingsMsg.append("\nPassword : ").append(passWord).append(Constants.emailThanks_Msg);
        sendMail(emailId, Constants.emailSubject_Greetings, greetingsMsg.toString());
    }

    @Override
    public CommonResponse updatePassword(OTPDto otpDto) {
        CommonResponse commonResponse = null;
        try {
            if (otpDto != null && StringUtils.isNotBlank(otpDto.getEmpStaffId()) && StringUtils.isNotBlank(otpDto.getPassword())) {
                String emailId;
                String password = otpDto.getPassword();
                EmpStaffInfo empStaffInfo = getEmpStaffInfoFromDb(otpDto.getEmpStaffId());
                if (empStaffInfo.getErrorCode().equalsIgnoreCase(Constants.status_Success)) {
                    otpDto.setPassword(encryptDecryptRSAUtil.encode(otpDto.getPassword()));
                    if (otpDto.getEmpStaffId().startsWith(Constants.idStart)) {
                        empInfoDao.updatePasswordByEmpId(otpDto.getPassword(), otpDto.getEmpStaffId());
                    } else {
                        staffInfoDao.updatePasswordByEmpId(otpDto.getPassword(), otpDto.getEmpStaffId());
                    }
                    emailId = empStaffInfo.getEmailId();
                    StringBuilder emailMsg = new StringBuilder();
                    emailMsg.append("Dear ").append(empStaffInfo.getFullName() + ", ").append(Constants.emailMsg_UpdatePass);
                    emailMsg.append("\n\nEmployee ID : ").append(otpDto.getEmpStaffId()).append("\nPassword : ").append(password).append(Constants.emailThanks_Msg);
                    sendMail(emailId, Constants.emailSubject_UpdatePassword, emailMsg.toString());
                    commonResponse = CommonResponse.builder()
                            .statusCode(Constants.status_Success)
                            .message(Constants.updatePass_Success)
                            .build();
                } else {
                    commonResponse = CommonResponse.builder()
                            .statusCode(Constants.status_Failure)
                            .message(Constants.saveFailure)
                            .build();
                }
            } else {
                commonResponse = CommonResponse.builder()
                        .statusCode(Constants.status_Failure)
                        .message(Constants.updatePass_EmptyPassword)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            commonResponse = CommonResponse.builder()
                    .statusCode(Constants.status_Failure)
                    .message(Constants.saveFailure)
                    .build();
        }
        return commonResponse;
    }

    @Async
    private void sendMail(String emailId, String emailSubject, String emailMessage){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailId);
        mailMessage.setSubject(emailSubject);
        mailMessage.setText(emailMessage);
        mailSender.send(mailMessage);
    }

    @Override
    public CommonResponse verifyOtp(OTPDto otpDto) {
        CommonResponse commonResponse = null;
        try{
            if(otpDto != null && StringUtils.isNotBlank(otpDto.getEmpStaffId()) && StringUtils.isNotBlank(otpDto.getOtpValue())){
                if(StringUtils.isNumeric(otpDto.getOtpValue())){
                    Optional<String> otpValueFromDBOpt = otpInfoDao.getOtpValueByEmpId(otpDto.getEmpStaffId());
                    if(otpValueFromDBOpt.isPresent()){
                        String otpValueFromDB = otpValueFromDBOpt.get();
                        if(otpValueFromDB.equalsIgnoreCase(otpDto.getOtpValue())){
                            commonResponse = CommonResponse.builder()
                                    .statusCode(Constants.status_Success)
                                    .message(Constants.validOtp)
                                    .build();
                        }else {
                            commonResponse = CommonResponse.builder()
                                    .statusCode(Constants.status_Failure)
                                    .message(Constants.invalidOtp)
                                    .build();
                        }
                    }else {
                        commonResponse = CommonResponse.builder()
                                .statusCode(Constants.status_Failure)
                                .message(Constants.invalidEmpStaffId)
                                .build();
                    }
                }else {
                    commonResponse = CommonResponse.builder()
                            .statusCode(Constants.status_Failure)
                            .message(Constants.invalidFormatOtpValue)
                            .build();
                }
            }else {
                commonResponse = CommonResponse.builder()
                        .statusCode(Constants.status_Failure)
                        .message(Constants.emptyVerifyOtp)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            commonResponse = CommonResponse.builder()
                    .statusCode(Constants.status_Failure)
                    .message(Constants.saveFailure)
                    .build();
        }

        return commonResponse;
    }
}
