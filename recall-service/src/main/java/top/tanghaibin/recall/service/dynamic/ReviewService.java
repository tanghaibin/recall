package top.tanghaibin.recall.service.dynamic;

import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.entity.Review;

/**
 * Created by tangh on 2016/5/15.
 */
public interface ReviewService {
    /**
     * 添加动态评论
     * @param review
     * @throws BizException
     */
    void add(Review review)throws BizException;
}
