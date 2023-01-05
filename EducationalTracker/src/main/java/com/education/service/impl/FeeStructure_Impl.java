package com.education.service.impl;

import com.education.dao.FeeStructureDao;
import com.education.dto.Constants;
import com.education.dto.FeeStructureResDto;
import com.education.dto.FeeStructureUpdateReqDto;
import com.education.model.FeeStructure_Entity;
import com.education.service.FeeStructure;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.education.utils.SpringUtils.getStackTrace;

@Service
public class FeeStructure_Impl implements FeeStructure {

    private static final Logger logger = Logger.getLogger(FeeStructure_Impl.class.getName());

    @Autowired
    private FeeStructureDao feeStructureDao;

    @Override
    public FeeStructureResDto getFeeStructure() {
        FeeStructureResDto feeStructureResDto = null;
        List<FeeStructure_Entity> feeStructureListFromDb = feeStructureDao.findAll();
        if(!feeStructureListFromDb.isEmpty()){
            Map<String, Double> feeInfo = new LinkedHashMap<>();
            for (FeeStructure_Entity feeStructure : feeStructureListFromDb){
                feeInfo.put(feeStructure.getFldStandard(), feeStructure.getFldFeeAmount());
            }
            feeStructureResDto = FeeStructureResDto.builder()
                    .statusCode(Constants.statusCode_Success)
                    .feeInfo(feeInfo)
                    .build();
        }else {
            feeStructureResDto = FeeStructureResDto.builder()
                    .statusCode(Constants.statusCode_Failure)
                    .errorMsg(Constants.connection_Error)
                    .build();
        }
        return feeStructureResDto;
    }

    @Override
    public FeeStructureResDto updateFeeStructure(FeeStructureUpdateReqDto feeStructureUpdateReqDto) {
        FeeStructureResDto feeStructureResDto = null;
        try {
            if(feeStructureUpdateReqDto != null && StringUtils.isNotBlank(feeStructureUpdateReqDto.getFldStandard())){
                feeStructureDao.updateFeeStructure(feeStructureUpdateReqDto.getFldStandard(), feeStructureUpdateReqDto.getAmount());
                feeStructureResDto = getFeeStructure();
            }else {
                feeStructureResDto = FeeStructureResDto.builder()
                        .statusCode(Constants.statusCode_Failure)
                        .errorMsg(Constants.standardAndAmount_Empty_Error)
                        .build();
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
            feeStructureResDto = FeeStructureResDto.builder()
                    .statusCode(Constants.statusCode_Failure)
                    .errorMsg(Constants.connection_Error)
                    .build();
        }
        return feeStructureResDto;
    }

}
