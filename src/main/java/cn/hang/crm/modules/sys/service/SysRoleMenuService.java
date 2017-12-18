package cn.hang.crm.modules.sys.service;

import java.util.List;

/**
 * @author lihang
 * @create 2017-11-04 下午4:35
 */
public interface SysRoleMenuService {
    /**
     * 新增或修改角色和菜单关系
     * @param roleId
     * @param menuIdList
     */
    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    /**
     * 根据角色id查询菜单id列表
     * @param roleId
     * @return
     */
    List<Long> queryMenuIdList(long roleId);
}
