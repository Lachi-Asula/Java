package com.education.service;

import com.education.dto.CommonResponseDto;
import com.education.dto.GenerateTokenReqDto;
import com.education.dto.UserIdReqDto;
import com.education.dto.UserIdResDto;

public interface UserInfo {

    UserIdResDto getUserInfo(UserIdReqDto userIdReqDto);

    CommonResponseDto getUserStatus(GenerateTokenReqDto generateTokenReqDto);

}
