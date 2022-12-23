package com.friends.service.impl;

import com.friends.dao.Emp_Info_Dao;
import com.friends.dto.Constants;
import com.friends.dto.Emp_Info_Dto;
import com.friends.dto.GetEmpInfo_BasedOn_BatchNum;
import com.friends.model.Emp_Info_Entity;
import com.friends.service.GetBatch_Info;
import com.friends.utils.BeanUtilsDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Service
public class GetBatch_Info_Impl implements GetBatch_Info {

    private final static Logger logger = Logger.getLogger(GetBatch_Info_Impl.class.getName());

    @Autowired
    private Emp_Info_Dao empInfoDao;

    @Autowired
    private BeanUtilsDemo beanUtils;

    @Override
    public GetEmpInfo_BasedOn_BatchNum getEmpInfoBasedOnBatchNum(String batchNum) {
        GetEmpInfo_BasedOn_BatchNum empInfoBasedOnBatchNum;
        List<Emp_Info_Dto> empInfoDtoList = new ArrayList<>();
        try{
            if(batchNum != null) {
                Optional<List<Emp_Info_Entity>> empInfoEntities = empInfoDao.findByFldBatchNumAndFldStatus(batchNum, Constants.stutusTraining);
                if (empInfoEntities.isPresent() && !empInfoEntities.get().isEmpty()) {
                    empInfoDtoList = beanUtils.getListOfEmpsDto(empInfoEntities.get());
                    empInfoBasedOnBatchNum = GetEmpInfo_BasedOn_BatchNum.builder()
                            .statusCode(Constants.status_Success)
                            .empInfoDtoList(empInfoDtoList)
                            .message(Constants.successEmpInfo)
                            .build();
                } else {
                    empInfoBasedOnBatchNum = GetEmpInfo_BasedOn_BatchNum.builder()
                            .statusCode(Constants.status_Failure)
                            .empInfoDtoList(empInfoDtoList)
                            .message(Constants.noData)
                            .build();
                }
            }else {
                empInfoBasedOnBatchNum = GetEmpInfo_BasedOn_BatchNum.builder()
                        .statusCode(Constants.status_Failure)
                        .empInfoDtoList(empInfoDtoList)
                        .message(Constants.emptyBatchNum)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            empInfoBasedOnBatchNum = GetEmpInfo_BasedOn_BatchNum.builder()
                    .statusCode(Constants.status_Failure)
                    .empInfoDtoList(empInfoDtoList)
                    .message(Constants.noData)
                    .build();
        }
        return empInfoBasedOnBatchNum;
    }
}
