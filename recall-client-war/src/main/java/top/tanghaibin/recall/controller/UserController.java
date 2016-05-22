package top.tanghaibin.recall.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import top.tanghaibin.cons.Constants;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.entity.User;
import top.tanghaibin.recall.service.BaseService;
import top.tanghaibin.recall.service.UserService;
import top.tanghaibin.recall.validate.UserCustom;
import top.tanghaibin.utils.CommonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
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
     * 注册用户
     * @param userCustom
     * @param bindingResult
     * @return
     */
    @RequestMapping("add")
    public @ResponseBody ResponseEntity<String> add(@Validated UserCustom userCustom,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(userCustom.getUsername());
        user.setEmail(userCustom.getEmail());
        user.setPswd(userCustom.getPswd());
        try {
            userService.add(user);
            baseService.sendEmail(user.getEmail(),0);
            return new ResponseEntity<String>(Constants.PASS_OK,HttpStatus.OK);
        } catch (BizException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 激活用户
     * @param key
     * @param token
     * @return
     */
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

    /**
     * 编辑用户
     * @param user
     * @param oldPswd
     * @return
     */
    @RequestMapping("edit")
    @RequiresAuthentication
    public @ResponseBody ResponseEntity<String> edit(User user,String oldPswd){
        try {
            if(CommonUtil.isEmpty(oldPswd,user.getPswd())){
                userService.updateUser(user);
            }else{
                userService.updatePswd(user,oldPswd);
            }
            return new ResponseEntity<String>(Constants.PASS_OK,HttpStatus.OK);
        } catch (BizException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 根据id获取用户
     * @param user
     * @return
     */
    @RequestMapping("getUserById")
    @RequiresAuthentication
    public @ResponseBody ResponseEntity<Object> getUserById(User user){
            if (user.getId() == null) {
                return new ResponseEntity<Object>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);
            }
            try {
                user = userService.searchUser(user);
                return new ResponseEntity<Object>(user, HttpStatus.OK);
            } catch (BizException e) {
                return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return new ResponseEntity<Object>(Constants.EX_PARAM, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    /**
     * 忘记密码
     * @param user
     * @param code
     * @return
     */
    @RequestMapping("forgetPswd")
    public @ResponseBody ResponseEntity<String> forgetPswd(User user,String code){
        try {
            userService.updatePswd2(user,code);
            return new ResponseEntity<String>(Constants.PASS_OK,HttpStatus.OK);
        } catch (BizException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
