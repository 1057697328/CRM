package cn.hang.crm.modules.sys.service;

import cn.hang.crm.common.entity.R;
import cn.hang.crm.common.entity.Result;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import cn.hang.crm.modules.sys.entity.po.SysDeptPO;

import java.util.List;

/**
 * 部门
 *
 * @author lihang
 * @create 2017-11-04 下午3:07
 */
public interface SysDeptService {
    /**
     * 获取系统部门
     *
     * @param loginUser
     * @return
     */
    List<SysDeptPO> listSysDept(SysUserPO loginUser);

    /**
     * 获取系统公司
     *
     * @param loginUser
     * @return
     */
    List<SysDeptPO> listSysCompany(SysUserPO loginUser);

    /**
     * 增加系统部门
     * @param loginUser
     * @param sysDeptPO
     * @return
     */
    R addDept(SysUserPO loginUser, SysDeptPO sysDeptPO);

    /**
     * 删除系统部门
     * @param loginUser
     * @param deptId
     * @return
     */
    R deleteDept(SysUserPO loginUser, long deptId);

    /**
     * 根据id获取单个部门信息
     * @param loginUser
     * @param deptId
     * @return
     */
    Result<SysDeptPO> getDeptByDeptId(SysUserPO loginUser, long deptId);

    /**
     * 修改系统部门
     * @param loginUser
     * @param sysDeptPO
     * @return
     */
    R updateDept(SysUserPO loginUser, SysDeptPO sysDeptPO);



}
