<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../../context/context.jsp" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Infusion WP Theme</title>
    <link href="${ctx}/css/dynamic/dynamic.css" rel="stylesheet">
    <link href="${ctx}/css/common/common.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/css/styles.css">
    <link rel="stylesheet" href="${ctx}/css/queries.css">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <![endif]-->
    <script src="${ctx}/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/scripts.js"></script>
    <script src="${ctx}/js/unslider.min.js"></script>
    <%--swiper--%>
    <link rel="stylesheet" type="text/css" href="/swiper/swiper.min.css">
    <%--easyui--%>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <%--ueditor--%>
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/lang/zh-cn/zh-cn.js"></script>
    <%--<script type="text/javascript" src="/ueditor/custom/custom.js"></script>--%>

    <style type="text/css">
        /*div{*/
        /*width:100%;*/
        /*}*/
    </style>
    <%--webuploader--%>
    <link href="${ctx}/uploader/webuploader.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/uploader/uploads.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/uploader/webuploader.min.js" type="text/javascript" charset="UTF-8"></script>
    <script type="text/javascript" src="/js/utils.js"></script>
    <script type="text/javascript" src="/js/common/common.js"></script>

    <script type="text/javascript">
        var mySwiper = null;
        function myClose(){
            $("#zz").fadeOut("normal");
            mySwiper.removeAllSlides(); //移除全部
            mySwiper.destroy(false); //移除所有slide监听事件，所以拖动和click事件失效了。
        }
    </script>

    <style>
        body {
            background: #eee;
            font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
            font-size: 14px;
            color:#000;
            margin: 0;
            padding: 0;
        }
        .swiper-container {
            width: 1300px;
            height: 700px;
            margin: 20px auto;
            top:10%;
        }
        .swiper-slide {
            text-align: center;
            font-size: 18px;
            background: #fff;

            /* Center slide text vertically */
            display: -webkit-box;
            display: -ms-flexbox;
            display: -webkit-flex;
            display: flex;
            -webkit-box-pack: center;
            -ms-flex-pack: center;
            -webkit-justify-content: center;
            justify-content: center;
            -webkit-box-align: center;
            -ms-flex-align: center;
            -webkit-align-items: center;
            align-items: center;
        }
    </style>
    <!-- Swiper JS -->
    <script src="/swiper/swiper.min.js"></script>
</head>

<body>



<div id="zz" style="width: 100%; height: 100%; z-index: 999; background: rgba(0, 0, 0, 0.42); position: absolute;display: none ">
    <a href="javascript:void(0);"><img style="position: relative;width:50px;height:50px;float:right;top:50px;right:50px;z-index: 1000" src="/img/x.png" onclick="myClose()"/></a>
    <%--<div style="position: relative;text-align: center;top:20%">--%>
        <%--<img id="img" style="width:auto;height:500px"/>--%>

        <!-- Swiper -->
        <div class="swiper-container">
            <div class="swiper-wrapper">

            </div>
        </div>
    <%--</div>--%>
</div>


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
                        $("#a${count.index}${count2.index}").click(function(){

                            var a = $(this).parent().find(".dynamic-img");
                            var container = $('.swiper-wrapper');
                            $("#zz").fadeIn("fast",function(){
                                $.each(a,function(i,v){
                                    var path = $(this).attr("src");
                                    var div = $("<div class='swiper-slide'><img  src='"+path+"' /></div>");
                                    container.append(div);
                                });
                                mySwiper = new Swiper('.swiper-container', {
                                    pagination: '.swiper-pagination',
                                    effect: 'cube',
                                    grabCursor: true,
                                    keyboardControl : true,
                                    mousewheelControl : true,
                                    cube: {
                                        shadow: true,
                                        slideShadows: true,
                                        shadowOffset: 20,
                                        shadowScale: 0.94
                                    }
                                });
                            });
                        });
                    </script>
                </c:forEach>
            </div>

            <div id="dynamic-option-div" class="easyui-panel" style="width:700px;height:auto;padding:10px;background: #FAFAFA;">
                <ul class="ul-inline"><div style="background: url('/img/icon.png');background-position: -224px -106px;width: 16px;height: 16px;"></div>
                    <li id="review-icon-${data.id}"><label>评论</label></li><div style="background: url('/img/icon.png');background-position: -224px -26px;width: 16px;height: 16px;"></div>
                    <li><label>赞</label></li><div style="background: url('/img/icon.png');background-position: -224px -130px;width: 16px;height: 16px;"></div>
                    <li><label>转发</label></li>
                </ul>
            </div>

            <div id="review-div-content" class="easyui-panel" style="width:700px;height:auto;padding:10px;background: #FAFAFA;">
                    <div style="float:left"><b style="color:#A4B3C3 ">小明</b> 回复：今天天气好！</div><label></label><div></div>
                    <div><b style="color:#A4B3C3 ">小红</b> 回复 <b style="color:#A4B3C3 ">小明</b>：是啊！如果能出去玩就好了</div><br/>
                    <div>小明 回复 小红：我今天不上班；在外面晒太阳呢</div><br/>
                    <div>小红 回复 小明：那你多幸福啊；真让我羡慕</div>
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
            <c:when test="${requestScope.data.pageNumber+1 < (requestScope.data.total%10==0?requestScope.data.total/10:requestScope.data.total/10+1)-1}">
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

<%--ueditor div--%>
<div id="review-ueditor" style="display: none;height: 170px;">
    <script id='editor' type='text/plain' style='width:670px;height:60px;z-index:0'></script>
    <a id="publish-review-btn" href="javascript:void(0);" class="easyui-linkbutton" style="width: 90px;height: 40px;position: relative;top: 5px;right:-570px;border-radius: 7px;">发 表</a>
</div>

<div id="login-dialog" style="display: none;z-index:1000;width: 80%;height: 80%;position: absolute;top:80px;left:140px;background: rgba(0, 0, 0, 0.42);">
    22222
    <a href="javascript:void(0);"><img style="position: relative;width:50px;height:50px;float:right;top:50px;right:50px;z-index: 1000" src="/img/x.png" onclick="login_dialog_close()"/></a>
</div>
    <script type="text/javascript">
        /**
        *初始化uedtor
         */
        var ue = UE.getEditor('editor');
        var type = 0;//评论动态还是评论：0动态1评论
        var dynamic_id = null;//动态id
        $(function(){
            regEvent();
        });

        function regEvent(){

            //注册发布评论事件
            $("#publish-review-btn").click(function(){
                var content = ue.getContentTxt();
                if(content.length > 100){
                    $.messager.alert("提示","字数只能在100个字符之内");
                    return false;
                }
                var data = null;
                var content = ue.getContent();
                data = {"content":content,"resourceId":dynamic_id,"type":type};
                publishReview(data);
            });


            //循环注册点击评论事件
            var count = 0;
            var cur = null;
            $.each($(".ul-inline"),function(){
                var obj = $(this);
                obj.find("li:first").click(function(){
                    if($(this).parent().parent().parent().next().children().next().attr("id") == "review-ueditor" && $(this).parent().parent().parent().next().children().next().css("display") != "none"){
                        //$(this).parent().parent().next().css("display","none");
                        $('#review-ueditor').slideUp('slow', function() {
                            // Animation complete.
                        });
                        return;
                    }
                    type = 0;
                    var li_id = $(obj.find("li:first")).attr("id");
                    dynamic_id = li_id.substr(li_id.lastIndexOf("-")+1,li_id.length);
                    obj.parent().parent().next().append($("#review-ueditor"));
                    //$("#review-ueditor").css("display","inline");
                    $('#review-ueditor').slideDown('slow', function() {
                        // Animation complete.
                    });
                });
            });


            //循环注册在评论中点击评论图标事件
            $.each($("div[id='review-div-content'] label"),function(){
                $(this).click(function(){
                    var obj = $(this);
                    if($(this).next().children().attr("id") == "review-ueditor" && $(this).next().children().css("display")!="none"){
                        $('#review-ueditor').slideUp('slow', function() {
                            // Animation complete.
                        });
                        return;
                    }
                    $(this).next().append($("#review-ueditor"));
                    type = 1;
                    $('#review-ueditor').slideDown('slow', function() {
                        //ue.setContent("<b style='color:#EEEEEE'>回复"+ obj.prev().children().html()+"：</b>",false);
                    });
                })
            });
        }

        /**
        *关闭登录框
         */
        function login_dialog_close(){
            $("#login-dialog").slideUp("slow",function(){});
        }

        /**
        *发布评论
        * @param data
         */
        function publishReview(data){
            $.ajax({
                url:'${ctx}/dynamic/review/add',
                type:'POST',
                data:data,
                success: function(data){
                    $("#login-dialog").slideDown("slow",function(){});
                },
                error:function(e){
                    $.messager.alert("提示", e.responseText);
                }
            })
        }
    </script>
</body>
</html>