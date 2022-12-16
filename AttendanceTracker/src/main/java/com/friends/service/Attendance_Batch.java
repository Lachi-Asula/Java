package com.friends.service;

import com.friends.dto.Attendance_Batch_Dto;
import com.friends.dto.CommonResponse;

import java.util.List;

public interface Attendance_Batch {
    CommonResponse saveAttendance(List<Attendance_Batch_Dto> attendanceBatchDto);
}
