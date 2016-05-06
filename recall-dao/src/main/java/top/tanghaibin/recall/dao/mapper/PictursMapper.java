package top.tanghaibin.recall.dao.mapper;


import org.apache.ibatis.annotations.Param;
import top.tanghaibin.recall.core.MyBatisBaseMapper;
import top.tanghaibin.recall.entity.Picturs;

import java.util.List;

/**
* 代码生成器自动生成
* Date:2016-4-29 21:01:57
* @author
*/
public interface PictursMapper extends MyBatisBaseMapper<Picturs> {
    /**
     * 查询动态图片
     * @param resourceId 图片来源id
     * @return
     */
    List<Picturs> selectDynamicPicByFK(Integer resourceId);
}