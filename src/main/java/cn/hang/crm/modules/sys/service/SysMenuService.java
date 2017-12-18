package cn.hang.crm.modules.sys.service;

import cn.hang.crm.modules.sys.entity.po.SysMenuPO;

import java.util.List;
import java.util.Set;

/**
 * 系统菜单
 *
 * @author lihang
 * @create 2017-11-01 上午12:23
 */
public interface SysMenuService {
    /**
     * 获取用户菜单列表
     *
     * @param userId 用户id
     * @return
     */
    List<SysMenuPO> getUserMenuList(Long userId);

    /**
     * 获取用户权限集合
     *
     * @param userId 用户id
     * @return
     */
    Set<String> getUserPermissions(long userId);

    /**
     * 获取当前用户所在公司的最高菜单
     *
     * @param userId
     * @return
     */
    List<SysMenuPO> listDeptMenu(long userId);

    /**
     * 获取当前用户所在公司的最高菜单（包含button）
     *
     * @param userId
     * @return
     */
    List<SysMenuPO> listDeptMenuWithButton(long userId);

    /**
     * 新增菜单
     * @param sysMenuPO
     */
    void addMenu(SysMenuPO sysMenuPO);

    /**
     * 根据菜单id获取菜单
     *
     * @param parentId
     * @return
     */
    SysMenuPO getSysMenuById(Long parentId);

    /**
     * 修改菜单
     * @param sysMenuPO
     */
    void updateMenu(SysMenuPO sysMenuPO);

    /**
     * 删除菜单
     * @param menuId
     */
    void deleteMenu(long menuId);
}
