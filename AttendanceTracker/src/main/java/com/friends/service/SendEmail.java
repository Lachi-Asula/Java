package com.friends.service;

import com.friends.dto.CommonResponse;
import com.friends.dto.EmailDto;

public interface SendEmail {

    CommonResponse sendOtpOnEmail(EmailDto emailDto);
}
