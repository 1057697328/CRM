package cn.hang.crm.modules.sys.dao;

import cn.hang.crm.modules.sys.entity.po.SysRoleDeptPO;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface SysRoleDeptPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDeptPO record);

    int insertSelective(SysRoleDeptPO record);

    SysRoleDeptPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleDeptPO record);

    int updateByPrimaryKey(SysRoleDeptPO record);

    void deleteByRoleId(Long roleId);

    void saveBatch(Map<String, Object> map);
}