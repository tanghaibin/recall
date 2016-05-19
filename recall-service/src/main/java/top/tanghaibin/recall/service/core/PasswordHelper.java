package top.tanghaibin.recall.service.core;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import top.tanghaibin.recall.entity.User;

public class PasswordHelper {
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private static final String algorithmName = "md5";
    private static final int hashIterations = 2;
    
    public static boolean validatePwd(User user,String pwd) {
        String newPassword = new SimpleHash(
                algorithmName,
                pwd,
                ByteSource.Util.bytes(user.getSalt()),
                hashIterations).toHex();
       return user.getPswd().equals(newPassword);
    }
    
    public static void encryptPasswor(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                 algorithmName,
                user.getPswd(),
                 ByteSource.Util.bytes(user.getSalt()),
                 hashIterations).toHex();
        user.setPswd(newPassword);
    }
    
    public static void main(String[] args) {
    	User u = new User();
		u.setUsername("18782908511");
		u.setPswd("1");
		encryptPasswor(u);
        System.out.println(u.getPswd()+" "+u.getSalt()+" "+validatePwd(u,"admin"));
    }
}