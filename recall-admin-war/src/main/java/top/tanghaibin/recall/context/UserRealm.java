package top.tanghaibin.recall.context;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/18.
 */
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Set<String> roleStrings = new HashSet<String>();
        Set<String> permissionStrings = new HashSet<String>();

        permissionStrings.add("user:add");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleStrings);
        authorizationInfo.setStringPermissions(permissionStrings);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String pswd = new String(usernamePasswordToken.getPassword());
        if("tanghaibin".equals(username) && "123".equals(pswd)){
            return new SimpleAuthenticationInfo(username, pswd, getName());
        }

        return null;
    }
}
