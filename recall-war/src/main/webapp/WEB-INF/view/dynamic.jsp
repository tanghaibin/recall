<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../../context/context.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Infusion WP Theme</title>
    <link href="${ctx}/css/dynamic/dynamic.css" rel="stylesheet">
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

    <script type="text/javascript" src="/js/utils.js"></script>
    <script type="text/javascript" src="/js/common/common.js"></script>
    <%--图片弹出层--%>
    <script src="${ctx}/js/magnific-popup/jquery.magnific-popup.js"></script>
    <link rel="stylesheet" href="${ctx}/js/magnific-popup/magnific-popup.css">
    <%--图片弹出层结束--%>
</head>
<body>
<%@include file="../../context/top.jsp" %>
<div id="dynamic-container">
    <c:forEach items="${requestScope.data.rows}" var="data" varStatus="count">
        <div class="dynamic div" id="div${count.index}">
            <div class="easyui-panel" style="width:700px;height:auto;padding:10px;">
                <div style="float: left">
                    <img width="60px" height="60px" src="${ctx}/image/head.png"/>
                </div>
                <div style="margin-left: 100px;">
                    <span class="nick-name">南汐寒笙</span>
                    <span class="create-date" id="create-date${count.index}">
                        <fmt:formatDate value="${data.createDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                                </span>
                </div>
            </div>
            <div class="easyui-panel" style="width:700px;height:auto;padding:10px;">
                <div class="dynamic-content">${data.content}</div>
                <c:forEach items="${data.picturs}" var="pic" varStatus="count2">
                    <a href="javascript:void(0);" id="a${count.index}${count2.index}"><img class="dynamic-img" id="img${count.index}${count2.index}" /></a>
                    <script type="text/javascript">
                        $("#img${count.index}${count2.index}").attr("src", getFileServerHost(0) + "${pic.address}");
                        $("#a${count.index}${count2.index}").mouseup(function(){
                           bindImage($("#img${count.index}${count2.index}").attr("src"),event,$("#a${count.index}${count2.index}").attr("id"));
                        });
                    </script>
                </c:forEach>
            </div>
        </div>
        <script type="text/javascript">
            if ("${count.index}" > 0) {
                $("#div${count.index}").css("margin-top", "30px");
            }
        </script>
    </c:forEach>
    <div id="dynaimc-paging">
        <c:choose>
            <c:when test="${requestScope.data.pageNumber >0}">
                <a href="${ctx}/dynamic/toDynamicPage?pageNumber=${requestScope.data.pageNumber-10}&pageSize=10"
                   class="easyui-linkbutton" style="width:80px;">上一页</a>
            </c:when>
            <c:otherwise>
                <a href="javascript:void(0);" class="easyui-linkbutton" style="width:80px;"
                   data-options="disabled:true">上一页</a>
            </c:otherwise>
        </c:choose>
        <c:forEach var="count" begin="1"
                   end="${requestScope.data.total%10==0?requestScope.data.total/10:requestScope.data.total/10+1}">
            <c:choose>
                <c:when test="${count == requestScope.data.pageNumber/10+1}">
                    <a href="${ctx}/dynamic/toDynamicPage?pageNumber=${(count-1)*10}&pageSize=10"
                       class="easyui-linkbutton" style="width:30px;background: #63C6AE">${count}</a>
                </c:when>
                <c:otherwise>
                    <a href="${ctx}/dynamic/toDynamicPage?pageNumber=${(count-1)*10}&pageSize=10"
                       class="easyui-linkbutton" style="width:30px">${count}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${requestScope.data.pageNumber*10 < (requestScope.data.total%10==0?requestScope.data.total/10:requestScope.data.total/10+1)*10}">
                <a href="${ctx}/dynamic/toDynamicPage?pageNumber=${requestScope.data.pageNumber+10}&pageSize=10"
                   class="easyui-linkbutton" style="width:80px;">下一页</a>
            </c:when>
            <c:otherwise>
                <a href="javascript:void(0);" class="easyui-linkbutton" style="width:80px;"
                   data-options="disabled:true">下一页</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>