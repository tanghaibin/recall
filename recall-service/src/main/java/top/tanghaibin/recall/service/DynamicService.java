package top.tanghaibin.recall.service;

import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.entity.Dynamic;
import top.tanghaibin.entity.Page;

import java.util.List;

/**
 * Created by tangh on 2016/5/1.
 */
public interface DynamicService {
    /**
     * 分页查询动态
     * @return
     * @throws BizException
     */
    Page<Dynamic> searchDynamicPage(Page<Dynamic> page)throws BizException;

    /**
     * 根据id查询动态
     * @param id
     * @return
     * @throws BizException
     */
    Dynamic searchDynamicById(long id)throws BizException;

    /**
     * 删除动态
     * @param ids
     * @throws BizException
     */
    void deleteDynamicByIds(List<Long> ids)throws BizException;

    /**
     * 添加动态
     * @param dynamic
     * @throws BizException
     */
    void addDynamic(Dynamic dynamic)throws BizException;
}
