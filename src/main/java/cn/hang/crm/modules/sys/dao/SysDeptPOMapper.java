package cn.hang.crm.modules.sys.dao;

import cn.hang.crm.modules.sys.entity.po.SysDeptPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysDeptPOMapper {
    int deleteByPrimaryKey(Long deptId);

    int insert(SysDeptPO record);

    int insertSelective(SysDeptPO record);

    SysDeptPO selectByPrimaryKey(Long deptId);

    int updateByPrimaryKeySelective(SysDeptPO record);

    int updateByPrimaryKey(SysDeptPO record);

    List<SysDeptPO> listSysDept(SysDeptPO sysDeptPO);

    List<SysDeptPO> listSysCompany(SysDeptPO sysDeptPO);

    List<SysDeptPO> listChildDept(SysDeptPO sysDeptPO);
}