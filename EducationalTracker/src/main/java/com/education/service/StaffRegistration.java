package com.education.service;

import com.education.dto.CommonResponseDto;
import com.education.dto.StaffRegistration_Dto;
import com.education.model.StaffRegistration_Entity;

public interface StaffRegistration {

    CommonResponseDto registerStaff(StaffRegistration_Dto staffRegistrationDto);
}
