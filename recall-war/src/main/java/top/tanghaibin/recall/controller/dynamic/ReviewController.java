package top.tanghaibin.recall.controller.dynamic;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.tanghaibin.cons.Constants;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.context.BaseController;
import top.tanghaibin.recall.entity.Review;
import top.tanghaibin.recall.service.dynamic.ReviewService;

/**
 * Created by tangh on 2016/5/15.
 */
@Controller
@RequestMapping("dynamic/review")
public class ReviewController extends BaseController{

    Logger logger = LoggerFactory.getLogger(ReviewController.class);
    @Autowired
    private ReviewService reviewService;

    /**
     * 动态评论
     * @param review
     * @return
     */
    @RequestMapping("add")
    @RequiresAuthentication
    public @ResponseBody ResponseEntity<String> add(Review review){
        try {
            if(review.getType() == 0){
                review.setUid(getLoginUser().getId());
            }else if(review.getType() == 1){
                review.setReviewUid(getLoginUser().getId());
                review.setReviewContent(review.getContent());
                review.setContent(null);
            }
            reviewService.add(review);
            return new ResponseEntity<String>(Constants.PASS_OK,HttpStatus.OK);
        } catch (BizException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
