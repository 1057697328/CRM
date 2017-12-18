package cn.hang.crm.common.client;

import java.util.List;

/**
 * @author lihang
 * @create 2017-10-30 下午7:22
 */
public interface ThirdClient {
    /**
     * 发送验证码
     * @param mobile 手机号
     * @param verifyCode 验证码
     * @return true false
     */
    boolean sendVerifyCode(String mobile, String verifyCode);


    /**
     * 获取七牛上传token
     * @return 上传token
     */
    String getUpToken();

    /**
     * 获取七牛图片域名
     * @param imgName 图片域名
     * @return 图片域名
     */
    String getImgUrl(String imgName);
}
