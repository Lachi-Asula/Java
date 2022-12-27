package com.friends.service;

import com.friends.dto.CommonResponse;
import com.friends.dto.UpdateEmailIdReqDto;
import com.friends.dto.UpdateEmailIdResDto;

public interface UpdateEmailId {

    UpdateEmailIdResDto updateEmailId(UpdateEmailIdReqDto updateEmailIdReqDto);
}
