package com.education.service.impl;

import com.education.dao.*;
import com.education.dto.*;
import com.education.model.*;
import com.education.service.Otp;
import com.education.service.StaffRegistration;
import com.education.service.StudentRegistration;
import com.education.utils.BeanUtilsDemo;
import com.education.utils.RSA.EncryptDecryptRSAUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.education.utils.SpringUtils.getStackTrace;

@Service
public class Registration implements StudentRegistration, StaffRegistration {
    private static final Logger logger = Logger.getLogger(Registration.class.getName());

    @Autowired
    private StudentRegDao studentRegDao;

    @Autowired
    private StaffRegDao staffRegDao;

    @Autowired
    private BeanUtilsDemo beanUtils;

    @Autowired
    private StandardDao standardDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private EncryptDecryptRSAUtil encryptDecryptRSAUtil;

    @Autowired
    private AllStandardsDao allStandardsDao;

    @Autowired
    private Otp otp;

    @Override
    public CommonResponseDto registerStudent(StudentRegistration_Dto registrationDto) {
        CommonResponseDto commonResponseDto = null;
        try {
            if (registrationDto != null && StringUtils.isNotBlank(registrationDto.getFldFullName()) && StringUtils.isNotBlank(registrationDto.getFldFatherName())
                    && StringUtils.isNotBlank(registrationDto.getFldMotherName())) {
                Optional<StudentRegistration_Entity> studentRegistration = studentRegDao.findByFldFullNameAndFldFatherNameAndFldMotherName(registrationDto.getFldFullName(), registrationDto.getFldFatherName(), registrationDto.getFldMotherName());
                if(!studentRegistration.isPresent()){
                    StringBuilder studentId = new StringBuilder();
                    studentId.append(Constants.IDSTART_YES).append(studentRegDao.getStudentIdVal());
                    registrationDto.setFldStudentId(studentId.toString());
                    StudentRegistration_Entity studentRegistrationEntity = beanUtils.getStudentRegEntity(registrationDto);
                    studentRegDao.save(studentRegistrationEntity);
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Success)
                            .successMsg(Constants.registrationCompleted_Success + studentId)
                            .userId(studentId.toString())
                            .build();
                }else {
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Success)
                            .errorMsg(Constants.userExist_Already + studentRegistration.get().getFldStudentId())
                            .userId(studentRegistration.get().getFldStudentId())
                            .build();
                }
            }else {
                commonResponseDto = CommonResponseDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.fullNameFatherMotherName_Empty_Error)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            commonResponseDto = CommonResponseDto.builder()
                    .statusCode(Constants.statusCode_Failure)
                    .errorMsg(Constants.connection_Error)
                    .build();
        }
        return commonResponseDto;
    }

    @Override
    public StudentInfoResDto getStudentInfoBasedOnUserId(UserIdReqDto userIdReqDto) {
        StudentInfoResDto studentInfoResDto = null;
        if(userIdReqDto != null && StringUtils.isNotBlank(userIdReqDto.getUserId())){
            Optional<StudentRegistration_Entity> studentInfoOptional = studentRegDao.findByFldStudentId(userIdReqDto.getUserId());
            System.out.println(userIdReqDto.getUserId());
            if(studentInfoOptional.isPresent()){
                StudentRegistration_Dto studentRegistrationDto = beanUtils.getStudentRegDto(studentInfoOptional.get());
                studentInfoResDto = StudentInfoResDto.builder()
                        .statusCode(Constants.statusCode_Success)
                        .userId(studentRegistrationDto.getFldStudentId())
                        .fullName(studentRegistrationDto.getFldFullName())
                        .dateOfBirth(studentRegistrationDto.getFldDateOfBirth())
                        .motherName(studentRegistrationDto.getFldMotherName())
                        .fatherName(studentRegistrationDto.getFldFatherName())
                        .phoneNum(studentRegistrationDto.getFldPhone())
                        .standard(studentRegistrationDto.getFldStandard())
                        .gender(studentRegistrationDto.getFldGender())
                        .totalAmount(studentRegistrationDto.getFldTotalAmount())
                        .amountPaid(studentRegistrationDto.getFldAmountPaid())
                        .amountDue(studentRegistrationDto.getFldAmountDue())
                        .build();
            }else{
                studentInfoResDto = StudentInfoResDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.userNotFound)
                        .build();
            }
        }else {
            studentInfoResDto = StudentInfoResDto.builder()
                    .statusCode(Constants.statusCode_Failure)
                    .errorMsg(Constants.userId_Empty_Error)
                    .build();
        }
        return studentInfoResDto;
    }

    @Override
    public AllStudentsInfoBasedOnStandard_ResDto getAllStudentsBasedOnStandard(String standard) {
        AllStudentsInfoBasedOnStandard_ResDto studentRegistrationDtos = null;
        try {
            if(StringUtils.isNotBlank(standard)){
                Optional<AllStandards_Entity> allStandardsEntity = allStandardsDao.findByFldStandard(standard);
                if(allStandardsEntity.isPresent()) {
                    List<StudentRegistration_Entity> studentRegistrationEntities = studentRegDao.findByFldStandard(standard);
                    List<StudentRegistration_Dto> registrationDtos = beanUtils.getAllStudentsDtos(studentRegistrationEntities);
                    studentRegistrationDtos = AllStudentsInfoBasedOnStandard_ResDto.builder()
                            .statusCode(Constants.statusCode_Success)
                            .standard(standard)
                            .studentRegistrationDtoList(registrationDtos)
                            .build();
                }else {
                    studentRegistrationDtos = AllStudentsInfoBasedOnStandard_ResDto.builder()
                            .statusCode(Constants.statusCode_Failure)
                            .standard(standard)
                            .errorMsg(Constants.invalid_Standard)
                            .build();
                }
            }else {
                studentRegistrationDtos = AllStudentsInfoBasedOnStandard_ResDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.emptyStandard_Error)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return studentRegistrationDtos;
    }


    @Override
    public CommonResponseDto registerStaff(StaffRegistration_Dto staffRegistrationDto) {
        CommonResponseDto commonResponseDto = null;
        try {
            if (staffRegistrationDto != null && StringUtils.isNotBlank(staffRegistrationDto.getFldFullName()) && StringUtils.isNotBlank(staffRegistrationDto.getFldEmailId())) {
                Optional<StaffRegistration_Entity> staffRegistration = staffRegDao.findByFldFullNameAndFldEmailId(staffRegistrationDto.getFldFullName(), staffRegistrationDto.getFldEmailId());
                if(!staffRegistration.isPresent()){
                    StringBuilder staffId = new StringBuilder();
                    staffId.append(Constants.IDSTART_MNG).append(staffRegDao.getStaffIdVal());
                    String password = staffRegistrationDto.getFldPassword();
                    staffRegistrationDto.setFldPassword(encryptDecryptRSAUtil.encode(staffRegistrationDto.getFldPassword()));
                    StaffRegistration_Entity staffRegistrationEntity = beanUtils.getStaffRegEntity(staffRegistrationDto);
                    staffRegistrationEntity.setFldStaffId(staffId.toString());
                    staffRegistrationEntity = setStandardsAndSubjects(staffRegistrationEntity, staffRegistrationDto);
                    staffRegDao.save(staffRegistrationEntity);
                    String emailSub = Constants.emailSub_Registration;
                    StringBuilder emailMsg = new StringBuilder();
                    emailMsg.append(Constants.dear).append(staffRegistrationDto.getFldFullName()).append(",")
                            .append(Constants.newLineDouble).append(Constants.emailMsg_Reg).append(Constants.newLineDouble)
                            .append(Constants.updatePass_UserId).append(staffId).append(Constants.newLineSingle)
                            .append(Constants.updatePass_Password).append(password).append(Constants.newLineDouble)
                            .append(Constants.email_Regards);
                    otp.sendMail(staffRegistrationDto.getFldEmailId(), emailSub, emailMsg.toString());
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Success)
                            .errorMsg(Constants.registrationCompleted_Success + staffId)
                            .build();
                }else {
                    commonResponseDto = CommonResponseDto.builder()
                            .statusCode(Constants.statusCode_Success)
                            .errorMsg(Constants.userExist_Already + staffRegistration.get().getFldStaffId())
                            .build();
                }
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            commonResponseDto = CommonResponseDto.builder()
                    .statusCode(Constants.statusCode_Failure)
                    .errorMsg(Constants.connection_Error)
                    .build();
        }
        return commonResponseDto;
    }

    private StaffRegistration_Entity setStandardsAndSubjects(StaffRegistration_Entity staffRegistrationEntity, StaffRegistration_Dto staffRegistrationDto){
        Standard_Entity standardEntity = null;
        Subject_Entity subjectEntity = null;
        List<Standard_Entity> standardEntityList = new ArrayList<>();
        List<Subject_Entity> subjectEntityList = new ArrayList<>();
        for(String standard : staffRegistrationDto.getStandards()){
            standardEntity = new Standard_Entity();
            standardEntity.setFldStandard(standard);
            standardEntityList.add(standardEntity);
        }
        for(String subject : staffRegistrationDto.getSubjects()){
            subjectEntity = new Subject_Entity();
            subjectEntity.setFldSubject(subject);
            subjectEntityList.add(subjectEntity);
        }
        staffRegistrationEntity.setFldStandard(standardEntityList);
        staffRegistrationEntity.setFldSubject(subjectEntityList);

        return staffRegistrationEntity;
    }

}
