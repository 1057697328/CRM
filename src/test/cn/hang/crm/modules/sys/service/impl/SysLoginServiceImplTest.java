package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import cn.hang.crm.modules.sys.service.SysLoginService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lihang
 * @create 2017-11-01 下午2:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class SysLoginServiceImplTest {
    @Autowired
    private SysLoginService sysLoginService;

    @Test
    @Transactional
    public void login() throws Exception {
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setUsername("11");
        sysUserPO.setPassword("admin");
        Assert.assertEquals(0,(int)(sysLoginService.login(sysUserPO).getStatus()));
    }
}