package cn.hang.crm.modules.sys.service;

import cn.hang.crm.modules.sys.entity.po.SysUserTokenPO;

/**
 * @author lihang
 * @create 2017-11-01 下午1:35
 */
public interface SysUserTokenService {
    /**
     * 生成用户token
     *
     * @param userId
     * @return
     */
    SysUserTokenPO createToken(long userId);

    /**
     * 根据用户id获取用户token
     *
     * @param userId
     * @return
     */
    SysUserTokenPO getTokenByUserId(long userId);

    /**
     * 根据token值获取用户token
     *
     * @param token
     * @return
     */
    SysUserTokenPO getTokenByToken(String token);


}
