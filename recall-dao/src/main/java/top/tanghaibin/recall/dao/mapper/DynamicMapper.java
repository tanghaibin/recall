package top.tanghaibin.recall.dao.mapper;


import top.tanghaibin.recall.core.MyBatisBaseMapper;
import top.tanghaibin.recall.entity.Dynamic;

import java.util.List;

/**
* 代码生成器自动生成
* Date:2016-4-29 21:01:57
* @author
*/
public interface DynamicMapper extends MyBatisBaseMapper<Dynamic> {
    /**
     * 查询动态列表
     * @return
     */
    List<Dynamic> selectDynamicPage();
}