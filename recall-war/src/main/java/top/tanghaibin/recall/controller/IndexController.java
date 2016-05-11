package top.tanghaibin.recall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tangh on 2016/5/11.
 */
@Controller
public class IndexController {
    Logger logger = LoggerFactory.getLogger(IndexController.class);

    private static final String PRIFIX = "user";

    @RequestMapping("index")
    public String toIndexPage(){
        return "index";
    }
}
