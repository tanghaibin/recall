package top.tanghaibin.recall.context;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import top.tanghaibin.recall.entity.User;

import javax.security.auth.Subject;

/**
 * Created by tangh on 2016/5/15.
 */
public class BaseController {

    public User getLoginUser(){
        Object user = SecurityUtils.getSubject().getPrincipal();
        if(user!=null){
            return (User)user;
        }
        return null;
    }

    public Session getCurSession(){
        return SecurityUtils.getSubject().getSession();
    }
}
