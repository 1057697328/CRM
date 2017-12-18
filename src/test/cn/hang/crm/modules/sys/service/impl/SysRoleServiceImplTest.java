package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.modules.sys.service.SysRoleService;
import cn.hang.crm.modules.sys.entity.po.SysRolePO;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihang
 * @create 2017-11-04 下午4:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class SysRoleServiceImplTest {
    @Autowired
    private SysRoleService sysRoleService;

    @Test
    @Transactional
    @Rollback(true)
    public void addRole() throws Exception {
        SysRolePO sysRolePO = new SysRolePO();
        sysRolePO.setRoleName("hah");
        List<Long> menuIdList = new ArrayList<>();
        menuIdList.add(1L);
        sysRolePO.setMenuIdList(menuIdList);
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setDeptId(1L);
        sysRoleService.addRole(sysUserPO, sysRolePO);
    }

    @Test
    public void deleteRole() throws Exception {
    }

    @Test
    public void updateRole() throws Exception {
    }

    @Test
    public void getRole() throws Exception {
        System.out.println(sysRoleService.getRole(1));
    }
}