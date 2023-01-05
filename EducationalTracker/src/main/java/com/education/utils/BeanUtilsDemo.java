package com.education.utils;

import com.education.dto.StaffRegistration_Dto;
import com.education.dto.StudentRegistration_Dto;
import com.education.model.StaffRegistration_Entity;
import com.education.model.StudentRegistration_Entity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.education.utils.SpringUtils.getStackTrace;

@Component
public class BeanUtilsDemo {
    private static final Logger logger = Logger.getLogger(BeanUtilsDemo.class.getName());

    public StudentRegistration_Entity getStudentRegEntity(StudentRegistration_Dto studentRegistrationDto){
        StudentRegistration_Entity studentRegistrationEntity = new StudentRegistration_Entity();
        try {
            BeanUtils.copyProperties(studentRegistrationDto, studentRegistrationEntity);
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }

        return studentRegistrationEntity;
    }

    public StudentRegistration_Dto getStudentRegDto(StudentRegistration_Entity studentRegistrationEntity){
        StudentRegistration_Dto studentRegistrationDto = new StudentRegistration_Dto();
        try {
            BeanUtils.copyProperties(studentRegistrationEntity, studentRegistrationDto);
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }

        return studentRegistrationDto;
    }

    public StaffRegistration_Entity getStaffRegEntity(StaffRegistration_Dto staffRegistrationDto){
        StaffRegistration_Entity staffRegistrationEntity = new StaffRegistration_Entity();
        try {
            BeanUtils.copyProperties(staffRegistrationDto, staffRegistrationEntity);
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }

        return staffRegistrationEntity;
    }

}
