package cn.hang.crm.modules.sys.service;

import cn.hang.crm.common.entity.R;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;

import java.util.List;

/**
 * @author lihang
 * @create 2017-11-08 下午4:28
 */
public interface SysRoleDeptService {
    /**
     * 新增或修改角色和机构关系
     * @param roleId
     * @param deptIdList
     */
    void saveOrUpdate(Long roleId, List<Long> deptIdList);

    /**
     * 根据机构id查询所有角色
     * @param sysUserPO
     * @return
     */
    R listSysRoleByUserDept(SysUserPO loginUser, SysUserPO sysUserPO);
}
