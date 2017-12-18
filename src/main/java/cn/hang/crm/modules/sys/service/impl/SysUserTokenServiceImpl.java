package cn.hang.crm.modules.sys.service.impl;

import cn.hang.crm.modules.sys.oauth2.TokenGenerator;
import cn.hang.crm.modules.sys.dao.SysUserTokenPOMapper;
import cn.hang.crm.modules.sys.entity.po.SysUserTokenPO;
import cn.hang.crm.modules.sys.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lihang
 * @create 2017-11-01 下午1:37
 */
@Service
public class SysUserTokenServiceImpl implements SysUserTokenService {

    @Autowired
    private SysUserTokenPOMapper sysUserTokenPOMapper;
    /**
     * 12小时后过期
     */
    private final static int EXPIRE = 3600 * 12;

    @Override
    public SysUserTokenPO createToken(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        SysUserTokenPO userToken = getTokenByUserId(userId);
        if (userToken == null) {
            //新建token
            userToken = new SysUserTokenPO();
            userToken.setUserId(userId);
            userToken.setExpireTime(expireTime);
            userToken.setToken(token);
            userToken.setGmtUpdate(now);
            sysUserTokenPOMapper.insertSelective(userToken);
        } else {
            //更新token
            userToken.setToken(token);
            userToken.setGmtUpdate(now);
            userToken.setExpireTime(expireTime);
            sysUserTokenPOMapper.updateByPrimaryKeySelective(userToken);
        }
        return userToken;
    }

    @Override
    public SysUserTokenPO getTokenByUserId(long userId) {
        return sysUserTokenPOMapper.selectByPrimaryKey(userId);
    }

    @Override
    public SysUserTokenPO getTokenByToken(String token) {
        return sysUserTokenPOMapper.getTokenByToken(token);
    }
}
