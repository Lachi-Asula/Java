package com.friends.service.impl;

import com.friends.dao.Staff_Info_Dao;
import com.friends.model.Staff_Info_Entity;
import com.friends.utils.BeanUtilsDemo;
import com.friends.utils.encryption.EncryptDecryptRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CusotmUserDetailsService implements UserDetailsService {
    private final static Logger logger = Logger.getLogger(CusotmUserDetailsService.class.getName());

    @Autowired
    private Staff_Info_Dao staffInfoDao;

    @Autowired
    private BeanUtilsDemo beanUtils;

    @Autowired
    private EncryptDecryptRSAUtil encDecUsingRSA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Inside CusotmUserDetailsService.loadUserByUsername() ::" + username);
        Optional<Staff_Info_Entity> staffInfoEntity = staffInfoDao.findByFldEmpId(username);
        Staff_Info_Entity staffInfo = null;
        String password = null;
        if (staffInfoEntity.isPresent()) {
            staffInfo = staffInfoEntity.get();
            password = encDecUsingRSA.decode(staffInfo.getFldPassword());
            staffInfo.setFldPassword(password);
        }else {
            throw new UsernameNotFoundException("Invalid UserName and Password");
        }
        logger.info("Exit CusotmUserDetailsService.loadUserByUsername() ::" + staffInfo.toString());
        return new org.springframework.security.core.userdetails.User(staffInfo.getFldEmpId(), staffInfo.getFldPassword(), new ArrayList<>());
    }
}
