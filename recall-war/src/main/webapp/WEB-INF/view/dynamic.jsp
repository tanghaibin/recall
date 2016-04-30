<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../context/context.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Infusion WP Theme</title>
    <!-- Bootstrap -->
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/css/styles.css">
    <link rel="stylesheet" href="${ctx}/css/queries.css">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <!--<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>-->
    <!--<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>-->
    <![endif]-->
    <script src="${ctx}/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/scripts.js"></script>
    <script src="${ctx}/js/unslider.min.js"></script>

    <%--easyui--%>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
</head>
    <body>
    <%@include file="../../context/top.jsp"%>
    <div style="margin-left: 460px;">
        <div class="easyui-panel" style="width:700px;height:auto;padding:10px;">
            <div style="float: left">
                <img width="60px" height="60px" src="${ctx}/image/head.png"/>
            </div>
            <div style="margin-left: 100px;">
                <font style="font-size: 15px;font-family: 微软雅黑;">南汐寒笙</font>
                <font style="font-size: 15px;font-family: 微软雅黑;">5:30</font>
            </div>
        </div>
        <div class="easyui-panel" style="width:700px;height:auto;padding:10px;">
            <p>easyui is a collection of user-interface plugin based on jQuery.
                easyui provides essential functionality for building modem, interactive, javascript applications.
                using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.
                complete framework for HTML5 web page.
                easyui save your time and scales while developing your products.
                easyui is very easy but powerful.</p>
            <img src="${ctx}/image/head.png">
            <img src="${ctx}/image/head.png">
            <img src="${ctx}/image/head.png"><br/>
            <img src="${ctx}/image/head.png">
            <img src="${ctx}/image/head.png">
            <img src="${ctx}/image/head.png">
        </div>
    </div>

    <div style="margin-left: 460px;margin-top: 30px;">
        <div class="easyui-panel" style="width:700px;height:auto;padding:10px;">
            <div style="float: left">
                <img width="60px" height="60px" src="${ctx}/image/head.png"/>
            </div>
            <div style="margin-left: 100px;">
                <font style="font-size: 15px;font-family: 微软雅黑;">南汐寒笙</font>
                <font style="font-size: 15px;font-family: 微软雅黑;">5:30</font>
            </div>
        </div>
        <div class="easyui-panel" style="width:700px;height:auto;padding:10px;">
            <p>easyui is a collection of user-interface plugin based on jQuery.
                easyui provides essential functionality for building modem, interactive, javascript applications.
                using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.
                complete framework for HTML5 web page.
                easyui save your time and scales while developing your products.
                easyui is very easy but powerful.</p>
            <img src="${ctx}/image/head.png">
            <img src="${ctx}/image/head.png">
            <img src="${ctx}/image/head.png"><br/>
            <img src="${ctx}/image/head.png">
            <img src="${ctx}/image/head.png">
            <img src="${ctx}/image/head.png">
        </div>
    </div>
    </body>

    <script type="text/javascript">
        $(function(){
           skip(1);
        });

    </script>
</html>
