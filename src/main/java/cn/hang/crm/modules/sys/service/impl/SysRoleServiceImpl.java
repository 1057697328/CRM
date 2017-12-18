package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.common.entity.R;
import cn.hang.crm.common.entity.Result;
import cn.hang.crm.modules.sys.dao.SysRolePOMapper;
import cn.hang.crm.modules.sys.service.SysRoleMenuService;
import cn.hang.crm.modules.sys.service.SysRoleService;
import cn.hang.crm.modules.sys.entity.po.SysRolePO;

import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import cn.hang.crm.modules.sys.service.SysRoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lihang
 * @create 2017-11-04 下午2:26
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRolePOMapper sysRolePOMapper;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRole(SysUserPO loginUser, SysRolePO sysRolePO) {
        sysRolePOMapper.insertSelective(sysRolePO);
        if (SysRolePO.DATA_SCOPE_CUSTOM.equals(sysRolePO.getDataScope())) {
            sysRoleDeptService.saveOrUpdate(sysRolePO.getRoleId(), sysRolePO.getDeptIdList());
        }
        sysRoleMenuService.saveOrUpdate(sysRolePO.getRoleId(), sysRolePO.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRole(long roleId) {
        sysRolePOMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R updateRole(SysUserPO loginUser, SysRolePO sysRolePO) {
        sysRolePOMapper.updateByPrimaryKeySelective(sysRolePO);
        if (SysRolePO.DATA_SCOPE_CUSTOM.equals(sysRolePO.getDataScope())) {
            sysRoleDeptService.saveOrUpdate(sysRolePO.getRoleId(), sysRolePO.getDeptIdList());
        }
        sysRoleMenuService.saveOrUpdate(sysRolePO.getRoleId(), sysRolePO.getMenuIdList());
        return R.ok();
    }

    @Override
    public Result<SysRolePO> getRole(long roleId) {
        SysRolePO sysRolePO = sysRolePOMapper.selectByPrimaryKey(roleId);
        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        sysRolePO.setMenuIdList(menuIdList);
        return new Result<>(sysRolePO);
    }
}
