package com.hope.galaxy.support.sso;

import com.hope.galaxy.support.sso.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserVO user = new UserVO();
        user.setUserName(token.getUsername());
        user.setUserName(token.getUsername());
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(token.getUsername(),"123456","UserRealm");
        return authenticationInfo;
    }
}
