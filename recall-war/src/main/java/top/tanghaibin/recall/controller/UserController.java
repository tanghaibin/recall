package top.tanghaibin.recall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.entity.User;
import top.tanghaibin.recall.service.BaseService;
import top.tanghaibin.recall.service.UserService;
import top.tanghaibin.recall.validate.UserCustom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * Created by tangh on 2016/5/11.
 */
@Controller
@RequestMapping("user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String PRIFIX = "user";
    @Autowired
    private UserService userService;
    @Autowired
    private BaseService baseService;

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("register")
    public String toRegisterPage(){
        return PRIFIX + "/register";
    }
    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("login")
    public String toLoginPage(){
        return PRIFIX + "/login";
    }

    @RequestMapping("add")
    public ModelAndView add(@Validated UserCustom userCustom,BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.addObject("userCustom",userCustom);
            modelAndView.setViewName("user/register");
            return modelAndView;
        }
        User user = new User();
        user.setUsername(userCustom.getUsername());
        user.setEmail(userCustom.getEmail());
        user.setPswd(userCustom.getPswd());
        try {
            userService.add(user);
            baseService.sendEmail(user.getEmail(),0);
        } catch (BizException e) {
            modelAndView.setViewName("error");
            modelAndView.addObject("msg",e.getMessage());
            return modelAndView;
        }catch (Exception e){
            logger.error(e.getMessage());
            modelAndView.setViewName("error");
            modelAndView.addObject("msg", HttpStatus.INTERNAL_SERVER_ERROR);
            return modelAndView;
        }
        modelAndView.setViewName(PRIFIX + "/login");
        return modelAndView;
    }
    @RequestMapping("activate")
    public ModelAndView activate(String key,String token){
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.updateStatus(key,token);
            modelAndView.setViewName("ok");
            modelAndView.addObject("msg","账户激活成功！点此<a href='/user/login'>登录</a>");
            return modelAndView;
        } catch (BizException e) {
            modelAndView.addObject("msg",e.getMessage());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }
}
