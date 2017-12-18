package cn.hang.crm.modules.sys.service;

import java.util.List;

/**
 * @author lihang
 * @create 2017-11-01 下午1:59
 */
public interface SysUserRoleService {
    /**
     * 新增或者更新用户角色关系
     *
     * @param userId
     * @param roleIdList
     * @return
     */
    int insertOrUpdate(long userId, List<Long> roleIdList);



}
