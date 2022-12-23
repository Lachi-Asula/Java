package com.friends.service.impl;

import com.friends.dao.Emp_Info_Dao;
import com.friends.dto.CommonResponse;
import com.friends.dto.Constants;
import com.friends.dto.UpdateStatusDto;
import com.friends.service.UpdateStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Service
public class UpdateStatus_Impl implements UpdateStatus {

    private final static Logger logger = Logger.getLogger(UpdateStatus_Impl.class.getName());

    @Autowired
    private Emp_Info_Dao empInfoDao;

    @Override
    public CommonResponse updateStatusOfEmp(UpdateStatusDto updateStatusDto) {
        CommonResponse commonResponse = null;
        try {
            if (updateStatusDto != null && StringUtils.isNotBlank(updateStatusDto.getEmpId()) && StringUtils.isNotBlank(updateStatusDto.getStatus())) {
                empInfoDao.updateStatusByEmpId(updateStatusDto.getStatus(), updateStatusDto.getEmpId());
                commonResponse = CommonResponse.builder()
                        .statusCode(Constants.status_Success)
                        .message(Constants.updateStatus_Success + updateStatusDto.getStatus())
                        .build();
            } else {
                commonResponse = CommonResponse.builder()
                        .statusCode(Constants.status_Failure)
                        .message(Constants.updateStatus_EmptyData)
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
