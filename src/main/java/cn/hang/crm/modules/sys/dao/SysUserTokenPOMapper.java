package cn.hang.crm.modules.sys.dao;

import cn.hang.crm.modules.sys.entity.po.SysUserTokenPO;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserTokenPOMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUserTokenPO record);

    int insertSelective(SysUserTokenPO record);

    SysUserTokenPO selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUserTokenPO record);

    int updateByPrimaryKey(SysUserTokenPO record);

    SysUserTokenPO getTokenByToken(String token);
}