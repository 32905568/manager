package com.muyu.manager.user.impl;

import com.muyu.manager.dao.BaseUserDAO;
import com.muyu.manager.domain.BaseUserDO;
import com.muyu.manager.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maowei on 2015/11/5.
 */
@Service
public class UserServiceImpl implements UserService{
    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    BaseUserDAO<BaseUserDO, Long> baseUserDAO;

    @Override
    public boolean checkUserPassword(String loginName, String password) {
        if(StringUtils.isBlank(loginName)||StringUtils.isBlank(password)){
            return false;
        }

        BaseUserDO userDO = baseUserDAO.getByUserName(loginName);
        if(userDO != null && StringUtils.equals(password,userDO.getPassword())){
            return true;
        }

        return false;
    }
}
