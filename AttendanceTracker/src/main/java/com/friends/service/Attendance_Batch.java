package com.friends.service;

import com.friends.dao.Batch_MCA201_Dao;
import com.friends.dto.*;
import com.friends.model.Batch_MCA201_Entity;

import java.util.List;

public interface Attendance_Batch {
    CommonResponse saveAttendance(List<Attendance_Batch_Dto> attendanceBatchDto);
    EmployeeAttendanceStatusResDto getStatusOfEmployeeAttendance(EmployeeAttendanceStatusReqDto statusReqDto);

}
