package cn.hang.crm.common.client.qiniu;

/**
 * Created by trons on 16-7-26.
 * TIME: 下午8:06
 */
public interface QiniuClient {

    String getUpToken();

    String getImgUrl(String imgName);
}
