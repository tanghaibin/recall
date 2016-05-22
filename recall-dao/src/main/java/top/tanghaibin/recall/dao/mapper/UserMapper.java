package top.tanghaibin.recall.dao.mapper;


import top.tanghaibin.recall.core.MyBatisBaseMapper;
import top.tanghaibin.recall.entity.User;

/**
* 代码生成器自动生成
* Date:2016-5-11 18:40:37
* @author
*/
public interface UserMapper extends MyBatisBaseMapper<User> {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User selectUserById(Integer id);
}