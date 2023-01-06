package com.education.service;

import com.education.dto.FeeInfoBasedOnStandard_ResDto;
import com.education.dto.FeeStructureResDto;
import com.education.dto.FeeStructureUpdateReqDto;

public interface FeeStructure {

    FeeStructureResDto getFeeStructure();
    FeeStructureResDto updateFeeStructure(FeeStructureUpdateReqDto feeStructureUpdateReqDto);
    FeeInfoBasedOnStandard_ResDto getFeeInfoBasedOnStandard(String standard);
}
