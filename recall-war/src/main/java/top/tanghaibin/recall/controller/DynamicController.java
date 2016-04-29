package top.tanghaibin.recall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by tangh on 2016/4/29.
 */
@Controller
@RequestMapping("dynamic")
public class DynamicController {

    private static final Logger logger = LoggerFactory.getLogger(DynamicController.class);

    /**
     * 跳转到动态页面
     * @return
     */
    @RequestMapping("toDynamicPage")
    public String toDynamicPage(){
        return "dynamic";
    }


}
