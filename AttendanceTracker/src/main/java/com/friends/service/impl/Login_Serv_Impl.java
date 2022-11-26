package com.friends.service.impl;

import com.friends.dao.Batch_Info_Dao;
import com.friends.dao.Staff_Info_Dao;
import com.friends.dto.*;
import com.friends.encryption.AES;
import com.friends.model.Batch_Info_Entity;
import com.friends.model.Staff_Info_Entity;
import com.friends.service.GetEmpRole;
import com.friends.utils.BeanUtilsDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Login_Serv_Impl implements GetEmpRole {

    @Autowired
    private Staff_Info_Dao staffInfoDao;

    @Autowired
    private Batch_Info_Dao batchInfoDao;

    @Autowired
    private BeanUtilsDemo beanUtils;

    @Autowired
    private AES aes;

    @Override
    public Login_Res_Dto getEmpRoleServ(Login_Req_Dto loginReqDto) {
        Login_Res_Dto loginResDto;
        if(loginReqDto != null && loginReqDto.getEmp_Id() != null && loginReqDto.getPassword() != null) {
            String encPass = aes.encode(loginReqDto.getPassword().getBytes());
            loginReqDto.setPassword(encPass);
            Optional<Staff_Info_Entity> staffInfoEntity = staffInfoDao.findByFldEmpIdAndFldPassword(loginReqDto.getEmp_Id(), loginReqDto.getPassword());
            if (staffInfoEntity.isPresent()) {
                Staff_Info_Dto staffInfoDto = beanUtils.getStaffInfoDto(staffInfoEntity.get());
                List<String> allBatchNums = new ArrayList<>();
                if(staffInfoDto.getFldSpecialization().equals(Constants.trainee)){
                    for(Batch_Info_Dto batchInfoDto : staffInfoDto.getFld_Staff_Id()){
                        allBatchNums.add(batchInfoDto.getFldBatchName());
                    }
                }else {
                    Optional<List<String>> getAllbatchesOpt = batchInfoDao.getAllBatchesNames();
                    if(getAllbatchesOpt.isPresent()) {
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
                        .errorMsg(Constants.errorMsg)
                        .build();
            }
        }else {
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
        if(allBatches.isPresent()){
            loginResDto = Login_Res_Dto.builder()
                    .batchNums(allBatches.get())
                    .statusCode(Constants.status_Success)
                    .build();
        }else {
            loginResDto = Login_Res_Dto.builder()
                    .statusCode(Constants.status_Failure)
                    .errorMsg(Constants.noData)
                    .build();
        }

        return loginResDto;
    }
}
