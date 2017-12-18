package cn.hang.crm.modules.sys.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author lihang
 * @create 2017-10-31 下午5:13
 */
public class OAuth2Token implements AuthenticationToken {

    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

