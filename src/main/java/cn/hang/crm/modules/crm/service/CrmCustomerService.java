package cn.hang.crm.modules.crm.service;

import cn.hang.crm.common.entity.R;
import cn.hang.crm.common.entity.Result;
import cn.hang.crm.modules.crm.entity.po.CrmCustomer;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import com.github.pagehelper.PageInfo;

/**
 * Created by Cesare on 2017/11/19.
 */
public interface CrmCustomerService {

    /**
     * 新增客户
     * @param loginUser
     * @param crmCustomer
     * @return
     */
    R addCustomer(SysUserPO loginUser, CrmCustomer crmCustomer);


    /**
     * 修改客户
     * @param loginUser
     * @param crmCustomer
     * @return
     */
    R updateCustomer(SysUserPO loginUser, CrmCustomer crmCustomer);

    /**
     * 根据客户id获取单个客户详情
     *
     * @param customerId
     * @return
     */
    Result<CrmCustomer> getCustomerByCustomerId(long customerId);

    /**
     * 获取用户客户列表
     *
     * @param loginUser 当前登录用户
     * @param type 筛选类型，1为用户负责的客户，2为用户数据权限上包含的客户
     * @return
     */
    Result<PageInfo<CrmCustomer>> getUserCustomerList(SysUserPO loginUser,CrmCustomer crmCustomer, int type);

    /**
     * 批量删除客户
     *
     * @return
     */
    R deleteCustomerBatch(Long[] ids);

}
