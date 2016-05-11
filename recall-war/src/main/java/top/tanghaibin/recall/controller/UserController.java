package top.tanghaibin.recall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
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
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
