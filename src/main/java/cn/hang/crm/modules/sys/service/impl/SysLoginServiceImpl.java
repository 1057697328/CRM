package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.common.entity.Result;
import cn.hang.crm.modules.sys.dao.SysUserPOMapper;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import cn.hang.crm.modules.sys.service.SysUserService;
import cn.hang.crm.modules.sys.service.SysUserTokenService;
import cn.hang.crm.modules.sys.entity.po.SysUserTokenPO;
import cn.hang.crm.modules.sys.service.SysLoginService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lihang
 * @create 2017-11-01 下午1:17
 */
@Service
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    private SysUserPOMapper sysUserPOMapper;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private SysUserService sysUserService;
    @Override
    public Result<SysUserTokenPO> login(SysUserPO sysUserPO) {
        //根据手机号码登录
        SysUserPO localUser = sysUserPOMapper.queryByMobile(sysUserPO.getUsername());
        //账号不存在
        if (localUser == null) {
            return new Result<>(-1, "账号不存在");
        }
        //密码错误
        if (!localUser.getPassword().equals(new Sha256Hash(sysUserPO.getPassword(), localUser.getSalt()).toHex())){
            return new Result<>(-1, "密码错误");
        }
        //账号被锁定
        if (localUser.getIsUsed() == 0) {
            return new Result<>(-1, "账号已被锁定,请联系管理员");
        }
        SysUserTokenPO sysUserTokenPO = sysUserTokenService.createToken(localUser.getUserId());
        localUser.setLoginDate(new Date());
        localUser.setLoginIp(sysUserPO.getLoginIp());
        sysUserService.updateLoginIPAndTime(localUser);
        return new Result<>(sysUserTokenPO);
    }
}
