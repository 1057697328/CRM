package cn.hang.crm.common.client.qiniu;


import cn.hang.crm.common.client.qiniu.impl.DefaultQiniuClient;

/**
 * Created by trons on 16-7-26.
 * TIME: 下午8:06
 */
public class QiniuClientFatory {
    public static QiniuClient qiniuClient;

    static {
        qiniuClient = new DefaultQiniuClient();
    }

    public static QiniuClient getQiniuClient(){
        return qiniuClient;
    }

}
