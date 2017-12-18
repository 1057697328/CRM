package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.modules.sys.dao.SysRoleMenuPOMapper;
import cn.hang.crm.modules.sys.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihang
 * @create 2017-11-04 下午4:36
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuPOMapper sysRoleMenuPOMapper;

    @Override
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        if (menuIdList.size() == 0) {
            return;
        }
        sysRoleMenuPOMapper.deleteByRoleId(roleId);
        //保存角色与菜单关系
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("menuIdList", menuIdList);
        sysRoleMenuPOMapper.saveBatch(map);
    }

    @Override
    public List<Long> queryMenuIdList(long roleId) {
        return sysRoleMenuPOMapper.queryMenuIdList(roleId);
    }
}
