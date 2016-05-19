package top.tanghaibin.recall.service.dynamic.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.dao.mapper.DynamicMapper;
import top.tanghaibin.recall.dao.mapper.PictursMapper;
import top.tanghaibin.recall.entity.Dynamic;
import top.tanghaibin.recall.entity.Picturs;
import top.tanghaibin.recall.service.dynamic.DynamicService;
import top.tanghaibin.entity.Page;
import top.tanghaibin.utils.CommonUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by tangh on 2016/5/1.
 */
@Service
public class DynamicServiceImpl implements DynamicService{
    @Autowired
    private DynamicMapper dynamicMapper;
    @Autowired
    private PictursMapper pictursMapper;

    public Page<Dynamic> searchDynamicPage(Page<Dynamic> page) throws BizException {
        PageHelper.startPage(page.getPageNumber(),page.getPageSize());
        PageInfo<Dynamic> pageInfo = new PageInfo<Dynamic>(dynamicMapper.selectDynamicPage());
        page.setRows(pageInfo.getList());
        page.setTotal(pageInfo.getTotal());
        return page;
    }

    public Dynamic searchDynamicById(long id) throws BizException {
        if(CommonUtil.isEmpty(id)) new BizException("未知动态");
        return dynamicMapper.selectByPrimaryKey(id);
    }

    public void deleteDynamicByIds(List<Long> ids) throws BizException {
        if(null == ids || ids.size() == 0)throw new BizException("未知动态");
        Example example = new Example(Dynamic.class);
        example.createCriteria()
                .andIn("id",ids);
        dynamicMapper.deleteByExample(example);
    }

    public void addDynamic(Dynamic dynamic) throws BizException {
        if(null == dynamic || CommonUtil.isEmpty(dynamic.getContent())) throw new BizException("未知动态");
        dynamic.setCreateDate(new Date());
        dynamicMapper.insert(dynamic);
        if(dynamic.getPicturs()!=null && dynamic.getPicturs().size()>0){
            for(Picturs picturs:dynamic.getPicturs()){
                picturs.setType(0);
                picturs.setResourceId(dynamic.getId());
                picturs.setCreateDate(new Date());
            }
            pictursMapper.insertList(dynamic.getPicturs());
        }
    }

}
