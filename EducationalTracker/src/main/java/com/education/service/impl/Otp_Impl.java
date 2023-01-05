package com.education.service.impl;

import com.education.dao.OtpDao;
import com.education.dao.StaffRegDao;
import com.education.dto.CommonResponseDto;
import com.education.dto.Constants;
import com.education.dto.OtpReqDto;
import com.education.dto.UpdatePasswordReqDto;
import com.education.model.Otp_Entity;
import com.education.model.StaffRegistration_Entity;
import com.education.service.Otp;
import com.education.utils.RSA.EncryptDecryptRSAUtil;
import com.education.utils.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.education.utils.SpringUtils.getStackTrace;

@Service
public class Otp_Impl implements Otp {
    private static final Logger logger = Logger.getLogger(Otp_Impl.class.getName());

    @Autowired
    private OtpDao otpDao;

    @Autowired
    private StaffRegDao staffRegDao;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EncryptDecryptRSAUtil encryptDecryptRSAUtil;

    @Override
    public CommonResponseDto sendOtpOnEmail(OtpReqDto otpReqDto) {
        CommonResponseDto commonResponseDto = null;
        try{
            if(otpReqDto != null && StringUtils.isNotBlank(otpReqDto.getUserId()) && StringUtils.isNotBlank(otpReqDto.getEmailId())){
                Optional<StaffRegistration_Entity> staffRegistration = staffRegDao.findByFldStaffIdAndFldEmailId(otpReqDto.getUserId(), otpReqDto.getEmailId());
                if(staffRegistration.isPresent()){
                    StaffRegistration_Entity staffInfo = staffRegistration.get();
                    String otpValue = SpringUtils.generateOtpValue();
                    otpReqDto.setOtpValue(otpValue);
                    String emailSub = Constants.emailSub_ForgotPassword;
                    StringBuilder emailMsg = new StringBuilder();
                    emailMsg.append(Constants.dear).append(staffInfo.getFldFullName()).append(",").append(Constants.newLineDouble)
                            .append(otpValue).append(Constants.emailMsg_SendOTP).append(Constants.newLineDouble).append(Constants.email_Regards);
                    sendMail(otpReqDto.getEmailId(), emailSub, emailMsg.toString());
                    saveOrUpdateOtpData(otpReqDto);
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Success)
                            .successMsg(Constants.sendOtp_Msg + otpReqDto.getEmailId())
                            .build();
                }else {
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Failure)
                            .errorMsg(Constants.userIdEmailId_Mismatch)
                            .build();
                }
            }else {
                commonResponseDto = CommonResponseDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.userIdAndEmailId_Empty_Error)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return commonResponseDto;
    }

    @Override
    public void saveOrUpdateOtpData(OtpReqDto otpReqDto) {
        try{
            if(otpReqDto != null && StringUtils.isNotBlank(otpReqDto.getUserId()) && StringUtils.isNotBlank(otpReqDto.getOtpValue())){
                Optional<Otp_Entity> otpEntityOptional = otpDao.findByFldUserId(otpReqDto.getUserId());
                if(otpEntityOptional.isPresent()){
                    otpDao.updateOtpValueByUserId(otpReqDto.getUserId(), otpReqDto.getOtpValue());
                }else {
                    Otp_Entity otpEntity = new Otp_Entity();
                    otpEntity.setFldId(otpDao.getOtpIdVal());
                    otpEntity.setFldUserId(otpReqDto.getUserId());
                    otpEntity.setFldOtpValue(otpReqDto.getOtpValue());
                    otpDao.save(otpEntity);
                }
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }
    }

    @Override
    public CommonResponseDto verifyOtp(OtpReqDto otpReqDto) {
        CommonResponseDto commonResponseDto = null;
        try {
            if (otpReqDto != null && StringUtils.isNotBlank(otpReqDto.getUserId()) && StringUtils.isNotBlank(otpReqDto.getOtpValue())) {
                Optional<Otp_Entity> otpEntityOptional = otpDao.findByFldUserIdAndFldOtpValue(otpReqDto.getUserId(), otpReqDto.getOtpValue());
                if(otpEntityOptional.isPresent()){
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Success)
                            .successMsg(Constants.OTP_VALID)
                            .build();
                }else {
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Failure)
                            .errorMsg(Constants.OTP_INVALID)
                            .build();
                }
            } else {
                commonResponseDto = CommonResponseDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.userIdAndOtpValue_Empty_Error)
                        .build();
            }
        } catch (Exception e) {

            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return commonResponseDto;
    }

    @Override
    public CommonResponseDto updatePassword(UpdatePasswordReqDto updatePasswordReqDto) {
        CommonResponseDto commonResponseDto = null;
        try {
            if(updatePasswordReqDto != null && StringUtils.isNotBlank(updatePasswordReqDto.getUserId()) && StringUtils.isNotBlank(updatePasswordReqDto.getNewPassword())){
                Optional<StaffRegistration_Entity> staffRegistration = staffRegDao.findByFldStaffId(updatePasswordReqDto.getUserId());
                if(staffRegistration.isPresent()) {
                    String password = encryptDecryptRSAUtil.encode(updatePasswordReqDto.getNewPassword());
                    staffRegDao.updatePasswordByUserId(updatePasswordReqDto.getUserId(), password);
                    String emailSub = Constants.emailSub_UpdatePassword;
                    StringBuilder emailMsg = new StringBuilder();
                    emailMsg.append(Constants.dear).append(staffRegistration.get().getFldFullName()).append(",").append(Constants.newLineDouble)
                            .append(Constants.emailMsg_UpdatePass).append(Constants.newLineDouble).append(Constants.updatePass_UserId).append(updatePasswordReqDto.getUserId()).append(Constants.newLineSingle)
                            .append(Constants.updatePass_Password).append(updatePasswordReqDto.getNewPassword()).append(Constants.newLineDouble).append(Constants.email_Regards);
                    sendMail(staffRegistration.get().getFldEmailId(), emailSub, emailMsg.toString());
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Success)
                            .successMsg(Constants.updatePass_Success)
                            .build();
                }else {
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Failure)
                            .errorMsg(Constants.connection_Error)
                            .build();
                }
            }else {
                commonResponseDto = CommonResponseDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.userNameAndPassword_Empty_Error)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return commonResponseDto;
    }

    @Async
    @Override
    public void sendMail(String emailId, String emailSubject, String emailMessage){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailId);
        mailMessage.setSubject(emailSubject);
        mailMessage.setText(emailMessage);
        mailSender.send(mailMessage);
    }
}
