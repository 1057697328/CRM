package cn.hang.crm.modules.sys.dao;

import cn.hang.crm.modules.sys.entity.po.SysRolePO;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRolePOMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(SysRolePO record);

    int insertSelective(SysRolePO record);

    SysRolePO selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(SysRolePO record);

    int updateByPrimaryKey(SysRolePO record);

    List<SysRolePO> listSysRoleByUserDept(SysUserPO sysUserPO);

    List<SysRolePO> listAllRole();
}