package cn.hang.crm.common.client.sms;

/**
 * Created by trons on 16-7-25.
 * TIME: 下午8:31
 */
public interface SMSClient {
    /**
     * 给单个用户发短信
     * @param mobile 手机号码
     * @param templateCode templateCode 例如：SMS_13776105
     * @param paramString 模板变量值
     * @return
     */
    boolean sendSMSToUser(String mobile, String templateCode, String paramString);
}
