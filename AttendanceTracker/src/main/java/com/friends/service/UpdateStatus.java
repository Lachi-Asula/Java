package com.friends.service;

import com.friends.dto.CommonResponse;
import com.friends.dto.UpdateStatusDto;

public interface UpdateStatus {
    CommonResponse updateStatusOfEmp(UpdateStatusDto updateStatusDto);
}
