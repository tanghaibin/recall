package top.tanghaibin.recall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.dao.mapper.UserMapper;
import top.tanghaibin.recall.entity.User;
import top.tanghaibin.recall.service.UserService;
import top.tanghaibin.recall.service.core.PasswordHelper;
import top.tanghaibin.utils.CommonUtil;

import java.util.Date;

/**
 * Created by tangh on 2016/5/12.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserMapper userMapper;

    public void add(User user) throws BizException {
        if(CommonUtil.isEmpty(user.getEmail(),user.getPswd(),user.getUsername())) throw new BizException("用户信息不全，无法添加");
        User u = new User();
        u.setEmail(user.getEmail());
        u = userMapper.selectOne(u);
        if(u != null){
            throw new BizException("用户已存在");
        }
        PasswordHelper.encryptPasswor(user);
        user.setCreateDate(new Date());
        user.setStatus(0);
        userMapper.insert(user);
    }

    public void updateStatus(String key,String token) throws BizException {
        if(CommonUtil.isEmpty(token,key))throw new BizException("未知用户或者激活码");
        Object token1 = redisTemplate.opsForValue().get(key);
        if(CommonUtil.isEmpty(redisTemplate.opsForValue().get(key))){
            throw new BizException("未知激活码");
        }
        String token2 = token1.toString();
        if(!token.equals(token2))throw new BizException("未知激活码");
        //String [] email = token2.split(":");
        User user = new User();
        user.setEmail(key.split(":")[0]);
        user = userMapper.selectOne(user);
        if(null == user)throw new BizException("未知用户");
        user.setStatus(1);
        userMapper.updateByPrimaryKeySelective(user);
        redisTemplate.delete(key);
    }

    public User searchUser(User user) throws BizException {
        return userMapper.selectOne(user);
    }
}
