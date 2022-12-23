package com.friends.service.impl;

import com.friends.dao.Emp_Info_Dao;
import com.friends.dto.CommonResponse;
import com.friends.dto.Constants;
import com.friends.dto.Emp_Info_Dto;
import com.friends.model.Emp_Info_Entity;
import com.friends.service.Emp_Register;
import com.friends.service.OTPService;
import com.friends.utils.BeanUtilsDemo;
import com.friends.utils.encryption.EncryptDecryptRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Service
public class Emp_Registration_Impl implements Emp_Register {
    private final static Logger logger = Logger.getLogger(Emp_Registration_Impl.class.getName());

    @Autowired
    private Emp_Info_Dao empInfoDao;

    @Autowired
    private BeanUtilsDemo beanUtils;

    @Autowired
    private OTPService otpService;

    @Autowired
    private EncryptDecryptRSAUtil encryptDecryptRSAUtil;

    @Override
    public CommonResponse Emp_Registration(Emp_Info_Dto empInfoDto) {
        CommonResponse commonResponse;
        try {
            if (empInfoDto != null) {
                if (empInfoDto.getFldFullName() != null && empInfoDto.getFldEmailId() != null) {
                    Optional<Emp_Info_Entity> empInfoEntity = empInfoDao.findByFldFullNameAndFldEmailId(empInfoDto.getFldFullName(), empInfoDto.getFldEmailId());
                    if (!empInfoEntity.isPresent()) {
                        String empId = Constants.idStart + empInfoDao.getnewEmpID();
                        String password = encryptDecryptRSAUtil.encode(empInfoDto.getFldPassword());
                        empInfoDto.setFldPassword(password);
                        empInfoDto.setFldEmpId(empId);
                        Emp_Info_Entity emp_info_entity = beanUtils.getEmpInfoEntity(empInfoDto);
                        empInfoDao.save(emp_info_entity);
                        otpService.sendGreetingsToEmail(empInfoDto.getFldEmailId(), empInfoDto.getFldEmpId(), empInfoDto.getFldFullName(), encryptDecryptRSAUtil.decode(empInfoDto.getFldPassword()));
                        commonResponse = CommonResponse.builder()
                                .statusCode(Constants.status_Success)
                                .message(Constants.successEmpRegister + empInfoDto.getFldEmpId())
                                .build();
                    } else {
                        commonResponse = CommonResponse.builder()
                                .statusCode(Constants.status_Failure)
                                .message(Constants.alreadyEmpRegister + empInfoEntity.get().getFldEmpId())
                                .build();
                    }
                } else {
                    commonResponse = CommonResponse.builder()
                            .statusCode(Constants.status_Failure)
                            .message(Constants.empRegError)
                            .build();
                }
            } else {
                commonResponse = CommonResponse.builder()
                        .statusCode(Constants.status_Failure)
                        .message(Constants.empRegError)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            commonResponse = CommonResponse.builder()
                    .statusCode(Constants.status_Failure)
                    .message(Constants.empRegError)
                    .build();
        }

        return commonResponse;
    }
}
