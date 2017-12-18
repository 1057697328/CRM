package cn.hang.crm.common.client.sms;


import cn.hang.crm.common.client.sms.impl.DefaultSMSClient;

/**
 * Created by trons on 16-7-25.
 * TIME: 下午8:52
 */
public class SMSClientFactory {

    public SMSClientFactory() {
    }

    private static SMSClient SMSClient;

    static {
        SMSClient = new DefaultSMSClient();
    }


    public static SMSClient getSMSClient() {
        return SMSClient;
    }
}
