package top.tanghaibin.recall.context;

import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/4/19.
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof UnknownAccountException){
            modelAndView.addObject("msg","用户名或密码错误");
        }
        else if(e instanceof UnauthorizedException){
            modelAndView.addObject("msg","无权限");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
