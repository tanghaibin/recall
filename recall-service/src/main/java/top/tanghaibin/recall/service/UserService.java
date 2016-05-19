package top.tanghaibin.recall.service;

import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.entity.User;

/**
 * Created by tangh on 2016/5/12.
 */
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @throws BizException
     */
    void add(User user)throws BizException;

    /**
     * 激活用户
     * @param token
     * @throws BizException
     */
    void updateStatus(String key,String token)throws BizException;

    /**
     * 查詢用戶
     * @param user
     * @throws BizException
     */
    User searchUser(User user) throws BizException;
}
