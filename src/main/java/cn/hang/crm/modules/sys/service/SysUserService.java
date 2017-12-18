package cn.hang.crm.modules.sys.service;

import cn.hang.crm.common.entity.R;
import cn.hang.crm.common.entity.Result;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import com.github.pagehelper.PageInfo;

/**
 * 系统用户管理
 *
 * @author lihang
 * @create 2017-11-01 下午1:49
 */
public interface SysUserService {
    /**
     * 新增用户
     *
     * @param loginUser 当前登录用户
     * @param sysUserPO 新增用户信息
     * @return
     */
    R createUser(SysUserPO loginUser, SysUserPO sysUserPO);

    /**
     * 查看用户列表
     *
     * @return
     */
    Result<PageInfo<SysUserPO>> listUser(SysUserPO loginUser, SysUserPO sysUserPO);

    /**
     * 根据用户id获取单个用户
     *
     * @param userId
     * @return
     */
    Result<SysUserPO> getUserByUserId(long userId);

    /**
     * 更新用户信息
     *
     * @param sysUserPO 新增用户信息
     * @return
     */
    R updateUser(SysUserPO sysUserPO);

    /**
     * 删除用户
     *
     * @return
     */
    R deleteUser(Long[] userId);

    void updateLoginIPAndTime(SysUserPO sysUserPO);

}
