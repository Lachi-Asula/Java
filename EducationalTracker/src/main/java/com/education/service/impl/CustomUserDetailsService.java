package com.education.service.impl;

import com.education.dao.StaffRegDao;
import com.education.dto.Constants;
import com.education.model.StaffRegistration_Entity;
import com.education.utils.RSA.EncryptDecryptRSAUtil;
import com.education.utils.exception.UserException;
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
    private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class.getName());

    @Autowired
    private StaffRegDao staffRegDao;

    @Autowired
    private EncryptDecryptRSAUtil encDecUsingRSA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Inside CustomUserDetailsService.loadUserByUsername() ::" + username);
        String password = null;
        Optional<StaffRegistration_Entity> staffRegistrationEntity = staffRegDao.findByFldStaffId(username);
        if (staffRegistrationEntity.isPresent()) {
            password = encDecUsingRSA.decode(staffRegistrationEntity.get().getFldPassword());
        }else {
            throw new UsernameNotFoundException(Constants.userNotFound_Error);
        }

        logger.info("Exit CusotmUserDetailsService.loadUserByUsername() ::" );

        return new org.springframework.security.core.userdetails.User(username, password, new ArrayList<>());
    }
}
