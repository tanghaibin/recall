package top.tanghaibin.recall.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.tanghaibin.cons.Constants;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.context.BaseController;
import top.tanghaibin.recall.entity.User;
import top.tanghaibin.recall.service.BaseService;
import top.tanghaibin.utils.CommonUtil;


/**
 * Created by tangh on 2016/5/11.
 */
@Controller
public class IndexController extends BaseController{
    Logger logger = LoggerFactory.getLogger(IndexController.class);

    private static final String PRIFIX = "user";

    @Autowired
    private BaseService baseService;

    @RequestMapping("sendMail")
    public @ResponseBody ResponseEntity<String> sendMail(String mail,Integer type){

        try {
            baseService.sendEmail(mail,type);
            return new ResponseEntity<String>(Constants.PASS_OK,HttpStatus.OK);
        } catch (BizException e) {

            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("login")
    public @ResponseBody ResponseEntity<String> login(User user){
        if(CommonUtil.isEmpty(user.getEmail()) || CommonUtil.isEmpty(user.getPswd())){
            return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
        }
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();
            usernamePasswordToken.setUsername(user.getEmail());
            usernamePasswordToken.setPassword(user.getPswd().toCharArray());
            subject.login(usernamePasswordToken);
            Session session = getCurSession();
            session.setAttribute("user", getLoginUser());
            return new ResponseEntity<String>(Constants.PASS_OK,HttpStatus.OK);
        }catch (AuthenticationException e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
