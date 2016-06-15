package top.tanghaibin.recall.controller.photo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.tanghaibin.entity.Page;
import top.tanghaibin.recall.entity.Dynamic;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by tangh on 2016/4/29.
 */
@Controller
@RequestMapping("photo")
public class PhotoController {

    private static final Logger logger = LoggerFactory.getLogger(PhotoController.class);
    private static final String PRIFIX = "photoAlbum";

    /**
     * 跳转到相册类别页面
     * @return
     */
    @RequestMapping("toItemPage")
    public String toItemPage(){

        return PRIFIX + "/item";
    }

    /**
     * 跳转到相册类别详细页面
     * @return
     */
    @RequestMapping("toDetailPage")
    public String toDetailPage(){

        return PRIFIX + "/detail";
    }
}
