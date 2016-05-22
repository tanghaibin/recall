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
	@Transient
	private User user;//评论动态的user
	 @Transient
	private User reviewUser;//评论动态评论的user

	public User getReviewUser() {
		return reviewUser;
	}

	public void setReviewUser(User reviewUser) {
		this.reviewUser = reviewUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getReviewUid() {
		return reviewUid;
	}

	public void setReviewUid(Integer reviewUid) {
		this.reviewUid = reviewUid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}