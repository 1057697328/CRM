package cn.hang.crm.modules.sys.dao;

import cn.hang.crm.modules.sys.entity.po.SysMenuPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lihang
 */
@Repository
public interface SysMenuPOMapper {

    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenuPO record);

    int insertSelective(SysMenuPO record);

    SysMenuPO selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(SysMenuPO record);

    int updateByPrimaryKey(SysMenuPO record);

    /**
     * 获取单个用户菜单列表（不包含按钮）
     *
     * @param userId
     * @return
     */
    List<SysMenuPO> listUserMenu(Long userId);

    /**
     * 获取单个用户权限列表
     *
     * @param userId
     * @return
     */
    List<String> listUserPermission(long userId);

    /**
     * 获取所有菜单
     *
     * @return
     */
    List<SysMenuPO> listAllMenu();

    /**
     * 获取所有权限
     *
     * @return
     */
    List<String> listAllPermission();
}