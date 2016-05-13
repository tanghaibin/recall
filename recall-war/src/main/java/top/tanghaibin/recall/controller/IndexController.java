package top.tanghaibin.recall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.service.BaseService;

/**
 * Created by tangh on 2016/5/11.
 */
@Controller
public class IndexController {
    Logger logger = LoggerFactory.getLogger(IndexController.class);

    private static final String PRIFIX = "user";

    @Autowired
    private BaseService baseService;

    @RequestMapping("index")
    public String toIndexPage(){
        return "index";
    }
    @RequestMapping("sendMail")
    public ModelAndView sendMail(String mail,Integer type){
        ModelAndView modelAndView = new ModelAndView();
        try {
            baseService.sendEmail(mail,type);
            modelAndView.setViewName("ok");
            return modelAndView;
        } catch (BizException e) {
            modelAndView.addObject("error",e.getMessage());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }
}
