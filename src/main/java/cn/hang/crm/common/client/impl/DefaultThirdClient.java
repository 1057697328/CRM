package cn.hang.crm.common.client.impl;


import cn.hang.crm.common.client.ThirdClient;
import cn.hang.crm.common.client.qiniu.QiniuClient;
import cn.hang.crm.common.client.qiniu.QiniuClientFatory;
import cn.hang.crm.common.client.sms.SMSClient;
import cn.hang.crm.common.client.sms.SMSClientFactory;
import org.springframework.stereotype.Component;

/**
 * @author lihang
 * @create 2017-10-30 下午7:25
 */
@Component("thirdClient")
public class DefaultThirdClient implements ThirdClient {

    private static final SMSClient SMS_CLIENT = SMSClientFactory.getSMSClient();
    private static final QiniuClient QINIU_CLIENT = QiniuClientFatory.getQiniuClient();


    @Override
    public boolean sendVerifyCode(String mobile, String verifyCode) {
        String paramStr = "{\"code\":\"" + verifyCode + "\"}";
        return SMS_CLIENT.sendSMSToUser(mobile, "SMS_13776105", paramStr);
    }

    @Override
    public String getUpToken() {
        return QINIU_CLIENT.getUpToken();
    }

    @Override
    public String getImgUrl(String imgName) {
        return QINIU_CLIENT.getImgUrl(imgName);
    }
}
