package top.tanghaibin.recall.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 代码生成器自动生成
 * Date:2016-4-29 21:01:57
 * @author
 */
@Table(name = "re_picturs")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Picturs implements Serializable{
	private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "p_id")
  	  private Integer id; // 
      @Column(name = "p_address")
  	  private String address; // 图片地址
      @Column(name = "p_name")
  	  private String name; // 图片名字
      @Column(name = "p_suffix")
  	  private String suffix; // 图片后缀
      @Column(name = "p_type")
  	  private Integer type; // 图片类型0动态1相册2头像
      @Column(name = "p_createDate")
  	  private Date createDate; // 创建时间
	@Column(name="p_resourceId")
	private Integer resourceId;//图片来源id
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
	   * 图片地址
	   * @return address
	   */
	  public String getAddress(){
	   return address;
	  }
	  /**
	   * 图片地址
	   * @param address 
	   */
	  public void setAddress(String address){
	    this.address = address;
	  }
  	  /**
	   * 图片名字
	   * @return name
	   */
	  public String getName(){
	   return name;
	  }
	  /**
	   * 图片名字
	   * @param name 
	   */
	  public void setName(String name){
	    this.name = name;
	  }
  	  /**
	   * 图片后缀
	   * @return suffix
	   */
	  public String getSuffix(){
	   return suffix;
	  }
	  /**
	   * 图片后缀
	   * @param suffix 
	   */
	  public void setSuffix(String suffix){
	    this.suffix = suffix;
	  }
  	  /**
	   * 图片类型0动态1相册2头像
	   * @return type
	   */
	  public Integer getType(){
	   return type;
	  }
	  /**
	   * 图片类型0动态1相册2头像
	   * @param type 
	   */
	  public void setType(Integer type){
	    this.type = type;
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

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
}