package top.tanghaibin.recall.service;

import top.tanghaibin.exception.BizException;

/**
 * Created by tangh on 2016/5/12.
 */
public interface BaseService {
    /**
     * 发送mail
     * @param to 目标
     * @param type 类型0注册1找回密码
     * @throws BizException
     */
    public void sendEmail(String to,Integer type)throws BizException;
}
