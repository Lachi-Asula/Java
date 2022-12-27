package com.friends.service.impl;

import com.friends.dao.Emp_Info_Dao;
import com.friends.dao.Staff_Info_Dao;
import com.friends.dto.Constants;
import com.friends.dto.UpdateEmailIdReqDto;
import com.friends.dto.UpdateEmailIdResDto;
import com.friends.model.Emp_Info_Entity;
import com.friends.model.Staff_Info_Entity;
import com.friends.service.UpdateEmailId;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Service
public class UpdateEmailId_Impl implements UpdateEmailId {
    private final static Logger logger = Logger.getLogger(UpdateEmailId_Impl.class.getName());

    @Autowired
    private Staff_Info_Dao staffInfoDao;

    @Autowired
    private Emp_Info_Dao empInfoDao;

    @Override
    public UpdateEmailIdResDto updateEmailId(UpdateEmailIdReqDto updateEmailIdReqDto) {
        UpdateEmailIdResDto updateEmailIdResDto = null;
        try {
            if (updateEmailIdReqDto != null && StringUtils.isNotBlank(updateEmailIdReqDto.getEmpId()) && StringUtils.isNotBlank(updateEmailIdReqDto.getDateOfBirth())) {
                if(updateEmailIdReqDto.getEmpId().startsWith(Constants.idStart)){
                    Optional<Emp_Info_Entity> empInfoEntity = empInfoDao.findByFldEmpIdAndFldDob(updateEmailIdReqDto.getEmpId(), updateEmailIdReqDto.getDateOfBirth());
                    if(empInfoEntity.isPresent()){
                        empInfoDao.updateEmailIdByEmpId(updateEmailIdReqDto.getNewEmailId(), updateEmailIdReqDto.getEmpId());
                        updateEmailIdResDto = UpdateEmailIdResDto.builder()
                                .statusCode(Constants.status_Success)
                                .message(Constants.updateEmail_Success)
                                .emailId(updateEmailIdReqDto.getNewEmailId())
                                .empId(updateEmailIdReqDto.getEmpId())
                                .build();
                    }else {
                        updateEmailIdResDto = UpdateEmailIdResDto.builder()
                                .statusCode(Constants.status_Failure)
                                .message(Constants.updateEmail_InvalidDobOrEmpId)
                                .build();
                    }
                }else {
                    Optional<Staff_Info_Entity> staffInfoEntity = staffInfoDao.findByFldEmpIdAndFldDob(updateEmailIdReqDto.getEmpId(),  updateEmailIdReqDto.getDateOfBirth());
                    if(staffInfoEntity.isPresent()){
                        staffInfoDao.updateEmailIdByEmpId(updateEmailIdReqDto.getNewEmailId(), updateEmailIdReqDto.getEmpId());
                        updateEmailIdResDto = UpdateEmailIdResDto.builder()
                                .statusCode(Constants.status_Success)
                                .message(Constants.updateEmail_Success)
                                .emailId(updateEmailIdReqDto.getNewEmailId())
                                .empId(updateEmailIdReqDto.getEmpId())
                                .build();
                    }else {
                        updateEmailIdResDto = UpdateEmailIdResDto.builder()
                                .statusCode(Constants.status_Failure)
                                .message(Constants.updateEmail_InvalidDobOrEmpId)
                                .build();
                    }
                }
            } else {
                updateEmailIdResDto = UpdateEmailIdResDto.builder()
                        .statusCode(Constants.status_Failure)
                        .message(Constants.updateEmail_EmptyData)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            updateEmailIdResDto = UpdateEmailIdResDto.builder()
                    .statusCode(Constants.status_Failure)
                    .message(Constants.saveFailure)
                    .build();
        }

        return updateEmailIdResDto;
    }
}
