package com.friends.service.impl;

import com.friends.dao.Emp_Info_Dao;
import com.friends.dao.Sms_Info_Dao;
import com.friends.dao.Staff_Info_Dao;
import com.friends.dto.*;
import com.friends.model.Emp_Info_Entity;
import com.friends.model.Sms_Info_Entity;
import com.friends.model.Staff_Info_Entity;
import com.friends.service.SendSMS;
import com.friends.utils.AdapterUtils;
import com.friends.utils.BeanUtilsDemo;
import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Service
public class SendSMS_Impl implements SendSMS {

    private static final Logger logger = Logger.getLogger(SendSMS_Impl.class.getName());

    @Value("${account_Sid}")
    private String ACCOUNT_SID;

    @Value("${auth_Token}")
    private String AUTH_TOKEN;

    @Value("${from_Number}")
    private String FROM_NUMBER;

    @Autowired
    private Sms_Info_Dao smsInfoDao;

    @Autowired
    private Emp_Info_Dao empInfoDao;

    @Autowired
    private Staff_Info_Dao staffInfoDao;

    @Autowired
    private BeanUtilsDemo beanUtils;


    @Override
    public EmpStaffInfo getEmpStaffInfoFromDb(String empId) {
        EmpStaffInfo empStaffInfo = null;
        if(StringUtils.isNotBlank(empId)){
            if(empId.startsWith(Constants.idStart)){
                Optional<Emp_Info_Entity> empInfoEntity = empInfoDao.findByFldEmpId(empId);
                if(empInfoEntity.isPresent()){
                    Emp_Info_Dto empInfoDto = beanUtils.getEmpInfoDto(empInfoEntity.get());
                    empStaffInfo = EmpStaffInfo.builder()
                            .empStaffId(empId)
                            .fullName(empInfoDto.getFldFullName())
                            .phoneNum(empInfoDto.getFldPhoneNum())
                            .emailId(empInfoDto.getFldEmailId())
                            .errorCode(Constants.status_Success)
                            .build();
                }else {
                    empStaffInfo = EmpStaffInfo.builder()
                            .empStaffId(empId)
                            .errorCode(Constants.status_Failure)
                            .errorMsg(Constants.invalidEmpStaffId)
                            .build();
                }
            }else{
                Optional<Staff_Info_Entity> staffInfoEntity = staffInfoDao.findByFldEmpId(empId);
                if (staffInfoEntity.isPresent()){
                    Staff_Info_Dto staffInfoDto = beanUtils.getStaffInfoDto(staffInfoEntity.get());
                    empStaffInfo = EmpStaffInfo.builder()
                            .empStaffId(empId)
                            .fullName(staffInfoDto.getFldFullName())
                            .phoneNum(staffInfoDto.getFldPhone())
                            .emailId(staffInfoDto.getFldEmailId())
                            .errorCode(Constants.status_Success)
                            .build();
                }else {
                    empStaffInfo = EmpStaffInfo.builder()
                            .empStaffId(empId)
                            .errorCode(Constants.status_Failure)
                            .errorMsg(Constants.invalidEmpStaffId)
                            .build();
                }
            }
        }else {
            empStaffInfo = EmpStaffInfo.builder()
                    .empStaffId(empId)
                    .errorCode(Constants.status_Failure)
                    .errorMsg(Constants.invalidEmpStaffId)
                    .build();
        }
        return empStaffInfo;
    }

    @Override
    public CommonResponse sendSMSOnMobile(SMSDto smsDto) {
        CommonResponse commonResponse = null;
        try {
            if(smsDto != null && StringUtils.isNotBlank(smsDto.getMobileNum()) && StringUtils.isNumeric(smsDto.getMobileNum())) {
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                String otpValue = AdapterUtils.generateOtpValue();
                smsDto.setMessage(otpValue + Constants.otpMsg);
                smsDto.setMobileNum(Constants.countryCode_IND + smsDto.getMobileNum());
                Message message = Message.creator(new PhoneNumber(smsDto.getMobileNum()), new PhoneNumber(FROM_NUMBER), smsDto.getMessage()).create();
                if(message != null && message.getErrorCode() == null) {
                    Optional<Sms_Info_Entity> smsInfoEntity = smsInfoDao.findByFldEmpId(smsDto.getEmpStaffId());
                    if(smsInfoEntity.isPresent()) {
                        smsInfoDao.updateFldOtpValueByFldEmpId(otpValue, smsDto.getEmpStaffId());
                    }else {
                        Sms_Info_Entity smsInfoEntity1 = new Sms_Info_Entity();
                        smsInfoEntity1.setFldEmpId(smsDto.getEmpStaffId());
                        smsInfoEntity1.setFldOtpValue(otpValue);
                        smsInfoDao.save(smsInfoEntity1);
                    }
                    commonResponse = CommonResponse.builder()
                            .statusCode(Constants.status_Success)
                            .message(Constants.successOTPSent)
                            .build();

                }else {
                    commonResponse = CommonResponse.builder()
                            .statusCode(Constants.status_Failure)
                            .message(Constants.failureOtpSent)
                            .build();
                }
            }else {
                commonResponse = CommonResponse.builder()
                        .statusCode(Constants.status_Failure)
                        .message(Constants.emptyMobileNumberMsg)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            commonResponse = CommonResponse.builder()
                    .statusCode(Constants.status_Failure)
                    .message(Constants.unverifiedNumber)
                    .build();
        }finally {
            Twilio.destroy();
        }

        return commonResponse;
    }

    @Override
    public CommonResponse verifyOtp(SMSDto smsDto) {
        CommonResponse commonResponse = null;
        if(smsDto != null && StringUtils.isNotBlank(smsDto.getEmpStaffId()) && StringUtils.isNotBlank(smsDto.getOtpValue())){
            if(StringUtils.isNumeric(smsDto.getOtpValue())){
                Optional<String> otpValueFromDBOpt = smsInfoDao.getOtpValueByEmpId(smsDto.getEmpStaffId());
                if(otpValueFromDBOpt.isPresent()){
                    String otpValueFromDB = otpValueFromDBOpt.get();
                    if(otpValueFromDB.equalsIgnoreCase(smsDto.getOtpValue())){
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

        return commonResponse;
    }
}
