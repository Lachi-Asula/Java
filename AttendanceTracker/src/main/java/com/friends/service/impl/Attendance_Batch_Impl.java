package com.friends.service.impl;

import com.friends.dao.*;
import com.friends.dto.*;
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
                    if (dbDate.isPresent()) {
                        if (AdapterUtils.compareDbDateWithCurrentDate(dbDate.get())) {
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
                    if (dbDate.isPresent()) {
                        if (AdapterUtils.compareDbDateWithCurrentDate(dbDate.get())) {
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
                    if (dbDate.isPresent()) {
                        if (AdapterUtils.compareDbDateWithCurrentDate(dbDate.get())) {
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
                    if (dbDate.isPresent()) {
                        if (AdapterUtils.compareDbDateWithCurrentDate(dbDate.get())) {
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
                    if (dbDate.isPresent()) {
                        if (AdapterUtils.compareDbDateWithCurrentDate(dbDate.get())) {
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
        } catch (Exception e) {
            logger.log(Level.SEVERE, getStackTrace(e));
            commonResponse = CommonResponse.builder()
                    .statusCode(Constants.status_Failure)
                    .message(Constants.saveFailure)
                    .build();
        }
        return commonResponse;
    }

    @Override
    public EmployeeAttendanceStatusResDto getStatusOfEmployeeAttendance(EmployeeAttendanceStatusReqDto statusReqDto) {
        EmployeeAttendanceStatusResDto statusResDto = null;
        if (statusReqDto != null && StringUtils.isNotBlank(statusReqDto.getEmpId()) && StringUtils.isNotBlank(statusReqDto.getBatchNum())) {
            String batchNum = statusReqDto.getBatchNum();
            List<PresentDay> presentDays = null;
            List<Absentday> absentDays = null;
            if (batchNum.equalsIgnoreCase(Constants.batch_201)) {
                Optional<List<Batch_MCA201_Entity>> presentDaysFromDb = batchMca201Dao.findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(statusReqDto.getEmpId(), statusReqDto.getYear(), statusReqDto.getMonth(), Constants.status_Present);
                Optional<List<Batch_MCA201_Entity>> absentDaysFromDb = batchMca201Dao.findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(statusReqDto.getEmpId(), statusReqDto.getYear(), statusReqDto.getMonth(), Constants.statuc_Absent);
                presentDays = getPresentDaysDto1(presentDaysFromDb);
                absentDays = getAbsentDaysDto1(absentDaysFromDb);
                statusResDto = getFinalStatusReportOfEmployeeAttendance(presentDays, absentDays);
            } else if (batchNum.equalsIgnoreCase(Constants.batch_202)) {
                Optional<List<Batch_MCA202_Entity>> presentDaysFromDb = batchMca202Dao.findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(statusReqDto.getEmpId(), statusReqDto.getYear(), statusReqDto.getMonth(), Constants.status_Present);
                Optional<List<Batch_MCA202_Entity>> absentDaysFromDb = batchMca202Dao.findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(statusReqDto.getEmpId(), statusReqDto.getYear(), statusReqDto.getMonth(), Constants.statuc_Absent);
                presentDays = getPresentDaysDto2(presentDaysFromDb);
                absentDays = getAbsentDaysDto2(absentDaysFromDb);
                statusResDto = getFinalStatusReportOfEmployeeAttendance(presentDays, absentDays);
            } else if (batchNum.equalsIgnoreCase(Constants.batch_203)) {
                Optional<List<Batch_MCA203_Entity>> presentDaysFromDb = batchMca203Dao.findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(statusReqDto.getEmpId(), statusReqDto.getYear(), statusReqDto.getMonth(), Constants.status_Present);
                Optional<List<Batch_MCA203_Entity>> absentDaysFromDb = batchMca203Dao.findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(statusReqDto.getEmpId(), statusReqDto.getYear(), statusReqDto.getMonth(), Constants.statuc_Absent);
                presentDays = getPresentDaysDto3(presentDaysFromDb);
                absentDays = getAbsentDaysDto3(absentDaysFromDb);
                statusResDto = getFinalStatusReportOfEmployeeAttendance(presentDays, absentDays);
            } else if (batchNum.equalsIgnoreCase(Constants.batch_401)) {
                Optional<List<Batch_CSE401_Entity>> presentDaysFromDb = batchCse401Dao.findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(statusReqDto.getEmpId(), statusReqDto.getYear(), statusReqDto.getMonth(), Constants.status_Present);
                Optional<List<Batch_CSE401_Entity>> absentDaysFromDb = batchCse401Dao.findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(statusReqDto.getEmpId(), statusReqDto.getYear(), statusReqDto.getMonth(), Constants.statuc_Absent);
                presentDays = getPresentDaysDto4(presentDaysFromDb);
                absentDays = getAbsentDaysDto4(absentDaysFromDb);
                statusResDto = getFinalStatusReportOfEmployeeAttendance(presentDays, absentDays);
            } else if (batchNum.equalsIgnoreCase(Constants.batch_402)) {
                Optional<List<Batch_CSE402_Entity>> presentDaysFromDb = batchCse402Dao.findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(statusReqDto.getEmpId(), statusReqDto.getYear(), statusReqDto.getMonth(), Constants.status_Present);
                Optional<List<Batch_CSE402_Entity>> absentDaysFromDb = batchCse402Dao.findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(statusReqDto.getEmpId(), statusReqDto.getYear(), statusReqDto.getMonth(), Constants.statuc_Absent);
                presentDays = getPresentDaysDto5(presentDaysFromDb);
                absentDays = getAbsentDaysDto5(absentDaysFromDb);
                statusResDto = getFinalStatusReportOfEmployeeAttendance(presentDays, absentDays);
            } else {
                statusResDto = EmployeeAttendanceStatusResDto.builder()
                        .statusCode(Constants.status_Failure)
                        .errorMsg(Constants.invalidBatch)
                        .build();
            }
        } else {
            statusResDto = EmployeeAttendanceStatusResDto.builder()
                    .statusCode(Constants.status_Failure)
                    .errorMsg(Constants.emptyEmpIdBatchNum)
                    .build();
        }

        return statusResDto;
    }


    public EmployeeAttendanceStatusResDto getFinalStatusReportOfEmployeeAttendance(List<PresentDay> presentDays, List<Absentday> absentDays) {
        return EmployeeAttendanceStatusResDto.builder()
                .statusCode(Constants.status_Success)
                .presentDays(presentDays)
                .absentDays(absentDays)
                .presentDaysCount(String.valueOf(presentDays.size()))
                .absentDaysCount(String.valueOf(absentDays.size()))
                .build();
    }

    public List<PresentDay> getPresentDaysDto1(Optional<List<Batch_MCA201_Entity>> batchMca201Info) {
        List<PresentDay> presentDaysList = new ArrayList<>();
        PresentDay presentDay = null;
        if (batchMca201Info.isPresent()) {
            List<Batch_MCA201_Entity> batchMca201 = batchMca201Info.get();
            for (Batch_MCA201_Entity singleEntity : batchMca201) {
                presentDay = PresentDay.builder()
                        .presentDay(AdapterUtils.getTimeStampsForSingleStatus(singleEntity.getTimeStampValue()))
                        .staffName(singleEntity.getFldStaffName())
                        .build();
                presentDaysList.add(presentDay);
            }
        }
        return presentDaysList;
    }

    public List<PresentDay> getPresentDaysDto2(Optional<List<Batch_MCA202_Entity>> batchMca202Info) {
        List<PresentDay> presentDaysList = new ArrayList<>();
        PresentDay presentDay = null;
        if (batchMca202Info.isPresent()) {
            List<Batch_MCA202_Entity> batchMca203 = batchMca202Info.get();
            for (Batch_MCA202_Entity singleEntity : batchMca203) {
                presentDay = PresentDay.builder()
                        .presentDay(AdapterUtils.getTimeStampsForSingleStatus(singleEntity.getTimeStampValue()))
                        .staffName(singleEntity.getFldStaffName())
                        .build();
                presentDaysList.add(presentDay);
            }
        }
        return presentDaysList;
    }

    public List<PresentDay> getPresentDaysDto3(Optional<List<Batch_MCA203_Entity>> batchMca203Info) {
        List<PresentDay> presentDaysList = new ArrayList<>();
        PresentDay presentDay = null;
        if (batchMca203Info.isPresent()) {
            List<Batch_MCA203_Entity> batchMca203 = batchMca203Info.get();
            for (Batch_MCA203_Entity singleEntity : batchMca203) {
                presentDay = PresentDay.builder()
                        .presentDay(AdapterUtils.getTimeStampsForSingleStatus(singleEntity.getTimeStampValue()))
                        .staffName(singleEntity.getFldStaffName())
                        .build();
                presentDaysList.add(presentDay);
            }
        }
        return presentDaysList;
    }

    public List<PresentDay> getPresentDaysDto4(Optional<List<Batch_CSE401_Entity>> batchCse401Info) {
        List<PresentDay> presentDaysList = new ArrayList<>();
        PresentDay presentDay = null;
        if (batchCse401Info.isPresent()) {
            List<Batch_CSE401_Entity> batch401 = batchCse401Info.get();
            for (Batch_CSE401_Entity singleEntity : batch401) {
                presentDay = PresentDay.builder()
                        .presentDay(AdapterUtils.getTimeStampsForSingleStatus(singleEntity.getTimeStampValue()))
                        .staffName(singleEntity.getFldStaffName())
                        .build();
                presentDaysList.add(presentDay);
            }
        }
        return presentDaysList;
    }

    public List<PresentDay> getPresentDaysDto5(Optional<List<Batch_CSE402_Entity>> batchCse402Info) {
        List<PresentDay> presentDaysList = new ArrayList<>();
        PresentDay presentDay = null;
        if (batchCse402Info.isPresent()) {
            List<Batch_CSE402_Entity> batch402 = batchCse402Info.get();
            for (Batch_CSE402_Entity singleEntity : batch402) {
                presentDay = PresentDay.builder()
                        .presentDay(AdapterUtils.getTimeStampsForSingleStatus(singleEntity.getTimeStampValue()))
                        .staffName(singleEntity.getFldStaffName())
                        .build();
                presentDaysList.add(presentDay);
            }
        }
        return presentDaysList;
    }

    public List<Absentday> getAbsentDaysDto1(Optional<List<Batch_MCA201_Entity>> batchMca201Info) {
        List<Absentday> absentDaysList = new ArrayList<>();
        Absentday absentday = null;
        List<Batch_MCA201_Entity> batchMca201 = batchMca201Info.get();
        for (Batch_MCA201_Entity singleEntity : batchMca201) {
            absentday = Absentday.builder()
                    .presentDay(AdapterUtils.getTimeStampsForSingleStatus(singleEntity.getTimeStampValue()))
                    .staffName(singleEntity.getFldStaffName())
                    .build();
            absentDaysList.add(absentday);

        }
        return absentDaysList;
    }

    public List<Absentday> getAbsentDaysDto2(Optional<List<Batch_MCA202_Entity>> batchMca202Info) {
        List<Absentday> absentDaysList = new ArrayList<>();
        Absentday absentday = null;
        if (batchMca202Info.isPresent()) {
            List<Batch_MCA202_Entity> batchMca202 = batchMca202Info.get();
            for (Batch_MCA202_Entity singleEntity : batchMca202) {
                absentday = Absentday.builder()
                        .presentDay(AdapterUtils.getTimeStampsForSingleStatus(singleEntity.getTimeStampValue()))
                        .staffName(singleEntity.getFldStaffName())
                        .build();
                absentDaysList.add(absentday);
            }
        }
        return absentDaysList;
    }

    public List<Absentday> getAbsentDaysDto3(Optional<List<Batch_MCA203_Entity>> batchMca203Info) {
        List<Absentday> absentDaysList = new ArrayList<>();
        Absentday absentday = null;
        if (batchMca203Info.isPresent()) {
            List<Batch_MCA203_Entity> batchMca203 = batchMca203Info.get();
            for (Batch_MCA203_Entity singleEntity : batchMca203) {
                absentday = Absentday.builder()
                        .presentDay(AdapterUtils.getTimeStampsForSingleStatus(singleEntity.getTimeStampValue()))
                        .staffName(singleEntity.getFldStaffName())
                        .build();
                absentDaysList.add(absentday);
            }
        }
        return absentDaysList;
    }

    public List<Absentday> getAbsentDaysDto4(Optional<List<Batch_CSE401_Entity>> batchCse401Info) {
        List<Absentday> absentDaysList = new ArrayList<>();
        Absentday absentday = null;
        if (batchCse401Info.isPresent()) {
            List<Batch_CSE401_Entity> batch401 = batchCse401Info.get();
            for (Batch_CSE401_Entity singleEntity : batch401) {
                absentday = Absentday.builder()
                        .presentDay(AdapterUtils.getTimeStampsForSingleStatus(singleEntity.getTimeStampValue()))
                        .staffName(singleEntity.getFldStaffName())
                        .build();
                absentDaysList.add(absentday);
            }
        }
        return absentDaysList;
    }

    public List<Absentday> getAbsentDaysDto5(Optional<List<Batch_CSE402_Entity>> batchCse402Info) {
        List<Absentday> absentDaysList = new ArrayList<>();
        Absentday absentday = null;
        if (batchCse402Info.isPresent()) {
            List<Batch_CSE402_Entity> batch402 = batchCse402Info.get();
            for (Batch_CSE402_Entity singleEntity : batch402) {
                absentday = Absentday.builder()
                        .presentDay(AdapterUtils.getTimeStampsForSingleStatus(singleEntity.getTimeStampValue()))
                        .staffName(singleEntity.getFldStaffName())
                        .build();
                absentDaysList.add(absentday);
            }
        }
        return absentDaysList;
    }

}
