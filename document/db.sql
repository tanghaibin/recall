/**
*用户表
 */
DROP TABLE IF EXISTS re_user;
CREATE TABLE re_user(
  u_id INT AUTO_INCREMENT PRIMARY KEY,
  u_username VARCHAR(20) COMMENT '用户名',
  u_pswd CHAR(32) COMMENT '密码',
  u_salt CHAR(32) COMMENT '盐值',
  u_pic CHAR(32) COMMENT '头像',
  u_email VARCHAR(50) COMMENT '邮箱',
  u_phone VARCHAR(11) COMMENT '手机号',
  u_status TINYINT COMMENT '状态0未激活1已激活3已锁定',
  u_createDate DATETIME COMMENT '创建时间',
  u_updateDate DATETIME COMMENT '更新时间',
  u_hobby VARCHAR(200) COMMENT '爱好',
  u_birthday DATETIME COMMENT '生日',
  u_hometown VARCHAR(40) COMMENT '故乡',
  u_profession VARCHAR(20) COMMENT '职业',
  u_name VARCHAR(20) COMMENT '姓名',
  u_description VARCHAR(100) COMMENT '个人描述'
);
/**
* 动态表
 */
DROP TABLE IF EXISTS re_dynamic;
CREATE TABLE re_dynamic(
  d_id INT auto_increment PRIMARY KEY,
  d_uid INT COMMENT '用户id',
  d_content text COMMENT '动态内容',
  d_reviewCount INT COMMENT '评论数',
  d_commendCount int COMMENT '点赞数',
  d_createDate datetime COMMENT '创建时间'
);
/**
*点赞表
 */
DROP TABLE IF EXISTS re_commend;
CREATE TABLE re_commend(
  c_id INT auto_increment PRIMARY KEY,
  c_uid INT COMMENT '用户id',
  c_type TINYINT COMMENT '类型0动态',
  c_resourceId INT COMMENT '来源id',
  c_createDate DATETIME COMMENT '创建时间'
);
/**
*动态评论表
 */
DROP TABLE IF EXISTS re_review;
CREATE TABLE re_review(
  r_id INT auto_increment PRIMARY KEY,
  r_uid INT COMMENT '用户id',
  r_review_uid INT COMMENT '回复评论的用户id',
  r_type TINYINT COMMENT '类型0回复动态1回复评论',
  r_content TEXT COMMENT '评论内容',
  r_review_content TEXT COMMENT '回复评论内容',
  r_resourceId INT COMMENT '来源id',
  r_createDate DATETIME COMMENT '创建时间'
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
  p_type int COMMENT '图片类型0动态1相册',
  p_createDate DATETIME COMMENT '创建时间'
);