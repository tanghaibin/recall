package top.tanghaibin.recall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by tangh on 2016/4/29.
 */
@Controller
@RequestMapping("about")
public class AboutController {

    private static final Logger logger = LoggerFactory.getLogger(AboutController.class);

    /**
     * 跳转到博客页面
     * @return
     */
    @RequestMapping("toAboutPage")
    public String toAboutPage(){
        return "about";
    }

}
