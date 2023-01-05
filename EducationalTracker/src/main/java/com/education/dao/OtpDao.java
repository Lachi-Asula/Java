package com.education.dao;

import com.education.model.Otp_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface OtpDao extends JpaRepository<Otp_Entity, Integer> {

    @Query(value = "select OTPIDVAL.nextval from dual", nativeQuery = true)
    int getOtpIdVal();

    Optional<Otp_Entity> findByFldUserId(String userId);

    @Transactional
    @Modifying
    @Query("update Otp_Entity set fldOtpValue =:otpValue where fldUserId =:userId")
    void updateOtpValueByUserId(String userId, String otpValue);

    Optional<Otp_Entity> findByFldUserIdAndFldOtpValue(String userId, String otpValue);
}
