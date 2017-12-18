package cn.hang.crm.modules.sys.dao;

import cn.hang.crm.modules.sys.entity.po.SysUserRolePO;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface SysUserRolePOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRolePO record);

    int insertSelective(SysUserRolePO record);

    SysUserRolePO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRolePO record);

    int updateByPrimaryKey(SysUserRolePO record);

    int deleteByUserId(long userId);

    int insertBatch(Map<String, Object> map);

}