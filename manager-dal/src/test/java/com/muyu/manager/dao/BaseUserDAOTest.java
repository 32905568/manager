package com.muyu.manager.dao;
import com.muyu.manager.dao.test.BaseTest;
import com.muyu.manager.domain.BaseUserDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Created by Administrator on 2015/12/7.
 */
public class BaseUserDAOTest extends BaseTest {
    @Autowired
    BaseUserDAO<BaseUserDO, Long> baseUserDAO;

    @Test
    public void test_user() {
        BaseUserDO userDO1 = baseUserDAO.getById(1L);
        Assert.notNull(userDO1);
        BaseUserDO userDO = new BaseUserDO();
        userDO.setLoginName("muyu.myw");
        userDO.setPassword("123456");
        Long id = baseUserDAO.save(userDO);
        Assert.isTrue(id != null);
    }
}
