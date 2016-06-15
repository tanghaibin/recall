package top.tanghaibin.recall.controller.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by tangh on 2016/4/29.
 */
@Controller
@RequestMapping("board")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private static final String PRIFIX = "messageBoard";

    /**
     * 跳转到留言板页面
     * @return
     */
    @RequestMapping("toBoardPage")
    public String toBoardPage(){

        return PRIFIX + "/board";
    }
}
