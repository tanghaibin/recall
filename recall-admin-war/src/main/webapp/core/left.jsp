<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/context/context.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>无标题文档</title>
  <script src="${ctx}/js/jquery-1.11.3.min.js" type="text/javascript" charset="UTF-8"></script>
  <link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />

</head>
<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>导航菜单</div>
<dl class="leftmenu" id="leftmenu"></dl>

<script type="text/javascript">
  $(function(){
    initLeftNav(0,'系统管理');
    //导航切换
    switchNav();
  });


  function initLeftNav(parentId,name){
    var navStr = "";
    navStr += "<dd>";
    navStr += "<div class='title'><span><img src='${ctx}/images/leftico01.png'/></span>"+name+"</div>";
    navStr += "<ul class='menuson'>";
    if(parentId==0){

    }else if(parentId==1){
      navStr += " <li><cite></cite><a href='${ctx}/dynamic/toDynamicPage' target='rightFrame'>动态列表</a><i></i></li>";
      navStr += " <li><cite></cite><a href='${ctx}/dynamic/toAddDynamicPage' target='rightFrame'>添加动态</a><i></i></li>";
    }else if(parentId==2){

    }else if(parentId==3){

    }

    navStr += "</ul>";
    navStr += "</dd>";
    $('#leftmenu').html(navStr);
    switchNav();
  }

  function switchNav(){
    $(".menuson li").click(function(){
      $(".menuson li.active").removeClass("active")
      $(this).addClass("active");
    });
    $('.title').click(function(){
      var $ul = $(this).next('ul');
      $('dd').find('ul').slideUp();
      if($ul.is(':visible')){
        $(this).next('ul').slideUp();
      }else{
        $(this).next('ul').slideDown();
      }
    });
  }

</script>
</body>
</html>
