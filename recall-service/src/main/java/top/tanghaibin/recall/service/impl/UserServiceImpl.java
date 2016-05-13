package top.tanghaibin.recall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.entity.User;
import top.tanghaibin.recall.service.UserService;
import top.tanghaibin.utils.CommonUtil;

/**
 * Created by tangh on 2016/5/12.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private RedisTemplate redisTemplate;

    public void add(User user) throws BizException {

    }

    public void updateStatus(String key,String token) throws BizException {
        if(CommonUtil.isEmpty(token,key))throw new BizException("未知用户或者激活码");
        System.out.println(redisTemplate.opsForValue().get(key));
        String token2 = redisTemplate.opsForValue().get(key).toString();
        if(!token.equals(token2))throw new BizException("未知激活码");
        System.out.println("激活"+key);
    }
}
