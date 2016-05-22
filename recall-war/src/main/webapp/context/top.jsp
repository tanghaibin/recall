<%--
  Created by IntelliJ IDEA.
  User: tangh
  Date: 2016/4/29
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<link rel="stylesheet" type="text/css" href="/css/top.css"/>
<link rel="stylesheet" type="text/css" href="/css/common/common.css"/>
<%--<header class="clearfix">--%>
  <%--&lt;%&ndash;<div class="logo col-md-3"><h2 class="logo-text">INFUSION</h2></div>&ndash;%&gt;--%>
  <%--<nav class="clearfix">--%>
    <%--<div id="top-div-ul" style="background: url('/image/mod_profile.png');width: 100%;">--%>
      <%--<ul class="clearfix" id="navigate">--%>
        <%--<li><a href="${ctx}/index" class="active">主页</a></li>--%>
        <%--<li><a href="${ctx}/dynamic/toDynamicPage?pageNumber=0&pageSize=10">动态</a></li>--%>
        <%--<li><a href="#">博客</a></li>--%>
        <%--<li><a href="#">相册</a></li>--%>
        <%--<li><a href="#">留言板</a></li>--%>
        <%--<li><a href="#">关于我</a></li>--%>
        <%--<li><a href="#" class="last">联系我</a></li>--%>
      <%--</ul>--%>

      <%--<ul class="clearfix">--%>
        <%--<li><a href="${ctx}/user/login" style="padding-left: 200px;">登录</a></li>--%>
      <%--</ul>--%>
    <%--</div>--%>
    <%--&lt;%&ndash;<shiro:notAuthenticated>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div id="top-login-register-div" style="background: url('/image/mod_profile.png');">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<a href="${ctx}/user/login" style="padding-left: 200px;">登录</a>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<a href="${ctx}/user/register" style="padding-left: 30px;">注册</a>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</shiro:notAuthenticated>&ndash;%&gt;--%>
  <%--</nav>--%>
  <%--<div class="pullcontainer">--%>
    <%--<a href="#" id="pull"><i class="fa fa-bars fa-2x"></i></a>--%>
  <%--</div>--%>


<%--</header>--%>

<div id="top-div">
  <div style="width: 25%"></div>
  <div><a href="${ctx}/index" class="active" style="">主页</a></div>
  <div><a href="${ctx}/dynamic/toDynamicPage?pageNumber=0&pageSize=10">动态</a></div>
  <div><a href="${ctx}/index" class="active">博客</a></div>
  <div><a href="${ctx}/index" class="active" >相册</a></div>
  <div><a href="${ctx}/index" class="active" >留言板</a></div>
  <div><a href="${ctx}/index" class="active">关于我</a></div>
  <div><a href="${ctx}/index" class="active">联系我</a></div>
  <shiro:notAuthenticated>
  <div style="margin-left: 150px;"><a href="${ctx}/user/login">登录</a></div>
  <div><a href="${ctx}/user/register">注册</a></div>
  </shiro:notAuthenticated>
</div>