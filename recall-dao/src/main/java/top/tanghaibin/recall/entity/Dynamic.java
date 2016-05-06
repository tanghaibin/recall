package top.tanghaibin.recall.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 代码生成器自动生成
 * Date:2016-4-29 21:01:57
 * @author
 */
@Table(name = "re_dynamic")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dynamic implements Serializable{
	private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "d_id")
  	  private Integer id; // 
      @Column(name = "d_content")
  	  private String content; // 动态内容
      @Column(name = "d_commendCount")
  	  private Integer commendCount; // 点赞数
      @Column(name = "d_createDate")
  	  private Date createDate; // 创建时间
	@Transient
	private List<Picturs> picturs;
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
	   * 动态内容
	   * @return content
	   */
	  public String getContent(){
	   return content;
	  }
	  /**
	   * 动态内容
	   * @param content 
	   */
	  public void setContent(String content){
	    this.content = content;
	  }
  	  /**
	   * 点赞数
	   * @return commendCount
	   */
	  public Integer getCommendCount(){
	   return commendCount;
	  }
	  /**
	   * 点赞数
	   * @param commendCount 
	   */
	  public void setCommendCount(Integer commendCount){
	    this.commendCount = commendCount;
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

	public List<Picturs> getPicturs() {
		return picturs;
	}

	public void setPicturs(List<Picturs> picturs) {
		this.picturs = picturs;
	}
}