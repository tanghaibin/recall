<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/context/context.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>无标题文档</title>
  <link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
  <script language="JavaScript" src="${ctx}/js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript">
    $(function(){
      //顶部导航切换
      $(".nav li a").click(function(){
        $(".nav li a.selected").removeClass("selected")
        $(this).addClass("selected");
      })
    })

    function setLeftNavValue(parentId,name){
      top.leftFrame.initLeftNav(parentId,name);
    }


  </script>



</head>
<body style="background:url(${ctx}/images/topbg.gif) repeat-x;">

<div class="topleft">
  <a href="main.html" target="_parent"><img src="${ctx}/images/logo.png" title="系统首页" /></a>
</div>

<ul class="nav">
  <li><a href="#"  onclick="javascript:setLeftNavValue(0,'系统管理'); return false;"  class="selected" target="rightFrame"><img src="${ctx}/images/icon02.png" title="系统管理" /><h2>系统管理</h2></a></li>
  <li><a href="#" onclick="javascript:setLeftNavValue(1,'动态管理');return false;"  target="rightFrame"><img src="${ctx}/images/icon03.png" title="动态管理" /><h2>动态管理</h2></a></li>
  <li><a href="#" onclick="javascript:setLeftNavValue(2,'博客管理');return false;"  target="rightFrame"><img src="${ctx}/images/icon04.png" title="博客管理" /><h2>博客管理</h2></a></li>
  <li><a href="#" onclick="javascript:setLeftNavValue(3,'个人资料');return false;"  target="rightFrame"><img src="${ctx}/images/icon04.png" title="个人资料" /><h2>个人资料</h2></a></li>
</ul>

<div class="topright">
  <ul>
    <%-- <li><span><img src="${ctx}/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
     <li><a href="#">关于</a></li>--%>
    <li><a  href="javascript:resetPswd()"><b>重置密码</b></a></li>
    <li><a  href="${ctx}/admin/toUpdatePswd" target="rightFrame"><b>修改密码</b></a></li>
    <li><a  href="${ctx}/logout" target="_parent"><b>退  出</b></a></li>
  </ul>

  <div class="user">
    <span>${sessionScope.userName}</span>
    <%-- <i>消息</i>
     <b>5</b>--%>
  </div>

</div>
<script type="text/javascript">

  function resetPswd(){
    $.ajax({
      url:'${ctx}/admin/resetPswd',
      data:{'pswd':123456},
      success: function(data){
        window.open('${ctx}/logout',"_parent");
      },
      error: function (e) {
        alert(e.responseText);
      }
    })
  }
</script>
</body>
</html>
