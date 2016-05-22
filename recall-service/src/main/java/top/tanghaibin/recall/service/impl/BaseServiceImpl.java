package top.tanghaibin.recall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.recall.service.BaseService;
import top.tanghaibin.string.RandomUtils;
import top.tanghaibin.utils.CommonUtil;

import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangh on 2016/5/12.
 */
@Service
public class BaseServiceImpl implements BaseService{

    public BaseServiceImpl(){
        System.out.println();
    }
    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage mailMessage;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final top.tanghaibin.parser.json.JsonParser jsonParser = new  top.tanghaibin.parser.json.JsonParser();
    private static String register;
    private static String forget;
    private static String timeOut;
    static{
        try {
            URL url = BaseServiceImpl.class.getResource("/mail.json");
            InputStream inputStream = url.openStream();
            Map<String,List<Map<String,String>>> map = jsonParser.to(inputStream,Map.class);
            register = map.get("mail-template").get(0).get("register");
            forget = map.get("mail-template").get(1).get("forget");
            timeOut = map.get("mail-template").get(2).get("timeOut");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmail(String to, Integer type) throws BizException {
        if(CommonUtil.isEmpty(to,type)) throw new BizException("未知目标或者类型");
        String token = RandomUtils.getRandomStr();
        String validateCode = CommonUtil.getSixNum();
        if(type == 0){
            mailMessage.setText(MessageFormat.format(register,to+":token",token));
            redisTemplate.opsForValue().set(to + ":token", token);
        }else if(type == 1){
            mailMessage.setText(MessageFormat.format(forget,validateCode,timeOut));
            redisTemplate.opsForValue().set(to+":validateCode",validateCode,Integer.parseInt(timeOut),TimeUnit.MINUTES);
        }
        mailMessage.setTo(to);
        mailSender.send(mailMessage);
    }

    public static void main(String [] args){
        System.out.println(register);
        System.out.println(forget);
        System.out.println(timeOut);
    }
}
