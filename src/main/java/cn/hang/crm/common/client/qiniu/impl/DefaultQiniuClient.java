package cn.hang.crm.common.client.qiniu.impl;

import cn.hang.crm.common.client.qiniu.QiniuClient;
import com.qiniu.util.Auth;

/**
 * Created by trons on 16-7-26.
 * TIME: 下午8:07
 */
public class DefaultQiniuClient implements QiniuClient {

    private static final String ACCESS_KEY = "";
    private static final String SECRET_KEY = "";
    public static final String QINIU_URL = "";

    private static final String BUCKET = "ckkey";

    @Override
    public String getUpToken() {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        return auth.uploadToken(BUCKET);
    }

    @Override
    public String getImgUrl(String imgName) {
        return QINIU_URL + '/' + imgName;
    }
}