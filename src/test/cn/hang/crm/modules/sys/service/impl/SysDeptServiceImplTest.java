package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.modules.sys.dao.SysUserPOMapper;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import cn.hang.crm.modules.sys.service.SysDeptService;
import cn.hang.crm.modules.sys.entity.po.SysDeptPO;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lihang
 * @create 2017-11-04 下午7:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class SysDeptServiceImplTest {
    @Autowired
    private SysDeptService sysDeptService;
    @Autowired
    private SysUserPOMapper sysUserPOMapper;
    @Test
    public void listSysDept() throws Exception {
        SysUserPO sysUserPO = sysUserPOMapper.selectByPrimaryKey(1L);
        System.out.println(new Gson().toJson(sysDeptService.listSysDept(sysUserPO)));
    }

    @Test
    public void addDept() throws Exception {
        SysDeptPO sysDeptPO = new SysDeptPO();
        sysDeptPO.setParentId(4L);
        sysDeptPO.setName("公司C-人事部");
        sysDeptPO.setType(2);
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setDeptId(1L);
        System.out.println(new Gson().toJson(sysDeptService.addDept(sysUserPO, sysDeptPO)));
    }

    @Test
    public void getDeptByDeptId() throws Exception {
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setDeptId(1L);
        System.out.println(new Gson().toJson(sysDeptService.getDeptByDeptId(sysUserPO, 2L)));
    }

    @Test
    @Transactional
    public void deleteDept() throws Exception {
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setDeptId(1L);
        System.out.println(new Gson().toJson(sysDeptService.deleteDept(sysUserPO, 3L)));

    }
}