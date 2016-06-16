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
<%--<div id="top-div">--%>
  <%--<div style="width: 25%"></div>--%>
  <%--<div><a href="${ctx}/index" class="active" style="">主页</a></div>--%>
  <%--<div><a href="${ctx}/dynamic/toDynamicPage?pageNumber=0&pageSize=10">动态</a></div>--%>
  <%--<div><a href="${ctx}/index" class="active">博客</a></div>--%>
  <%--<div><a href="${ctx}/index" class="active" >相册</a></div>--%>
  <%--<div><a href="${ctx}/index" class="active" >留言板</a></div>--%>
  <%--<div><a href="${ctx}/index" class="active">关于我</a></div>--%>
  <%--<div><a href="${ctx}/index" class="active">联系我</a></div>--%>
  <%--<shiro:notAuthenticated>--%>
        <%--<div style="position: relative;right: -5%"><a href="${ctx}/user/login">登录</a></div>--%>
        <%--<div style="position: relative;right: -3%"><a href="${ctx}/user/register">注册</a></div>--%>
  <%--</shiro:notAuthenticated>--%>

  <div id="top-div">
      <div id="logo-div"></div>
      <div><a href="${ctx}/index" class="active" style="">主页</a></div>
      <div><a href="${ctx}/dynamic/toDynamicPage?pageNumber=0&pageSize=10">动态</a></div>
      <div><a href="${ctx}/blog/toBlogPage" class="active">博客</a></div>
      <div><a href="${ctx}/photo/toItemPage" class="active" >相册</a></div>
      <div><a href="${ctx}/board/toBoardPage" class="active" >留言板</a></div>
      <div><a href="${ctx}/index" class="active">关于我</a></div>
      <div><a href="${ctx}/index" class="active">联系我</a></div>

<shiro:notAuthenticated>
        <div id="login-div-a"><a href="${ctx}/user/login">登录</a></div>
        <div id="regist-div-a"><a href="${ctx}/user/register">注册</a></div>
  </div>
</shiro:notAuthenticated>

</div>