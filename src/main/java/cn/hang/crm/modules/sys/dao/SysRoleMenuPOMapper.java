package cn.hang.crm.modules.sys.dao;

import cn.hang.crm.modules.sys.entity.po.SysRoleMenuPO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysRoleMenuPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenuPO record);

    int insertSelective(SysRoleMenuPO record);

    SysRoleMenuPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenuPO record);

    int updateByPrimaryKey(SysRoleMenuPO record);

    void saveBatch(Map<String, Object> map);

    void deleteByRoleId(Long roleId);

    List<Long> queryMenuIdList(long roleId);
}