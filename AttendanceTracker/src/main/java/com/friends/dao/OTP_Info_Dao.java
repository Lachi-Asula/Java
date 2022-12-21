package com.friends.dao;

import com.friends.model.Otp_Info_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface OTP_Info_Dao extends JpaRepository<Otp_Info_Entity, Integer> {

    Optional<Otp_Info_Entity> findByFldEmpId(String empId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TBL_AUDIT_OTP_INFO SET FLD_OTP_VALUE = :otpValue where FLD_EMP_ID = :empId",  nativeQuery = true)
    Integer updateFldOtpValueByFldEmpId(String otpValue, String empId);

    @Query(value = "select FLD_OTP_VALUE from TBL_AUDIT_OTP_INFO where FLD_EMP_ID =:empId",  nativeQuery = true)
    Optional<String> getOtpValueByEmpId(String empId);
}
