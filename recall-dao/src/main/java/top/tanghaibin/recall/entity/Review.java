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
@Table(name = "re_review")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Review implements Serializable{
	private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "r_id")
  	  private Integer id; // 
      @Column(name = "r_uid")
  	  private Integer uid; // 用户id
      @Column(name = "r_review_uid")
  	  private Integer reviewUid; // 回复评论的用户id
      @Column(name = "r_type")
  	  private Integer type; // 类型0回复动态1回复评论
      @Column(name = "r_content")
  	  private String content; // 评论内容
      @Column(name = "r_review_content")
  	  private String reviewContent; // 回复评论内容
      @Column(name = "r_resourceId")
  	  private Integer resourceId; // 来源id
      @Column(name = "r_createDate")
  	  private Date createDate; // 创建时间
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
	   * 用户id
	   * @return uid
	   */
	  public Integer getUid(){
	   return uid;
	  }
	  /**
	   * 用户id
	   * @param uid 
	   */
	  public void setUid(Integer uid){
	    this.uid = uid;
	  }
  	  /**
	   * 回复评论的用户id
	   * @return review
	   */
	public Integer getReviewUid() {
		return reviewUid;
	}

	public void setReviewUid(Integer reviewUid) {
		this.reviewUid = reviewUid;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	/**
	   * 类型0回复动态1回复评论
	   * @return type
	   */
	  public Integer getType(){
	   return type;
	  }
	  /**
	   * 类型0回复动态1回复评论
	   * @param type 
	   */
	  public void setType(Integer type){
	    this.type = type;
	  }
  	  /**
	   * 评论内容
	   * @return content
	   */
	  public String getContent(){
	   return content;
	  }
	  /**
	   * 评论内容
	   * @param content 
	   */
	  public void setContent(String content){
	    this.content = content;
	  }

  	  /**
	   * 来源id
	   * @return resourceId
	   */
	  public Integer getResourceId(){
	   return resourceId;
	  }
	  /**
	   * 来源id
	   * @param resourceId 
	   */
	  public void setResourceId(Integer resourceId){
	    this.resourceId = resourceId;
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
}