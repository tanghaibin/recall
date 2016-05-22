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

    public void updateUser(User user) throws BizException {
        if(user.getId() == null) throw new BizException("未知用户");
        user.setUpdateDate(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void updatePswd(User user,String oldPswd) throws BizException {
        if(CommonUtil.isEmpty(user.getId(),user.getPswd())){
            throw new BizException("信息不完整！无法修改");
        }
        User user2 = userMapper.selectByPrimaryKey(user.getId());
        if(null==user2){
            throw new BizException("未知用户");
        }
        if(!PasswordHelper.validatePwd(user2,oldPswd)){
            throw new BizException("原密码不匹配");
        }
        PasswordHelper.encryptPasswor(user);
        user.setUpdateDate(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void updatePswd2(User user,String code) throws BizException {
        if(CommonUtil.isEmpty(user.getEmail(),user.getPswd(),code)) throw new BizException("信息不完整！无法修改");
        Object obj = redisTemplate.opsForValue().get(user.getEmail()+":"+code);
        if(null==obj || !obj.toString().equals(code)) throw new BizException("验证码不正确");
        User user2 = new User();
        user2.setEmail(user.getEmail());
        user2 = userMapper.selectOne(user2);
        if(null == user2) throw new BizException("未知用户");
        PasswordHelper.encryptPasswor(user);
        user.setId(user2.getId());
        userMapper.updateByPrimaryKeySelective(user);
    }
}
