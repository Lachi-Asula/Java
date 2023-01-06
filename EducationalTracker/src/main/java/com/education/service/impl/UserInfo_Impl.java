package com.education.service.impl;

import com.education.dao.*;
import com.education.dto.*;
import com.education.model.*;
import com.education.service.UserInfo;
import com.education.utils.RSA.EncryptDecryptRSAUtil;
import com.education.utils.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.education.utils.SpringUtils.getStackTrace;

@Service
public class UserInfo_Impl implements UserInfo {
    private static final Logger logger = Logger.getLogger(UserInfo_Impl.class.getName());

    @Autowired
    private StaffRegDao staffRegDao;

    @Autowired
    private StudentRegDao studentRegDao;

    @Autowired
    private UserStatusDao userStatusDao;

    @Value("${user.coolingPeriod}")
    private int coolingPeriodTime;

    @Autowired
    private EncryptDecryptRSAUtil encryptDecryptRSAUtil;

    @Autowired
    private AllStandardsDao allStandardsDao;

    @Autowired
    private AllSubjectsDao allSubjectsDao;

    @Override
    public UserIdResDto getUserInfo(UserIdReqDto userIdReqDto) {
        UserIdResDto userIdResDto = null;
        try {
            if(userIdReqDto != null && StringUtils.isNotBlank(userIdReqDto.getUserId())){
                if(userIdReqDto.getUserId().startsWith(Constants.IDSTART_MNG)){
                    Optional<StaffRegistration_Entity> staffRegistration = staffRegDao.findByFldStaffId(userIdReqDto.getUserId());
                    if(staffRegistration.isPresent()){
                        StaffRegistration_Entity staffInfo = staffRegistration.get();
                        List<String> allSubjects = allSubjectsDao.getAllSubjects();
                        List<String> allStandards = allStandardsDao.getAllStandards();
                        if(staffInfo.getFldSpecialization().equalsIgnoreCase(Constants.role_LECTURER)){
                            allSubjects = getAllSubjectsForLecturer(staffInfo.getFldSubject());
                            allStandards = getAllStandardsForLecturer(staffInfo.getFldStandard());
                        }
                        userIdResDto = UserIdResDto.builder()
                                .statusCode(Constants.statusCode_Success)
                                .userId(staffInfo.getFldStaffId())
                                .fullName(staffInfo.getFldFullName())
                                .role(staffInfo.getFldSpecialization())
                                .emailId(staffInfo.getFldEmailId())
                                .dateOfBirth(staffInfo.getFldDateOfBirth())
                                .standards(allStandards)
                                .subjects(allSubjects)
                                .build();
                    }else {
                        userIdResDto = UserIdResDto.builder()
                                .statusCode(Constants.statusCode_Failure)
                                .errorMsg(Constants.userId_Invalid)
                                .build();
                    }
                }else {
                    Optional<StudentRegistration_Entity> studentRegistration = studentRegDao.findByFldStudentId(userIdReqDto.getUserId());
                    if(studentRegistration.isPresent()){
                        StudentRegistration_Entity studentInfo = studentRegistration.get();
                        userIdResDto = UserIdResDto.builder()
                                .statusCode(Constants.statusCode_Success)
                                .userId(studentInfo.getFldStudentId())
                                .fullName(studentInfo.getFldFullName())
                                .role(Constants.role_STUDENT)
                                .dateOfBirth(studentInfo.getFldDateOfBirth())
                                .build();
                    }else {
                        userIdResDto = UserIdResDto.builder()
                                .statusCode(Constants.statusCode_Failure)
                                .errorMsg(Constants.userId_Invalid)
                                .build();
                    }
                }
            }else {
                userIdResDto = UserIdResDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.userId_Empty_Error)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return userIdResDto;
    }

    @Override
    public CommonResponseDto getUserStatus(GenerateTokenReqDto generateTokenReqDto) {
        CommonResponseDto commonResponseDto = null;
        try {
            if(generateTokenReqDto != null && StringUtils.isNotBlank(generateTokenReqDto.getUserName()) && StringUtils.isNotBlank(generateTokenReqDto.getPassword())){
                Optional<StaffRegistration_Entity> staffRegistration = staffRegDao.findByFldStaffId(generateTokenReqDto.getUserName());
                if(staffRegistration.isPresent()){
                    StaffRegistration_Entity staffInfo = staffRegistration.get();
                    String password = encryptDecryptRSAUtil.decode(staffInfo.getFldPassword());
                    Optional<UserStatus_Entity> userStatusEntity = userStatusDao.findByFldUserId(generateTokenReqDto.getUserName());
                    if(userStatusEntity.isPresent()){
                        UserStatus_Entity userStatusInfo = userStatusEntity.get();
                        if (userStatusEntity.get().getFldBlockedTime() != null) {
                            if (userStatusInfo.getFldPermCount() >= Constants.permCount_CoolingPeriod) {
                                commonResponseDto = CommonResponseDto.builder()
                                        .statusCode(Constants.statusCode_Failure)
                                        .errorMsg(Constants.permanent_Block_Msg)
                                        .build();
                                return commonResponseDto;
                            } else if (userStatusInfo.getFldTempCount() >= Constants.tempCount_CoolingPeriod) {
                                Date blockedTimeFromDb = userStatusInfo.getFldBlockedTime();
                                int timeLeft = SpringUtils.getMinutesDiffFromDates(new Date(), blockedTimeFromDb);
                                if(timeLeft < coolingPeriodTime) {
                                    commonResponseDto = CommonResponseDto.builder()
                                            .statusCode(Constants.statusCode_Failure)
                                            .errorMsg(Constants.coolingPeriod_Msg + (coolingPeriodTime - timeLeft) + " min")
                                            .build();
                                    return commonResponseDto;
                                }else {
                                    if(password.equalsIgnoreCase(generateTokenReqDto.getPassword())){
                                        userStatusDao.deleteById(userStatusInfo.getFldId());
                                        commonResponseDto = CommonResponseDto.builder()
                                                .statusCode(Constants.statusCode_Success)
                                                .successMsg(Constants.eligible_Login_Success)
                                                .build();
                                        return commonResponseDto;
                                    }else {
                                        Date blockedTime = new Date();
                                        userStatusDao.updatePermCountAndTempCountByUserId(blockedTime,userStatusInfo.getFldPermCount() + 1, userStatusInfo.getFldTempCount() + 1, userStatusInfo.getFldUserId());
                                        timeLeft = SpringUtils.getMinutesDiffFromDates(new Date(), blockedTime);
                                        StringBuilder message = new StringBuilder();
                                        if((userStatusInfo.getFldPermCount() + 1) == Constants.permCount_CoolingPeriod){
                                            message.append(Constants.permanent_Block_Msg);
                                        }else {
                                            message.append(Constants.invalidPassword_Count).append(Constants.temporary_Block_Msg).append(coolingPeriodTime - timeLeft).append(" min.");
                                        }
                                        commonResponseDto = CommonResponseDto.builder()
                                                .statusCode(Constants.statusCode_Failure)
                                                .errorMsg(message.toString())
                                                .build();
                                        return commonResponseDto;
                                    }
                                }
                            }
                        }else {
                            if(password.equalsIgnoreCase(generateTokenReqDto.getPassword())){
                                userStatusDao.deleteById(userStatusInfo.getFldId());
                                commonResponseDto = CommonResponseDto.builder()
                                        .statusCode(Constants.statusCode_Success)
                                        .successMsg(Constants.eligible_Login_Success)
                                        .build();
                                return commonResponseDto;
                            }else {
                                int tempCount = userStatusInfo.getFldTempCount();
                                StringBuilder message = new StringBuilder();
                                message.append(Constants.invalidPassword_Count).append(tempCount + 1).append(Constants.outOf3);
                                if((tempCount + 1) == Constants.tempCount_CoolingPeriod){
                                    Date blockedTime = new Date();
                                    userStatusDao.updateBlockedTimeByUserId(blockedTime, generateTokenReqDto.getUserName());
                                    userStatusDao.updateTempCountByUserId((tempCount + 1), userStatusInfo.getFldUserId());
                                    int timeLeft = SpringUtils.getMinutesDiffFromDates(new Date(), blockedTime);
                                    message.append(Constants.temporary_Block_Msg).append(coolingPeriodTime - timeLeft).append(" min");
                                    commonResponseDto = CommonResponseDto.builder()
                                            .statusCode(Constants.statusCode_Failure)
                                            .errorMsg(message.toString())
                                            .build();
                                    return commonResponseDto;
                                }else {
                                    userStatusDao.updateTempCountByUserId((tempCount + 1), userStatusInfo.getFldUserId());
                                    commonResponseDto = CommonResponseDto.builder()
                                            .statusCode(Constants.statusCode_Failure)
                                            .errorMsg(message.toString())
                                            .build();
                                    return commonResponseDto;
                                }
                            }
                        }
                    }else {
                        if(!password.equalsIgnoreCase(generateTokenReqDto.getPassword())){
                            UserStatus_Entity userStatusEntity1 = new UserStatus_Entity();
                            userStatusEntity1.setFldUserId(generateTokenReqDto.getUserName());
                            userStatusEntity1.setFldBlockedTime(null);
                            userStatusEntity1.setFldTempCount(1);
                            userStatusEntity1.setFldPermCount(0);
                            userStatusDao.save(userStatusEntity1);
                            StringBuilder message = new StringBuilder();
                            message.append(Constants.invalidPassword_Count).append(1).append(Constants.outOf3);
                            commonResponseDto = CommonResponseDto.builder()
                                    .statusCode(Constants.statusCode_Failure)
                                    .successMsg(message.toString())
                                    .build();
                            return commonResponseDto;
                        }else {
                            commonResponseDto = CommonResponseDto.builder()
                                    .statusCode(Constants.statusCode_Success)
                                    .successMsg(Constants.eligible_Login_Success)
                                    .build();
                            return commonResponseDto;
                        }

                    }
                }else {
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Failure)
                            .errorMsg(Constants.userId_Invalid)
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

    @Override
    public CommonResponseDto blockUser(UserIdReqDto userIdReqDto) {
        CommonResponseDto commonResponseDto = null;
        try {
            if(userIdReqDto != null && StringUtils.isNotBlank(userIdReqDto.getUserId())) {
                Optional<StaffRegistration_Entity> staffRegistration = staffRegDao.findByFldStaffId(userIdReqDto.getUserId());
                if (staffRegistration.isPresent()) {
                    Optional<UserStatus_Entity> userStatusEntity = userStatusDao.findByFldUserId(userIdReqDto.getUserId());
                    if (userStatusEntity.isPresent()) {
                        UserStatus_Entity userStatus = userStatusEntity.get();
                        userStatus.setFldBlockedTime(new Date());
                        userStatus.setFldTempCount(Constants.tempCount_CoolingPeriod);
                        userStatus.setFldPermCount(Constants.permCount_CoolingPeriod);
                        userStatusDao.save(userStatus);
                    } else {
                        UserStatus_Entity userStatus = new UserStatus_Entity();
                        userStatus.setFldUserId(userIdReqDto.getUserId());
                        userStatus.setFldBlockedTime(new Date());
                        userStatus.setFldTempCount(Constants.tempCount_CoolingPeriod);
                        userStatus.setFldPermCount(Constants.permCount_CoolingPeriod);
                        userStatusDao.save(userStatus);
                    }
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Success)
                            .userId(userIdReqDto.getUserId())
                            .timeStamp(SpringUtils.getTimeStamp())
                            .successMsg(Constants.blockUser_Msg)
                            .build();
                }else {
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Failure)
                            .errorMsg(Constants.userId_Invalid)
                            .build();
                }
            } else {
                commonResponseDto = CommonResponseDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.userId_Empty_Error)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }

        return commonResponseDto;
    }

    @Override
    public CommonResponseDto unBlockUser(UserIdReqDto userIdReqDto) {
        CommonResponseDto commonResponseDto = null;
        try {
            if(userIdReqDto != null && StringUtils.isNotBlank(userIdReqDto.getUserId())) {
                Optional<StaffRegistration_Entity> staffRegistration = staffRegDao.findByFldStaffId(userIdReqDto.getUserId());
                if (staffRegistration.isPresent()) {
                    Optional<UserStatus_Entity> userStatusEntity = userStatusDao.findByFldUserId(userIdReqDto.getUserId());
                    if (userStatusEntity.isPresent()) {
                        UserStatus_Entity userStatus = userStatusEntity.get();
                        userStatusDao.deleteById(userStatus.getFldId());
                        commonResponseDto = CommonResponseDto.builder()
                                .statusCode(Constants.statusCode_Success)
                                .userId(userIdReqDto.getUserId())
                                .timeStamp(SpringUtils.getTimeStamp())
                                .successMsg(Constants.unBlockUser_Msg)
                                .build();
                    } else {
                        commonResponseDto = CommonResponseDto.builder()
                                .statusCode(Constants.statusCode_Success)
                                .userId(userIdReqDto.getUserId())
                                .timeStamp(SpringUtils.getTimeStamp())
                                .successMsg(Constants.unBlockUserAlready_Msg)
                                .build();
                    }

                }else {
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Failure)
                            .errorMsg(Constants.userId_Invalid)
                            .build();
                }
            } else {
                commonResponseDto = CommonResponseDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.userId_Empty_Error)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }

        return commonResponseDto;
    }

    private List<String> getAllStandardsForLecturer(List<Standard_Entity> standardEntities){
        List<String> allStandards = new ArrayList<>();
        for(Standard_Entity standardEntity : standardEntities){
            allStandards.add(standardEntity.getFldStandard());
        }
        return allStandards;
    }

    private List<String> getAllSubjectsForLecturer(List<Subject_Entity> subjectEntities){
        List<String> allSubjects = new ArrayList<>();
        for(Subject_Entity subjectEntity : subjectEntities){
            allSubjects.add(subjectEntity.getFldSubject());
        }
        return allSubjects;
    }

}
