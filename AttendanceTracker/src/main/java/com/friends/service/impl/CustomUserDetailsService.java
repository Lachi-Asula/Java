package com.friends.service.impl;

import com.friends.dao.Emp_Info_Dao;
import com.friends.dao.Staff_Info_Dao;
import com.friends.dto.Constants;
import com.friends.model.Emp_Info_Entity;
import com.friends.model.Staff_Info_Entity;
import com.friends.utils.BeanUtilsDemo;
import com.friends.utils.encryption.EncryptDecryptRSAUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final static Logger logger = Logger.getLogger(CustomUserDetailsService.class.getName());

    @Autowired
    private Staff_Info_Dao staffInfoDao;

    @Autowired
    private BeanUtilsDemo beanUtils;

    @Autowired
    private Emp_Info_Dao empInfoDao;

    @Autowired
    private EncryptDecryptRSAUtil encDecUsingRSA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Inside CustomUserDetailsService.loadUserByUsername() ::" + username);
        String password = null;
        Optional<Emp_Info_Entity> empInfoEntity = Optional.empty();
        Optional<Staff_Info_Entity> staffInfoEntity = Optional.empty();
        if(StringUtils.isNotBlank(username) && username.startsWith(Constants.idStart)){
            empInfoEntity = empInfoDao.findByFldEmpId(username);
        }else {
            staffInfoEntity = staffInfoDao.findByFldEmpId(username);
        }
        if (staffInfoEntity.isPresent()) {
            password = encDecUsingRSA.decode(staffInfoEntity.get().getFldPassword());
        }else if(empInfoEntity.isPresent()){
            password = encDecUsingRSA.decode(empInfoEntity.get().getFldPassword());
        } else {
            throw new UsernameNotFoundException("User not Found, Invalid Employee Id or Password");
        }
        logger.info("Exit CusotmUserDetailsService.loadUserByUsername() ::" );

        return new org.springframework.security.core.userdetails.User(username, password, new ArrayList<>());
    }
}
