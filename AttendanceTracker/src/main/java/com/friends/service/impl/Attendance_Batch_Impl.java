package com.friends.service.impl;

import com.friends.dao.*;
import com.friends.dto.Attendance_Batch_Dto;
import com.friends.dto.CommonResponse;
import com.friends.dto.Constants;
import com.friends.model.*;
import com.friends.service.Attendance_Batch;
import com.friends.utils.AdapterUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Service
public class Attendance_Batch_Impl implements Attendance_Batch {
    private final static Logger logger = Logger.getLogger(Attendance_Batch_Impl.class.getName());

    @Autowired
    private Batch_MCA201_Dao batchMca201Dao;

    @Autowired
    private Batch_MCA202_Dao batchMca202Dao;

    @Autowired
    private Batch_MCA203_Dao batchMca203Dao;

    @Autowired
    private Batch_CSE401_Dao batchCse401Dao;

    @Autowired
    private Batch_CSE402_Dao batchCse402Dao;

    @Override
    public CommonResponse saveAttendance(List<Attendance_Batch_Dto> attendanceBatchDto) {
        CommonResponse commonResponse = null;
        try {
            if (attendanceBatchDto != null && !attendanceBatchDto.isEmpty() && attendanceBatchDto.get(0) != null) {
                String batchNum = attendanceBatchDto.get(0).getBatchNum();
                commonResponse = CommonResponse.builder()
                        .statusCode(Constants.status_Success)
                        .message(Constants.saveSuccess)
                        .build();
                if (batchNum.equalsIgnoreCase(Constants.batch_201)) {
                    Optional<String> dbDate = batchMca201Dao.getTimeStampValueFromDb();
                    if(dbDate.isPresent()){
                        if(AdapterUtils.compareDbDateWithCurrentDate(dbDate.get())){
                            commonResponse = CommonResponse.builder()
                                    .statusCode(Constants.status_Failure)
                                    .message(Constants.alreadySavedAttendance)
                                    .build();
                            return commonResponse;
                        }
                    }
                    List<Batch_MCA201_Entity> batchMca201 = new ArrayList<>();
                    Batch_MCA201_Entity batchMca201Entity = null;
                    for (Attendance_Batch_Dto batchDto : attendanceBatchDto) {
                        batchMca201Entity = Batch_MCA201_Entity.builder()
                                .fldEmpId(batchDto.getFldEmpId())
                                .fldFullName(batchDto.getFldFullName())
                                .fldStaffName(batchDto.getFldStaffName())
                                .fldYear(AdapterUtils.getPresentYear())
                                .fldMonth(AdapterUtils.getPresentMonth())
                                .fldStatus(batchDto.getFldStatus())
                                .build();
                        batchMca201.add(batchMca201Entity);
                    }
                    batchMca201Dao.saveAll(batchMca201);
                } else if (batchNum.equalsIgnoreCase(Constants.batch_202)) {
                    Optional<String> dbDate = batchMca202Dao.getTimeStampValueFromDb();
                    if(dbDate.isPresent()){
                        if(AdapterUtils.compareDbDateWithCurrentDate(dbDate.get())){
                            commonResponse = CommonResponse.builder()
                                    .statusCode(Constants.status_Failure)
                                    .message(Constants.alreadySavedAttendance)
                                    .build();
                            return commonResponse;
                        }
                    }
                    List<Batch_MCA202_Entity> batchMca202 = new ArrayList<>();
                    Batch_MCA202_Entity batchMca202Entity = null;
                    for (Attendance_Batch_Dto batchDto : attendanceBatchDto) {
                        batchMca202Entity = Batch_MCA202_Entity.builder()
                                .fldEmpId(batchDto.getFldEmpId())
                                .fldFullName(batchDto.getFldFullName())
                                .fldStaffName(batchDto.getFldStaffName())
                                .fldYear(AdapterUtils.getPresentYear())
                                .fldMonth(AdapterUtils.getPresentMonth())
                                .fldStatus(batchDto.getFldStatus())
                                .build();
                        batchMca202.add(batchMca202Entity);
                    }
                    batchMca202Dao.saveAll(batchMca202);
                } else if (batchNum.equalsIgnoreCase(Constants.batch_203)) {
                    Optional<String> dbDate = batchMca203Dao.getTimeStampValueFromDb();
                    if(dbDate.isPresent()){
                        if(AdapterUtils.compareDbDateWithCurrentDate(dbDate.get())){
                            commonResponse = CommonResponse.builder()
                                    .statusCode(Constants.status_Failure)
                                    .message(Constants.alreadySavedAttendance)
                                    .build();
                            return commonResponse;
                        }
                    }
                    List<Batch_MCA203_Entity> batchMca203 = new ArrayList<>();
                    Batch_MCA203_Entity batchMca203Entity = null;
                    for (Attendance_Batch_Dto batchDto : attendanceBatchDto) {
                        batchMca203Entity = Batch_MCA203_Entity.builder()
                                .fldEmpId(batchDto.getFldEmpId())
                                .fldFullName(batchDto.getFldFullName())
                                .fldStaffName(batchDto.getFldStaffName())
                                .fldYear(AdapterUtils.getPresentYear())
                                .fldMonth(AdapterUtils.getPresentMonth())
                                .fldStatus(batchDto.getFldStatus())
                                .build();
                        batchMca203.add(batchMca203Entity);
                    }
                    batchMca203Dao.saveAll(batchMca203);
                } else if (batchNum.equalsIgnoreCase(Constants.batch_401)) {
                    Optional<String> dbDate = batchCse401Dao.getTimeStampValueFromDb();
                    if(dbDate.isPresent()){
                        if(AdapterUtils.compareDbDateWithCurrentDate(dbDate.get())){
                            commonResponse = CommonResponse.builder()
                                    .statusCode(Constants.status_Failure)
                                    .message(Constants.alreadySavedAttendance)
                                    .build();
                            return commonResponse;
                        }
                    }
                    List<Batch_CSE401_Entity> batchCse401 = new ArrayList<>();
                    Batch_CSE401_Entity batchCse401Entity = null;
                    for (Attendance_Batch_Dto batchDto : attendanceBatchDto) {
                        batchCse401Entity = Batch_CSE401_Entity.builder()
                                .fldEmpId(batchDto.getFldEmpId())
                                .fldFullName(batchDto.getFldFullName())
                                .fldStaffName(batchDto.getFldStaffName())
                                .fldYear(AdapterUtils.getPresentYear())
                                .fldMonth(AdapterUtils.getPresentMonth())
                                .fldStatus(batchDto.getFldStatus())
                                .build();
                        batchCse401.add(batchCse401Entity);
                    }
                    batchCse401Dao.saveAll(batchCse401);
                } else if (batchNum.equalsIgnoreCase(Constants.batch_402)) {
                    Optional<String> dbDate = batchCse402Dao.getTimeStampValueFromDb();
                    if(dbDate.isPresent()){
                        if(AdapterUtils.compareDbDateWithCurrentDate(dbDate.get())){
                            commonResponse = CommonResponse.builder()
                                    .statusCode(Constants.status_Failure)
                                    .message(Constants.alreadySavedAttendance)
                                    .build();
                            return commonResponse;
                        }
                    }
                    List<Batch_CSE402_Entity> batchCse402 = new ArrayList<>();
                    Batch_CSE402_Entity batchCse402Entity = null;
                    for (Attendance_Batch_Dto batchDto : attendanceBatchDto) {
                        batchCse402Entity = Batch_CSE402_Entity.builder()
                                .fldEmpId(batchDto.getFldEmpId())
                                .fldFullName(batchDto.getFldFullName())
                                .fldStaffName(batchDto.getFldStaffName())
                                .fldYear(AdapterUtils.getPresentYear())
                                .fldMonth(AdapterUtils.getPresentMonth())
                                .fldStatus(batchDto.getFldStatus())
                                .build();
                        batchCse402.add(batchCse402Entity);
                    }
                    batchCse402Dao.saveAll(batchCse402);
                } else {
                    commonResponse = CommonResponse.builder()
                            .statusCode(Constants.status_Failure)
                            .message(Constants.invalidBatch)
                            .build();
                }
            } else {
                commonResponse = CommonResponse.builder()
                        .statusCode(Constants.status_Failure)
                        .message(Constants.saveFailure)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            commonResponse = CommonResponse.builder()
                    .statusCode(Constants.status_Failure)
                    .message(Constants.saveFailure)
                    .build();
        }
        return commonResponse;
    }
}
