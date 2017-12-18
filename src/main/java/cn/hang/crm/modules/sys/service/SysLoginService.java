package cn.hang.crm.modules.sys.service;

import cn.hang.crm.common.entity.Result;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import cn.hang.crm.modules.sys.entity.po.SysUserTokenPO;

/**
 * 后台登录相关
 *
 * @author lihang
 * @create 2017-11-01 下午1:11
 */
public interface SysLoginService {
    /**
     * 登录验证
     *
     * @param sysUserPO 用户名和密码
     * @return
     */
    Result<SysUserTokenPO> login(SysUserPO sysUserPO);
}
