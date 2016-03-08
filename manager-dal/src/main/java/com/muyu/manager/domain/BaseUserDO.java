package com.muyu.manager.domain;

import com.muyu.manager.domain.BaseDO;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2015/12/7.
 */
public class BaseUserDO extends BaseDO{
    @Setter
    @Getter
    Long userId;
    @Setter @Getter String loginName;
    @Setter @Getter String password;
}
