package cn.hang.crm.modules.sys.annotation;

import cn.hang.crm.modules.sys.dao.SysUserPOMapper;
import cn.hang.crm.modules.sys.entity.po.SysUserPO;
import cn.hang.crm.modules.sys.entity.po.SysUserTokenPO;
import cn.hang.crm.modules.sys.oauth2.OAuth2Filter;
import cn.hang.crm.modules.sys.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 有@SysLoginUser注解的方法参数，注入当前登录用户
 *
 * @author lihang
 * @create 2017-11-02 下午3:58
 */
@Component
public class SysLoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private SysUserPOMapper sysUserPOMapper;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(SysUserPO.class) && parameter.hasParameterAnnotation(SysLoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest request, WebDataBinderFactory binderFactory) throws Exception {
        //获取用户id
        Object object = request.getAttribute(OAuth2Filter.SYS_LOGIN_USER_KEY, RequestAttributes.SCOPE_REQUEST);
        System.out.println(object);
        if (object == null) {
            return null;
        }
        SysUserTokenPO sysUserTokenPO = sysUserTokenService.getTokenByToken((String) object);
        return sysUserPOMapper.selectByPrimaryKey(sysUserTokenPO.getUserId());
    }
}
