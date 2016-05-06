package top.tanghaibin.recall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.tanghaibin.entity.Page;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.entity.Dynamic;
import top.tanghaibin.recall.service.DynamicService;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by tangh on 2016/4/29.
 */
@Controller
@RequestMapping("dynamic")
public class DynamicController {

    private static final Logger logger = LoggerFactory.getLogger(DynamicController.class);

    @Autowired
    private DynamicService dynamicService;

    /**
     * 跳转到动态页面
     * @return
     */
    @RequestMapping("toDynamicPage")
    public String toDynamicPage(Page<Dynamic> page,HttpServletRequest request){
        try {
            page = dynamicService.searchDynamicPage(page);
            request.setAttribute("data",page);
        } catch (BizException e) {
            request.setAttribute("msg",e.getMessage());
            return "error";
        }catch (Exception e){
            request.setAttribute("msg", HttpStatus.INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
            return "error";
        }
        return "dynamic";
    }
}
