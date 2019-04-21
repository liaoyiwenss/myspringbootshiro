package net.wanho.realm;

import net.wanho.service.user.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class Realm extends AuthorizingRealm {


    @Autowired
    private UserService userService;
    //    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        /*userService.selectByPrimaryKey("")
        List<String> roles = userServiceI.getRoles("zhang");
        List<String> permissions = userServiceI.getPermissions("zhang");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;*/
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        /*String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        User user = userServiceI.getUser(username);

        if (user == null) {
            throw new RuntimeException("用户不存在");
        }


        String newPwd = userServiceI.shiroMD5(password, user.getSalt());

        if (!newPwd .equals( user.getPassword())) {
            throw new IncorrectCredentialsException("账号或者密码不正确");
        }

*/
//        return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());

        return null;
    }
}
