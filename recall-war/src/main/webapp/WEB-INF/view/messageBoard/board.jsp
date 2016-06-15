<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../../../context/context.jsp" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/css/top.css">
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <script src="${ctx}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/blog/blog.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.all.min.js"> </script>
</head>

<body>
    <jsp:include page="/context/top.jsp"></jsp:include>

    <script id='editor' type='text/plain' style='width:670px;height:60px;z-index:0'></script>

    <link type="text/css" rel="stylesheet" href="/css/photo/item.css">
</body>
</html>