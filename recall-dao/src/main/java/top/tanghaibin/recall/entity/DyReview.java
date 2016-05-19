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
@Table(name = "re_dy_review")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DyReview implements Serializable{
	private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "r_id")
	  private Integer id;
	@Column(name="r_uid")
	private Integer uid;//'用户id'
	@Column(name="r_review_uid")
	private Integer reviewUid;//'回复评论的用户id'
	@Column(name="r_type")
	private Integer type;//'类型0回复动态1回复评论'
	@Column(name="r_content")
	private String content;//'评论内容'
	@Column(name="r_uid")
	private String r_review_content;//'回复评论内容'
	@Column(name="r_resourceId")
	private Integer resouarceId;//'来源id'
	@Column(name="r_createDate")
	private Date createDate;//'创建时间'

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

	public String getR_review_content() {
		return r_review_content;
	}

	public void setR_review_content(String r_review_content) {
		this.r_review_content = r_review_content;
	}

	public Integer getResouarceId() {
		return resouarceId;
	}

	public void setResouarceId(Integer resouarceId) {
		this.resouarceId = resouarceId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}