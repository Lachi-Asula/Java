package com.friends.service;

import com.friends.dto.Emp_Info_Dto;
import com.friends.dto.GetEmpInfo_BasedOn_BatchNum;

import java.util.List;

public interface GetBatch_Info {

    GetEmpInfo_BasedOn_BatchNum getEmpInfoBasedOnBatchNum(String batchNum);
}
