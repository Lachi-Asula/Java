package com.education.dao;

import com.education.model.UserStatus_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
public interface UserStatusDao extends JpaRepository<UserStatus_Entity, Integer> {

    Optional<UserStatus_Entity> findByFldUserId(String userId);

    @Transactional
    @Modifying
    @Query("UPDATE UserStatus_Entity set fldBlockedTime =:blockedTime where fldUserId =:userId")
    void updateBlockedTimeByUserId(Date blockedTime, String userId);

    @Transactional
    @Modifying
    @Query("UPDATE UserStatus_Entity set fldTempCount =:count where fldUserId =:userId")
    void updateTempCountByUserId(int count, String userId);

    @Transactional
    @Modifying
    @Query("UPDATE UserStatus_Entity set fldPermCount =:count where fldUserId =:userId")
    void updatePermCountByUserId(int count, String userId);

    @Transactional
    @Modifying
    @Query("UPDATE UserStatus_Entity set fldBlockedTime =:blockedTime , fldPermCount =:permCount, fldTempCount =:tempCount where fldUserId =:userId")
    void updatePermCountAndTempCountByUserId(Date blockedTime, int permCount, int tempCount, String userId);

}
