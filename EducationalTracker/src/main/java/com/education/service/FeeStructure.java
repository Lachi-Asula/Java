package com.education.service;

import com.education.dto.FeeStructureResDto;
import com.education.dto.FeeStructureUpdateReqDto;

public interface FeeStructure {

    FeeStructureResDto getFeeStructure();
    FeeStructureResDto updateFeeStructure(FeeStructureUpdateReqDto feeStructureUpdateReqDto);
}
