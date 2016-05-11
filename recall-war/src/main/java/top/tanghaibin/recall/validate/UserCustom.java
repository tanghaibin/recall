package top.tanghaibin.recall.validate;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * Created by tangh on 2016/5/11.
 */
public class UserCustom {
    //@Null(message = "用户名不能为空")
    @Size(min = 1,max = 10,message = "用户名只能在1~10个字符之间")
    private String username;
    @Size(min = 3,max = 10,message = "密码只能在1~10个字符之间")
   // @Null(message = "密码不能为空")
    private String pswd;
    @Size(min = 3,max = 10,message = "确认密码只能在1~10个字符之间")
    //@Null(message = "确认密码不能为空")
    private String confirmPswd;
    @Email(message = "邮箱格式不正确")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getConfirmPswd() {
        return confirmPswd;
    }

    public void setConfirmPswd(String confirmPswd) {
        this.confirmPswd = confirmPswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
