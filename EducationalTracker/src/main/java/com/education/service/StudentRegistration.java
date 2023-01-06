package com.education.service;

import com.education.dto.*;

import java.util.List;
import java.util.Optional;

public interface StudentRegistration {
    CommonResponseDto registerStudent(StudentRegistration_Dto registrationDto);

    StudentInfoResDto getStudentInfoBasedOnUserId(UserIdReqDto userIdReqDto);

    AllStudentsInfoBasedOnStandard_ResDto getAllStudentsBasedOnStandard(String standard);
}
