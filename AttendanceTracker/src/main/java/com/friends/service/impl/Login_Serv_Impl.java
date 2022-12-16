package com.friends.service.impl;

import com.friends.dao.Batch_Info_Dao;
import com.friends.dao.Emp_Info_Dao;
import com.friends.dao.Staff_Info_Dao;
import com.friends.dto.*;
import com.friends.model.Emp_Info_Entity;
import com.friends.utils.encryption.EncryptDecryptRSAUtil;
import com.friends.model.Staff_Info_Entity;
import com.friends.service.GetEmpRole;
import com.friends.utils.BeanUtilsDemo;
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
public class Login_Serv_Impl implements GetEmpRole {

    private final static Logger logger = Logger.getLogger(Login_Serv_Impl.class.getName());

    @Autowired
    private Emp_Info_Dao empInfoDao;

    @Autowired
    private Staff_Info_Dao staffInfoDao;

    @Autowired
    private Batch_Info_Dao batchInfoDao;

    @Autowired
    private BeanUtilsDemo beanUtils;

    @Autowired
    private EncryptDecryptRSAUtil encDecUsingRSA;

    @Override
    public Login_Res_Dto getEmpRoleServ(String empId) {
        Login_Res_Dto loginResDto = null;
        try {
            if (StringUtils.isNotBlank(empId)) {
                if(empId.startsWith(Constants.idStart)){
                    Optional<Emp_Info_Entity> empInfoEntity = empInfoDao.findByFldEmpId(empId);
                    if(empInfoEntity.isPresent()) {
                        loginResDto = Login_Res_Dto.builder()
                                .role(Constants.employee)
                                .empName(empInfoEntity.get().getFldFullName())
                                .statusCode(Constants.status_Success)
                                .batchNums(new ArrayList<>())
                                .errorMsg(null)
                                .build();
                    }else {
                        loginResDto = Login_Res_Dto.builder()
                                .role(null)
                                .statusCode(Constants.status_Failure)
                                .errorMsg(Constants.invalidEmpId)
                                .build();
                    }
                }else {
                    Optional<Staff_Info_Entity> staffInfoEntity = staffInfoDao.findByFldEmpId(empId);
                    if (staffInfoEntity.isPresent()) {
                        Staff_Info_Dto staffInfoDto = beanUtils.getStaffInfoDto(staffInfoEntity.get());
                        List<String> allBatchNums = new ArrayList<>();
                        if (staffInfoDto.getFldSpecialization().equals(Constants.trainee)) {
                            for (Batch_Info_Dto batchInfoDto : staffInfoDto.getFld_Staff_Id()) {
                                allBatchNums.add(batchInfoDto.getFldBatchName());
                            }
                        } else {
                            Optional<List<String>> getAllbatchesOpt = batchInfoDao.getAllBatchesNames();
                            if (getAllbatchesOpt.isPresent()) {
                                allBatchNums = getAllbatchesOpt.get();
                            }
                        }
                        loginResDto = Login_Res_Dto.builder()
                                .role(staffInfoDto.getFldSpecialization())
                                .empName(staffInfoDto.getFldFullName())
                                .statusCode(Constants.status_Success)
                                .batchNums(allBatchNums)
                                .errorMsg(null)
                                .build();
                    } else {
                        loginResDto = Login_Res_Dto.builder()
                                .role(null)
                                .statusCode(Constants.status_Failure)
                                .errorMsg(Constants.invalidEmpId)
                                .build();
                    }
                }
            } else {
                loginResDto = Login_Res_Dto.builder()
                        .role(null)
                        .statusCode(Constants.status_Failure)
                        .errorMsg(Constants.errorMsg)
                        .build();
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, getStackTrace(e));
            loginResDto = Login_Res_Dto.builder()
                    .role(null)
                    .statusCode(Constants.status_Failure)
                    .errorMsg(Constants.errorMsg)
                    .build();
        }
        return loginResDto;
    }

    @Override
    public Login_Res_Dto getAllbatches() {
        Login_Res_Dto loginResDto;
        Optional<List<String>> allBatches = batchInfoDao.getAllBatchesNames();
        if (allBatches.isPresent()) {
            loginResDto = Login_Res_Dto.builder()
                    .batchNums(allBatches.get())
                    .statusCode(Constants.status_Success)
                    .build();
        } else {
            loginResDto = Login_Res_Dto.builder()
                    .statusCode(Constants.status_Failure)
                    .errorMsg(Constants.noData)
                    .build();
        }

        return loginResDto;
    }
}
