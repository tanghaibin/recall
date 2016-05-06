/**
* 动态表
 */
DROP TABLE IF EXISTS re_dynamic;
CREATE TABLE re_dynamic(
  d_id INT auto_increment PRIMARY KEY,
  d_content text COMMENT '动态内容',
  d_commendCount int COMMENT '点赞数',
  d_createDate datetime COMMENT '创建时间'
);
/**
*图片表
 */
DROP TABLE IF EXISTS re_picturs;
CREATE TABLE  re_picturs(
  p_id INT auto_increment PRIMARY key,
  p_address VARCHAR (100) COMMENT '图片地址',
  p_resourceId int COMMENT '图片来源ID',
  p_name VARCHAR(32) COMMENT '图片名字',
  p_suffix varchar(5) COMMENT '图片后缀',
  p_type int COMMENT '图片类型0动态1相册2头像',
  p_createDate DATETIME COMMENT '创建时间'
);
/**
*动态评论表
 */
DROP TABLE  IF EXISTS  re_dy_review;
CREATE TABLE re_dy_review(
  dy_r_id INT auto_increment PRIMARY key,
  dy_d_id INT COMMENT '动态ID',
  dy_r_review_name VARCHAR (8) COMMENT '评论的昵称（随机生成）',
  dy_r_content varchar(200) COMMENT '评论内容',
  dy_r_type INT COMMENT '评论类型0评论动态本身1评论评论',
  dy_r_createDate DATETIME COMMENT '评论时间'
);