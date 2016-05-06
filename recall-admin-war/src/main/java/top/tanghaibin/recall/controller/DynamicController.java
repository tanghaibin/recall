package top.tanghaibin.recall.controller;
import org.springframework.web.bind.annotation.RequestParam;
import top.tanghaibin.parser.json.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.tanghaibin.cons.Constants;
import top.tanghaibin.entity.Page;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.entity.Dynamic;
import top.tanghaibin.recall.service.DynamicService;

import java.util.List;


/**
 * Created by tangh on 2016/4/29.
 */
@Controller
@RequestMapping("dynamic")
public class DynamicController {

    private static final Logger logger = LoggerFactory.getLogger(DynamicController.class);

    private static final String PRIFIX = "/dynamic";
    @Autowired
    private DynamicService dynamicService;

    private JsonParser jsonParser = new JsonParser();
    /**
     * 跳转到动态页面
     * @return
     */
    @RequestMapping("toDynamicPage")
    public String toDynamicPage(){
        return PRIFIX + "/dynamic";
    }

    /**
     * 跳转到添加动态页面
     * @return
     */
    @RequestMapping("toAddDynamicPage")
    public String toAddDynamicPage(){
        return PRIFIX + "/addDynamic";
    }
    @RequestMapping("page")
    public @ResponseBody Page<Dynamic> page(Page<Dynamic> page){
        try {
            dynamicService.searchDynamicPage(page);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return page;
    }

    /***
     * 添加动态
     * @param dynamicString
     * @return
     */
    @RequestMapping("add")
    public @ResponseBody ResponseEntity<String> add(String dynamicString){
        try {
            Dynamic dynamic = jsonParser.from(dynamicString,Dynamic.class);
            dynamicService.addDynamic(dynamic);
        } catch (BizException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
    }

    /**
     * 删除动态
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public @ResponseBody ResponseEntity<String> delete(@RequestParam("ids[]")List<Long> ids){
        try {
            dynamicService.deleteDynamicByIds(ids);
        } catch (BizException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
    }
}
