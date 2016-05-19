package top.tanghaibin.recall.service.dynamic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.dao.mapper.ReviewMapper;
import top.tanghaibin.recall.entity.Review;
import top.tanghaibin.recall.service.dynamic.ReviewService;
import top.tanghaibin.utils.CommonUtil;

/**
 * Created by tangh on 2016/5/15.
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public void add(Review review) throws BizException {
        if(review.getType() == 0){
            if(CommonUtil.isEmpty(review.getContent())) throw new BizException("未知评论");
        }else if(review.getType() == 1){
            if(CommonUtil.isEmpty(review.getReviewContent())) throw new BizException("未知评论");
        }
        reviewMapper.insert(review);
    }
}
