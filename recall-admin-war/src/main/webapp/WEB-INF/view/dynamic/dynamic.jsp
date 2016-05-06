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
    <%--<script src="${ctx}/js/jquery.form.js" type="text/javascript" charset="utf-8"></script>--%>
    <script src="${ctx}/js/jquery.utils.js" type="text/javascript" charset="utf-8"></script>
    <script src="${ctx}/js/utils.js" type="text/javascript" charset="utf-8"></script>
    <link  href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
    <link  href="${ctx}/easyui/themes/metro/easyui.css" rel="stylesheet" type="text/css" />
    <%--图片弹出层--%>
    <script src="${ctx}/js/magnific-popup/jquery.magnific-popup.js"></script>
    <link rel="stylesheet" href="${ctx}/js/magnific-popup/magnific-popup.css">
    <%--图片弹出层结束--%>
</head>

<body>
<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <%--<shiro:hasPermission name="dynamic:delete">--%>
               <li id="deleteBtn" class="click"><span><img src="${ctx}/images/t03.png" /></span>删除</li>
            <%--</shiro:hasPermission>--%>
        </ul>
    </div>
</div>

<div>
    <table id="tt"></table>
</div>

<script type="text/javascript" charset="UTF-8">
    var file_server_host =  getFileServerHost(0);
    $(function(){
        regBtnEvents();
        page();
    });

    function page(){
        $('#tt').datagrid({
            url:'${ctx}/dynamic/page',
            pagination:true,
            rownumbers : true,
            fitColumns : true,
            collapsible : true,
            autoRowHeight : true,
            loadMsg : "数据加载中,请稍等...",
            frozenColumns : [[{field : 'ck',checkbox : true}]],
            columns:[[
                {title:'ID', field:'id',width:50,align:'center'},
                {title:'动态内容', field:'content',width:50,align:'center'},
                {title:'图片', field:'picturs',width:50,align:'center',
                    formatter: function(value,row,index){
                        var srcs = "";
                        if(value && value.length > 0){
                            for(var i = 0;i<value.length;++i){
                                srcs += file_server_host + value[i].address + ",";
                            }
                            srcs = srcs.substr(0,srcs.lastIndexOf(","));
                        }
                        var str = "<a href='javascript:void(0);' name='look' id='"+row.id+"' style='width:60px;height:25px;' class='easyui-linkbutton' onmouseup='findImage(\""+srcs+"\",event,"+row.id+")'>查看</a>";
                        return str;
                    }
                },
                {title:'创建时间', field:'createDate',width:50,align:'center',
                    formatter:function(value,row,index){
                        if(value){
                            return timeStamp2String(value);
                        }
                    }
                },
            ]],
            onLoadSuccess: function(data){
               $("a[name='look']").linkbutton();
            }
        });
        pagenation();
    }
    function pagenation(){
        var pager = $('#tt').datagrid('getPager');	// get the pager of datagrid
        pager.pagination({
            layout:['list','sep','first','prev','links','next','last','sep','refresh']
        });
    }

    function findImage(srcs,event,id){
        $("#tt").datagrid("uncheckAll");
        bindImage(srcs,event,id);
    }
    var url=null;
    function regBtnEvents(){
        // 删除按钮
        $("#deleteBtn").click(function(e){
            del();
        });
    }
    var options = {
        beforeSubmit: function(){
            if($('#dynamicForm').form('validate')){
                pro();
                $('#dynamicDialog').dialog('close');
                return true;
            }else return false;
        }, success: function(responseText){
            hide();
            $.messager.alert('提示',responseText, 'info');
            $('#tt').datagrid('clearSelections');
            $('#tt').datagrid('reload');
        }, error:function(resp){
            hide();
            $('#dynamicDialog').dialog('open');
            $.messager.alert('提示',eval(resp.responseText), 'info');
        }, type:'post'
    };
    function del(){
        var ids =  getGridSelects();
        if(null==ids || ids.length <1)
            return null;
        $.messager.confirm('提示', '确定要删除该动态吗?', function(yes){
            if(yes){
                pro();
                $.ajax({type:'GET',url:'${ctx}/dynamic/delete',data:{'ids':ids},
                    success:function(text,status,xhr){
                        $("#tt").datagrid("reload");
                       $.messager.alert('提示',text);
                        $("#tt").datagrid("clearSelections");
                        hide();
                    },error:function(e){
                        hide();
                        $.messager.alert('提示',e.responseText);
                    }
                });
            }
        });
    }
    // 获取单选
    function getGridSelect(){
        var chks= $('#tt').datagrid('getChecked');
        if(null!=chks && chks.length==1){
            return chks[0].id;
        }else{
            $.messager.alert('提示',"请选择一项进行操作!",'warning');
            return null;
        }
    }
    // 获取多选
    function getGridSelects(){
        var chks= $('#tt').datagrid('getChecked');
        if(chks.length<1){
            $.messager.alert('提示','请至少选择一项!','warning');
            return ;
        }
        var arr = new Array();
        for(var c in chks){
            arr[c] = chks[c].id;
        }
        return arr;
    }
</script>
</body>
</html>