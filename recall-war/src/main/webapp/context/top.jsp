<%--
  Created by IntelliJ IDEA.
  User: tangh
  Date: 2016/4/29
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/css/top.css"/>
<link rel="stylesheet" type="text/css" href="/css/common/common.css"/>
<header class="clearfix">
  <div class="logo col-md-3"><h2 class="logo-text">INFUSION</h2></div>
  <nav class="clearfix">
    <div  id="top-div-ul">
      <ul class="clearfix" id="navigate">
        <li><a href="${ctx}/index.jsp" class="active">主页</a></li>
        <li><a href="${ctx}/dynamic/toDynamicPage?pageNumber=0&pageSize=10">动态</a></li>
        <li><a href="#">博客</a></li>
        <li><a href="#">相册</a></li>
        <li><a href="#">留言板</a></li>
        <li><a href="#" class="last">联系我</a></li>
      </ul>
    </div>
    <div id="top-login-register-div">
      <a href="${ctx}/user/login" style="padding-left: 260px;">登录</a>
      <a href="${ctx}/user/register" style="padding-left: 30px;">注册</a>
    </div>
  </nav>
  <div class="pullcontainer">
    <a href="#" id="pull"><i class="fa fa-bars fa-2x"></i></a>
  </div>
</header>