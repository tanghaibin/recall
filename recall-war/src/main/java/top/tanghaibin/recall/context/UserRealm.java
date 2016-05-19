package top.tanghaibin.recall.context;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.entity.User;
import top.tanghaibin.recall.service.UserService;
import top.tanghaibin.recall.service.core.PasswordHelper;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/18.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
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

    /**
     *身份验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String pswd = new String(usernamePasswordToken.getPassword());
        User user = new User();
        user.setEmail(username);
        try {
            user = userService.searchUser(user);
        } catch (BizException e) {
            throw new AuthenticationException(e.getMessage());
        }
        if(user == null){
            throw new AuthenticationException("该用户不存在");
        }
        if(!PasswordHelper.validatePwd(user,pswd)){
            throw new AuthenticationException("用户名或密码错误");
        }
        if(user.getStatus() == 0){
            throw new AuthenticationException("该用户未激活");
        }
        if(user.getStatus() == 3){
            throw new AuthenticationException("该用户已锁定");
        }
        user.setPswd(null);
        user.setSalt(null);
        return new SimpleAuthenticationInfo(user, pswd, getName());
    }
}
