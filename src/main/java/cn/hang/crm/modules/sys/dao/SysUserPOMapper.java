package cn.hang.crm.modules.sys.dao;

import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

/**
 * @author lihang
 */
@Repository
public interface SysUserPOMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUserPO record);

    int insertSelective(SysUserPO record);

    SysUserPO selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUserPO record);

    int updateByPrimaryKey(SysUserPO record);

    SysUserPO getUserByUserName(String username);

    SysUserPO queryByMobile(String username);

    Page<SysUserPO> listSysUser(SysUserPO sysUserPO);

    int deleteBatch(Long[] userId);

    int updateLoginIPAndTime(SysUserPO sysUserPO);
}