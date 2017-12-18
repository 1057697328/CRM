package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import cn.hang.crm.modules.sys.service.SysRoleDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lihang
 * @create 2017-11-14 下午10:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class SysRoleDeptServiceImplTest {
    @Autowired
    private SysRoleDeptService sysRoleDeptService;
    @Test
    public void saveOrUpdate() throws Exception {
    }

    @Test
    public void listSysRoleByUserDept() throws Exception {
        SysUserPO sysUserPO = new SysUserPO();
//        sysUserPO.setDeptId(2L);
        sysUserPO.setCompanyId(1L);
        System.out.println(sysRoleDeptService.listSysRoleByUserDept(new SysUserPO(),sysUserPO));;
    }

}