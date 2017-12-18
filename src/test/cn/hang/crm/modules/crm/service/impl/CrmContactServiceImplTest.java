package cn.hang.crm.modules.crm.service.impl;

import cn.hang.crm.common.entity.PageInfoDTO;
import cn.hang.crm.modules.crm.entity.po.CrmContactPO;
import cn.hang.crm.modules.crm.service.CrmContactService;
import cn.hang.crm.modules.sys.entity.po.SysRolePO;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihang
 * @create 2017-11-25 下午3:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class CrmContactServiceImplTest {
    @Autowired
    private CrmContactService crmContactService;

    @Test
    public void addContact() throws Exception {
    }

    @Test
    public void updateContact() throws Exception {
    }

    @Test
    public void getContactByContactId() throws Exception {
        System.out.println(crmContactService.getContactByContactId(1L));
    }

    @Test
    public void getUserContactList() throws Exception {
        SysUserPO loginUser = new SysUserPO();
        loginUser.setDeptId(2L);
        loginUser.setCompanyId(1L);
        loginUser.setUserId(1L);

        List<SysRolePO> list = new ArrayList<>();
        SysRolePO sysRolePO = new SysRolePO();
        sysRolePO.setRoleId(1L);
        sysRolePO.setDataScope("2");
        list.add(sysRolePO);
        loginUser.setRoleList(list);

        CrmContactPO crmContactPO = new CrmContactPO();
        PageInfoDTO pageInfoDTO = new PageInfoDTO();
        pageInfoDTO.setPageNum(1);
        pageInfoDTO.setPageSize(10);
        crmContactPO.setPage(pageInfoDTO);
        System.out.println(crmContactService.getUserContactList(loginUser, crmContactPO, 2));
    }

    @Test
    public void deleteContactBatch() throws Exception {
        crmContactService.deleteContactBatch(new Long[]{1L});
    }

}