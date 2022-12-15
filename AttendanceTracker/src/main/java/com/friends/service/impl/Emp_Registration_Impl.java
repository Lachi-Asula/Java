package com.friends.service.impl;

import com.friends.dao.Emp_Info_Dao;
import com.friends.dto.CommonResponse;
import com.friends.dto.Constants;
import com.friends.dto.Emp_Info_Dto;
import com.friends.model.Emp_Info_Entity;
import com.friends.service.Emp_Register;
import com.friends.utils.BeanUtilsDemo;
import com.friends.utils.encryption.EncryptDecryptRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Emp_Registration_Impl implements Emp_Register {

    @Autowired
    private Emp_Info_Dao empInfoDao;

    @Autowired
    private BeanUtilsDemo beanUtils;

    @Autowired
    private EncryptDecryptRSAUtil encryptDecryptRSAUtil;

    @Override
    public CommonResponse Emp_Registration(Emp_Info_Dto empInfoDto) {
        CommonResponse commonResponse;
        if(empInfoDto != null){
            if(empInfoDto.getFldFullName() != null && empInfoDto.getFldEmailId() != null){
                Optional<Emp_Info_Entity> empInfoEntity = empInfoDao.findByFldFullNameAndFldEmailId(empInfoDto.getFldFullName(), empInfoDto.getFldEmailId());
                if(!empInfoEntity.isPresent()){
                    String empId = Constants.idStart + empInfoDao.getnewEmpID();
                    String password = encryptDecryptRSAUtil.encode(empInfoDto.getFldPassword());
                    empInfoDto.setFldPassword(password);
                    empInfoDto.setFldEmpId(empId);
                    Emp_Info_Entity emp_info_entity = beanUtils.getEmpInfoEntity(empInfoDto);
                    empInfoDao.save(emp_info_entity);
                    commonResponse = CommonResponse.builder()
                        .statusCode("0")
                        .message(Constants.successEmpRegister + empInfoDto.getFldEmpId())
                        .build();
                }else {
                    commonResponse = CommonResponse.builder()
                            .statusCode("1")
                            .message(Constants.alreadyEmpRegister + empInfoEntity.get().getFldEmpId())
                            .build();
                }
            }else {
                commonResponse = CommonResponse.builder()
                        .statusCode("1")
                        .message(Constants.empRegError)
                        .build();
            }
        }else {
            commonResponse = CommonResponse.builder()
                    .statusCode("1")
                    .message(Constants.empRegError)
                    .build();
        }

        return commonResponse;
    }
}
