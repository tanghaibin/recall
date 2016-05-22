package top.tanghaibin.recall.dao.mapper;


import top.tanghaibin.recall.core.MyBatisBaseMapper;
import top.tanghaibin.recall.entity.Review;

import java.util.List;

/**
* 代码生成器自动生成
* Date:2016-5-11 18:40:37
* @author
*/
public interface ReviewMapper extends MyBatisBaseMapper<Review> {
    /**
     * 根据动态id查询评论
     * @param resourceId
     * @return
     */
    List<Review> selectReviewByFK(Integer resourceId);
}