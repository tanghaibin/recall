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
    <link rel="stylesheet" href="${ctx}/css/styles.css">
    <link rel="stylesheet" href="${ctx}/css/queries.css">

    <link rel="stylesheet" type="text/css" href="/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <script src="${ctx}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/blog.js"></script>
</head>

<body>
    <jsp:include page="/context/top.jsp"></jsp:include>
    <div id="left-div">
        <ul  class="easyui-tree">
            <li>
                <span>javase相关</span>
                <ul>
                    <li>多线程</li>
                    <li>io流</li>
                    <li>网络编程</li>
                    <li>反射</li>
                </ul>
            </li>
        </ul>
        <ul  class="easyui-tree">
            <li>
                <span>javaweb相关</span>
                <ul>
                    <li>多线程</li>
                    <li>io流</li>
                    <li>网络编程</li>
                    <li>反射</li>
                </ul>
            </li>
        </ul>
        <ul  class="easyui-tree">
            <li>
                <span>javaweb相关</span>
                <ul>
                    <li>多线程</li>
                    <li>io流</li>
                    <li>网络编程</li>
                    <li>反射</li>
                </ul>
            </li>
        </ul>
        <ul  class="easyui-tree">
            <li>
                <span>javaweb相关</span>
                <ul>
                    <li>多线程</li>
                    <li>io流</li>
                    <li>网络编程</li>
                    <li>反射</li>
                </ul>
            </li>
        </ul>
        <ul  class="easyui-tree">
            <li>
                <span>javaweb相关</span>
                <ul>
                    <li>多线程</li>
                    <li>io流</li>
                    <li>网络编程</li>
                    <li>反射</li>
                </ul>
            </li>
        </ul>

    </div>
    <div id="blog-title-div">
        <p>java高并发编程</p>
        <p style="font-size: 9px">阅读次数：666666 </p>
    </div>
    <div id="right-div">

    </div>

    <link rel="stylesheet" type="text/css" href="/css/blog/blog.css">
</body>
</html>