package top.tanghaibin.recall.controller.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.tanghaibin.entity.Page;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.entity.Dynamic;
import top.tanghaibin.recall.service.dynamic.DynamicService;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by tangh on 2016/4/29.
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
    private static final String PRIFIX = "blog";

    /**
     * 跳转到博客页面
     * @return
     */
    @RequestMapping("toBlogPage")
    public String toBlogPage(Page<Dynamic> page,HttpServletRequest request){

        return PRIFIX + "/blog";
    }

    @RequestMapping("getBlogById")
    public String getBlogById(Page<Dynamic> page,HttpServletRequest request){

        return PRIFIX + "/blogItem";
    }
}
