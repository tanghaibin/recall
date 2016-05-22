package top.tanghaibin.recall.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 代码生成器自动生成
 * Date:2016-5-11 18:40:37
 * @author
 */
@Table(name = "re_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "u_id")
  	  private Integer id; // 
      @Column(name = "u_username")
  	  private String username; // 用户名
      @Column(name = "u_pswd")
  	  private  String pswd; // 密码
      @Column(name = "u_salt")
  	  private  String salt; // 盐值
      @Column(name = "u_pic")
  	  private String pic; // 头像
      @Column(name = "u_email")
  	  private String email; // 邮箱
      @Column(name = "u_phone")
  	  private String phone; // 手机号
      @Column(name = "u_status")
  	  private Integer status; // 状态0未激活1已激活3已锁定
      @Column(name = "u_createDate")
  	  private Date createDate; // 创建时间
      @Column(name = "u_updateDate")
  	  private Date updateDate; // 更新时间
		@Column(name="u_hobby")
		private String hobby;//爱好
	@Column(name="u_birthday")
	private Date birthday;//生日
	 @Column(name="u_hometown")
	private String hometown;//故乡
	 @Column(name="u_profession")
	private String profession;//职业
	 @Column(name="u_name")
	private String name;//姓名
	 @Column(name="u_description")
	private String description;//个人描述
	/**
	   * 
	   * @return id
	   */
	  public Integer getId(){
	   return id;
	  }
	  /**
	   * 
	   * @param id 
	   */
	  public void setId(Integer id){
	    this.id = id;
	  }
  	  /**
	   * 用户名
	   * @return username
	   */
	  public String getUsername(){
	   return username;
	  }
	  /**
	   * 用户名
	   * @param username 
	   */
	  public void setUsername(String username){
	    this.username = username;
	  }
  	  /**
	   * 密码
	   * @return pswd
	   */
	  public String  getPswd(){
	   return pswd;
	  }
	  /**
	   * 密码
	   * @param pswd 
	   */
	  public void setPswd(String pswd){
	    this.pswd = pswd;
	  }
  	  /**
	   * 盐值
	   * @return salt
	   */
	  public  String getSalt(){
	   return salt;
	  }
	  /**
	   * 盐值
	   * @param salt 
	   */
	  public void setSalt(String salt){
	    this.salt = salt;
	  }
  	  /**
	   * 头像
	   * @return pic
	   */
	  public String  getPic(){
	   return pic;
	  }
	  /**
	   * 头像
	   * @param pic 
	   */
	  public void setPic(String pic){
	    this.pic = pic;
	  }
  	  /**
	   * 邮箱
	   * @return email
	   */
	  public String getEmail(){
	   return email;
	  }
	  /**
	   * 邮箱
	   * @param email 
	   */
	  public void setEmail(String email){
	    this.email = email;
	  }
  	  /**
	   * 手机号
	   * @return phone
	   */
	  public String getPhone(){
	   return phone;
	  }
	  /**
	   * 手机号
	   * @param phone 
	   */
	  public void setPhone(String phone){
	    this.phone = phone;
	  }
  	  /**
	   * 状态0未激活1已激活3已锁定
	   * @return status
	   */
	  public Integer getStatus(){
	   return status;
	  }
	  /**
	   * 状态0未激活1已激活3已锁定
	   * @param status 
	   */
	  public void setStatus(Integer status){
	    this.status = status;
	  }
  	  /**
	   * 创建时间
	   * @return createDate
	   */
	  public Date getCreateDate(){
	   return createDate;
	  }
	  /**
	   * 创建时间
	   * @param createDate 
	   */
	  public void setCreateDate(Date createDate){
	    this.createDate = createDate;
	  }
  	  /**
	   * 更新时间
	   * @return updateDate
	   */
	  public Date getUpdateDate(){
	   return updateDate;
	  }
	  /**
	   * 更新时间
	   * @param updateDate 
	   */
	  public void setUpdateDate(Date updateDate){
	    this.updateDate = updateDate;
	  }

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}