package com.muyu.manager.dao;

import com.muyu.manager.domain.BaseUserDO;

/**
 * Created by Administrator on 2015/12/6.
 */
public interface BaseUserDAO<T,ID extends Long> extends BaseDAO<T,ID>{
    public BaseUserDO getByUserName(String userName);
}
