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
    <link rel="stylesheet" type="text/css" href="/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <script src="${ctx}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/lang/zh-cn/zh-cn.js"> </script>
</head>

<body>
    <jsp:include page="/context/top.jsp"></jsp:include>
    <div id="main-div">
        <div class="head-pic-div">
            <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
        </div>
        <div class="head-nickName-div" style="margin-top: 2%">
            <b>风中叶</b><br/>
            <b style="font-size: 9px">2016-02-18 23:40:58</b>
        </div>
        <div class="content-div">
            <div class="triangle-div"></div>


            要知道我们是攒了多少个吃泡面的日子才买到了一个名牌包包；我们是熬了多少个加班的夜晚才拿到了这份offer；我们是用了多少次美颜加修饰才P出这么美丽的自己……那些晒出来的包包、offer、照片只是生活中的点缀而已，背后的一切才是真实的你我。别拿朋友圈的内容来评价他人的生活状态，因为我们晒的不是平时的生活，只是生活中某些触动自己的瞬间，某些彰显自己闪光点的瞬间而已。

            有意思的是，往往真正权高富有、过得很好的人会很不经意，甚至很避嫌一些会彰显特权和财富的细节。往往真正有文化底蕴的人，并不屑于在朋友圈晒自己读过什么书，写过什么文章。

            有人嫌秀恩爱和晒孩子烦，也有人嫌晒富是炫耀，更有人嫌晒什么晒多了就是low。晒幸福的也许并不是真的幸福，炫富的也许真的有钱。但是不管哪种晒，作为一个看客看看就好，别把朋友圈真的当成了生活圈。如同这纷扰的大千世界的一出戏，有真有假，真实的人生精彩其实在台下。
        </div>

        <div class="head-pic-div">
            <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
        </div>
        <div class="head-nickName-div">
            <b>风中叶</b><br/>
            <b style="font-size: 9px">2016-02-18 23:40:58</b>
        </div>
        <div class="content-div">

            <div class="triangle-div"></div>
            要知道我们是攒了多少个吃泡面的日子才买到了一个名牌包包；我们是熬了多少个加班的夜晚才拿到了这份offer；我们是用了多少次美颜加修饰才P出这么美丽的自己……那些晒出来的包包、offer、照片只是生活中的点缀而已，背后的一切才是真实的你我。别拿朋友圈的内容来评价他人的生活状态，因为我们晒的不是平时的生活，只是生活中某些触动自己的瞬间，某些彰显自己闪光点的瞬间而已。

        </div>

        <div class="head-pic-right-div">
            <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
        </div>
        <div class="head-nickName-right-div" style="margin-top: 2%">
            <b style="position: relative;left:8%">风中叶</b><br/>
            <b style="font-size: 9px;position: relative;left:4%">2016-02-18 23:40:58</b>
        </div>
        <div class="content-right-div">
            <div class="triangle-right-div"></div>
            要知道我们是攒了多少个吃泡面的日子才买到了一个名牌包包
        </div>

        <div class="head-pic-div">
            <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
        </div>
        <div class="head-nickName-div">
            <b>风中叶</b><br/>
            <b style="font-size: 9px">2016-02-18 23:40:58</b>
        </div>
        <div class="content-div">
            <div class="triangle-div"></div>
            要知道我们是攒了多少个吃泡面的日子才买到了一个名牌包包
        </div>
        <div class="head-pic-right-div">
            <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
        </div>
        <div class="head-nickName-right-div" style="margin-top: 2%">
            <b style="position: relative;left:8%">风中叶</b><br/>
            <b style="font-size: 9px;position: relative;left:4%">2016-02-18 23:40:58</b>
        </div>
        <div class="content-right-div">
            <div class="triangle-right-div"></div>
            要知道我们是攒了多少个吃泡面的日子才买到了一个名牌包包
        </div>

    </div>

    <div id="review-ueditor">
        <script id='editor' type='text/plain'></script>
        <div id="leave-message">留 言</div>
    </div>
    <link type="text/css" rel="stylesheet" href="/css/board/board.css">

    <script type="text/javascript">
        var ue = UE.getEditor('editor');
    </script>
</body>
</html>