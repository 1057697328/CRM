package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.common.entity.PageInfoDTO;
import cn.hang.crm.modules.sys.entity.po.SysRolePO;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import cn.hang.crm.modules.sys.service.SysUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * @author lihang
 * @create 2017-11-01 下午2:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class SysUserServiceImplTest {
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void createUser() throws Exception {
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setUsername("admin");
        sysUserPO.setPassword("admin");
        sysUserPO.setMobile("22");
        sysUserPO.setDeptId(6L);
        sysUserPO.setCompanyId(5L);
        sysUserPO.setRoleIdList(Collections.singletonList(4L));
        SysUserPO loginUser = new SysUserPO();
        loginUser.setUserId(1L);
        loginUser.setDeptId(6L);
        loginUser.setCompanyId(5L);
        Assert.assertEquals(0,(int)(sysUserService.createUser(loginUser,sysUserPO).get("status")));
    }

    @Test
    public void listUser() throws Exception {
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setDeptId(2L);
//        sysUserPO.setCompanyId(1L);

        SysUserPO loginUser = new SysUserPO();
        loginUser.setDeptId(2L);
        loginUser.setCompanyId(1L);
        loginUser.setUserId(2L);

        List<SysRolePO> list = new ArrayList<>();
        SysRolePO sysRolePO = new SysRolePO();
        sysRolePO.setRoleId(1L);
        sysRolePO.setDataScope("1");
        list.add(sysRolePO);
        loginUser.setRoleList(list);

        PageInfoDTO pageInfoDTO = new PageInfoDTO();
        pageInfoDTO.setPageNum(1);
        pageInfoDTO.setPageSize(10);
        sysUserPO.setPage(pageInfoDTO);
        System.out.println(sysUserService.listUser(loginUser, sysUserPO));
    }

    @Test
    public void getUserByUserId() throws Exception {
        System.out.println(sysUserService.getUserByUserId(1L));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteUser() throws Exception {
        System.out.println(sysUserService.deleteUser(new Long[]{66L,1L}));
    }

    @Test
    @Transactional
    public void updateUser() throws Exception {
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setDeptId(2L);
        sysUserPO.setUsername("李航");
        sysUserPO.setUserId(66L);
        System.out.println(sysUserService.updateUser(sysUserPO));
    }
}