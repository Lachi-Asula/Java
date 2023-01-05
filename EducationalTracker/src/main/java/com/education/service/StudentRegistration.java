package com.education.service;

import com.education.dto.CommonResponseDto;
import com.education.dto.StudentRegistration_Dto;

public interface StudentRegistration {
    CommonResponseDto registerStudent(StudentRegistration_Dto registrationDto);
}
