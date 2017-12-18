package cn.hang.crm.modules.sys.service;


import cn.hang.crm.common.entity.R;
import cn.hang.crm.common.entity.Result;
import cn.hang.crm.modules.sys.entity.po.SysRolePO;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;

/**
 * @author lihang
 * @create 2017-11-01 下午1:59
 */
public interface SysRoleService {
    /**
     * 添加角色
     *
     * @param loginUser 当前登录用户
     * @param sysRolePO 角色信息
     */
    void addRole(SysUserPO loginUser, SysRolePO sysRolePO);

    /**
     * 删除角色
     *
     * @param roleId
     */
    void deleteRole(long roleId);

    /**
     * 修改角色
     *
     * @param loginUser 当前登录用户
     * @param sysRolePO
     */
    R updateRole(SysUserPO loginUser, SysRolePO sysRolePO);

    /**
     * 获取单个角色信息
     *
     * @param roleId
     * @return
     */
    Result<SysRolePO> getRole(long roleId);

}
