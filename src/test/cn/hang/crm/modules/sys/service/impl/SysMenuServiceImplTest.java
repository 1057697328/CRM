package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.modules.sys.service.SysMenuService;
import cn.hang.crm.modules.sys.entity.po.SysMenuPO;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lihang
 * @create 2017-11-01 上午12:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class SysMenuServiceImplTest {
    @Autowired
    private SysMenuService sysMenuService;

    @Test
    public void getUserMenuList() throws Exception {
        System.out.println(new Gson().toJson(sysMenuService.getUserMenuList(1L)));
    }
    @Test
    public void getUserPermissions() throws Exception {
        System.out.println(new Gson().toJson(sysMenuService.getUserPermissions(1L)));
    }

    @Test
    public void listDeptMenu() throws Exception {
        System.out.println(new Gson().toJson(sysMenuService.listDeptMenu(66L)));
    }

    @Test
    public void listDeptMenuWithButton() throws Exception {
        System.out.println(new Gson().toJson(sysMenuService.listDeptMenuWithButton(66L)));
    }

    @Test
    public void getSysMenuById() throws Exception {
        Assert.assertNotNull(sysMenuService.getSysMenuById(66L));
    }
    @Test
    @Transactional
    @Rollback(true)
    public void updateMenu() throws Exception {
        SysMenuPO sysMenuPO = new SysMenuPO();
        sysMenuPO.setMenuId(1L);
        sysMenuPO.setName("系统管理1");
        sysMenuService.updateMenu(sysMenuPO);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void addMenu() throws Exception {
        SysMenuPO sysMenuPO = new SysMenuPO();
        sysMenuPO.setMenuId(1L);
        sysMenuService.addMenu(sysMenuPO);
    }


}