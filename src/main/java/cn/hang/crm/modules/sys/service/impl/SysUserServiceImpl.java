package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.common.entity.R;
import cn.hang.crm.common.entity.Result;
import cn.hang.crm.common.service.BaseService;
import cn.hang.crm.common.utils.ShiroUtils;
import cn.hang.crm.modules.sys.dao.SysUserPOMapper;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import cn.hang.crm.modules.sys.service.SysUserRoleService;
import cn.hang.crm.modules.sys.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author lihang
 * @create 2017-11-01 下午1:51
 */
@Service
public class SysUserServiceImpl extends BaseService implements SysUserService {

    @Autowired
    private SysUserPOMapper sysUserPOMapper;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R createUser(SysUserPO loginUser, SysUserPO sysUserPO) {
        SysUserPO localUser = sysUserPOMapper.queryByMobile(sysUserPO.getMobile());
        if (localUser != null) {
            return R.error("该手机号已存在");
        }
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        sysUserPO.setPassword(new Sha256Hash(sysUserPO.getPassword(), salt).toHex());
        sysUserPO.setSalt(salt);
        sysUserPO.setCreateBy(loginUser.getUserId());
        sysUserPOMapper.insertSelective(sysUserPO);
        sysUserRoleService.insertOrUpdate(sysUserPO.getUserId(), sysUserPO.getRoleIdList());
        return R.ok();
    }

    @Override
    public Result<PageInfo<SysUserPO>> listUser(SysUserPO loginUser, SysUserPO sysUserPO) {
        sysUserPO.getSqlMap().put("dsf", dataScopeFilter(loginUser, "d", "u"));
        PageHelper.startPage(sysUserPO.getPage().getPageNum(), sysUserPO.getPage().getPageSize());
        Page<SysUserPO> sysUserPOList = sysUserPOMapper.listSysUser(sysUserPO);
        return new Result<>(new PageInfo<>(sysUserPOList));
    }

    @Override
    public Result<SysUserPO> getUserByUserId(long userId) {
        return new Result<>(sysUserPOMapper.selectByPrimaryKey(userId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R updateUser(SysUserPO sysUserPO) {
        SysUserPO localUser = sysUserPOMapper.selectByPrimaryKey(sysUserPO.getUserId());
        if (StringUtils.isNotBlank(sysUserPO.getUsername())) {
            localUser.setUsername(sysUserPO.getUsername());
        }
        if (StringUtils.isNotBlank(sysUserPO.getEmail())) {
            localUser.setEmail(sysUserPO.getEmail());
        }
        if (StringUtils.isNotBlank(sysUserPO.getAvatar())) {
            localUser.setAvatar(sysUserPO.getAvatar());
        }
        if (sysUserPO.getDeptId() != null) {
            localUser.setDeptId(sysUserPO.getDeptId());
        }
        if (sysUserPO.getCompanyId() != null) {
            localUser.setCompanyId(sysUserPO.getCompanyId());
        }
        if (sysUserPO.getIsUsed() != null) {
            localUser.setIsUsed(sysUserPO.getIsUsed());
        }
        localUser.setUpdateBy(ShiroUtils.getCurrentUser().getUserId());
        sysUserRoleService.insertOrUpdate(sysUserPO.getUserId(), sysUserPO.getRoleIdList());
        sysUserPOMapper.updateByPrimaryKeySelective(localUser);
        return R.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R deleteUser(Long[] userId) {
        List<Long> userIdList = Arrays.asList(userId);
        if (userIdList.contains(1L)) {
            return R.error("超级管理员不能被删除");
        }
        sysUserPOMapper.deleteBatch(userId);
        return R.ok();
    }

    @Override
    public void updateLoginIPAndTime(SysUserPO sysUserPO) {
        sysUserPOMapper.updateLoginIPAndTime(sysUserPO);
    }
}
