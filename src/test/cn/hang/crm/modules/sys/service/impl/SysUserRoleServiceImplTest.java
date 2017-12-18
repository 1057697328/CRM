package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.modules.sys.service.SysUserRoleService;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lihang
 * @create 2017-11-02 下午5:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class SysUserRoleServiceImplTest {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Test
    public void listSysRoleByUserDept() throws Exception {
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setDeptId(1L);
//        sysUserRoleService.listSysRoleByUserDept(sysUserPO, 1);
    }

}