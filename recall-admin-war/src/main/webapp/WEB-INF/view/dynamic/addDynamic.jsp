<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../context/context.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>动态列表</title>
    <script src="${ctx}/js/jquery-1.11.3.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${ctx}/js/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${ctx}/js/jquery.form.js" type="text/javascript" charset="utf-8"></script>
    <script src="${ctx}/js/jquery.utils.js" type="text/javascript" charset="utf-8"></script>
    <script src="${ctx}/js/utils.js" type="text/javascript" charset="utf-8"></script>
    <link  href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
    <link  href="${ctx}/easyui/themes/metro/easyui.css" rel="stylesheet" type="text/css" />
    <%--ueditor--%>
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        /*div{*/
            /*width:100%;*/
        /*}*/
    </style>
    <%--webuploader--%>
    <link href="${ctx}/uploader/webuploader.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/uploader/uploads.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/uploader/webuploader.min.js" type="text/javascript" charset="UTF-8"></script>
    <%--旋转条--%>
    <script src="${ctx}/js/cvi_busy_lib.js"></script>
</head>

<%--<body>--%>
<div id="rotate">
    <div style="margin-left: 200px;">
        <script id="editor" type="text/plain" style="width:1024px;height:300px;"></script>
        <div class="easyui-panel" id="picturs-panal" style="width:1024px;height:auto;">
            <div id="uploader" class="wu-example">
                <div class="queueList">
                    <div id="dndArea" class="placeholder">
                        <div id="filePicker" class="webuploader-container">
                            <div class="webuploader-pick">点击选择图片</div>
                            <div id="rt_rt_1aa3i7qpsssq4n7q8g12gi18oh1" style="position: absolute; top: 0px; left: 448px; width: 168px; height: 44px; overflow: hidden; bottom: auto; right: auto;">
                                <input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept="image/*"/>
                                <label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>
                            </div>
                        </div>
                        <p>可以尝试文件拖拽，使用QQ截屏工具，然后激活窗口后粘贴，或者点击添加图片按钮。</p>
                        <p>最多可选可上传4张轮播图片</p>
                    </div>
                    <ul class="filelist" style="display: none;"></ul>
                </div>
                <div class="statusBar element-invisible" style="">
                    <div class="progress" style="display: none;">
                        <span class="text">0%</span>
                        <span class="percentage" style="width: 0%;"></span>
                    </div><div class="info">共0张（0B），已上传0张</div>
                    <div class="btns">
                        <div id="filePicker2" class="webuploader-container">
                            <div class="webuploader-pick">继续添加</div>
                            <div id="rt_rt_1aa3i7qq2g0d1256sr0fq5suh6" style="position: absolute; top: 0px; left: 10px; width: 94px; height: 42px; overflow: hidden; bottom: auto; right: auto;">
                                <input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept="image/*">
                                <label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>
                            </div>
                        </div>
                        <div class="uploadBtn state-pedding">开始上传</div>
                    </div>
                </div>
            </div>
        </div>
        <div style="float: right;margin-right: 270px;margin-top:20px;" onclick="release()">
            <a href="#" class="easyui-linkbutton" style="width:100px;height:50px;border-radius: 5px;">发布动态</a>
        </div>
    </div>
<%--</body>--%>
<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    var flag = false;
    /**
     *自定义上传图片按钮
     */
    UE.registerUI('button', function(editor, uiName) {
        //注册按钮执行时的command命令，使用命令默认就会带有回退操作
        editor.registerCommand(uiName, {
            execCommand: function() {
                if(flag){
                    $("#picturs-panal").fadeIn("slow");
                    flag = false;
                }else{
//                    $("#picturs-panal").css("display","none");
                    $('#picturs-panal').fadeOut("slow");
                    flag = true;
                }
            }
        });
        //创建一个button
        var btn = new UE.ui.Button({
            //按钮的名字
            name: '添加图片',
            //提示
            title: '添加图片',
            //添加额外样式，指定icon图标，这里默认使用一个重复的icon
            cssRules: 'background-position: -380px 0px',
            //点击时执行的命令
            onclick: function() {
                //这里可以不用执行命令,做你自己的操作也可
                editor.execCommand(uiName);
            }
        });
        //当点到编辑内容上时，按钮要做的状态反射
        editor.addListener('selectionchange', function() {
            var state = editor.queryCommandState(uiName);
            if (state == -1) {
                btn.setDisabled(true);
                btn.setChecked(false);
            } else {
                btn.setDisabled(false);
                btn.setChecked(state);
            }
        });
        //因为你是添加button,所以需要返回这个button
        return btn;
    });
/**
*发布动态
 */
    function release(){
        var content = UE.getEditor('editor').getContent();
        var picJson = [];
        if(pics && pics.length>0){
            for(var i = 0;i<pics.length;++i){
                picJson.push({"address":pics[i]._raw});
            }
        }
        var jsonString = {"content":content,
            "picturs":picJson
        };
        //旋转条
        try {lval.remove(); lval='';}catch(e) {lval=getBusyOverlay(document.getElementById("rotate"),{color:'black', opacity:0.5, text:'loading', style:'text-decoration:blink;font-weight:bold;font-size:12px;color:white'},{color:'#fff', size:100, type:'o'});};

        $.ajax({
            url:'${ctx}/dynamic/add',
            data:{"dynamicString":JSON.stringify(jsonString)},
            type:'POST',
            success: function(data){
                $.messager.alert("提示",data);
                lval.remove();
            },
            error:function(e){
                $.messager.alert("错误", e.responseText);
                lval.remove();
            }
        })
    }
</script>
<script type="text/javascript">
    var BASE_URL = '${ctx}';
    var pics = new Array();
</script>
<script src="${ctx}/uploader/uploads.js" type="text/javascript" charset="UTF-8"></script>
</html>