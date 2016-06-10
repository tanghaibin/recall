$(function(){
    penLine();
    regevednt();
});
/**
 * 绘制直线
 */
function penLine(){
    var canvase = document.getElementById("canvas");
    var context = canvase.getContext("2d");
    context.beginPath();
    context.lineCap='butt';
    context.moveTo(0,20);
    context.lineTo(300,20);
    context.stroke();
}

/**
 * 注册事件
 */
function regevednt(){
    $("#login-btn").click(function(){
        $("#login-form").submit();
    });
    $("#register-btn").click(function(){
        $("#login-form").attr("action",'/user/add');
        $("#login-form").submit();
    });
    $("#login-div").click(function(){
        $("#canvas").nextAll().remove();
        $("#content-div").css("height","300px");
        displayLoginContent(1);
        /**
         * 重新注册登录按钮事件
         */
        $("#login-btn").click(function(){
            $("#login-form").submit();
        });
    });
        $("#regist-div").click(function(){
            $("#canvas").nextAll().remove();
            $("#content-div").css("height","400px");
                displayLoginContent(0);
        /**
         * 注册注册按钮事件
         */
        $("#register-btn").click(function(){
            if(validate()){
                $("#login-form").attr("action",'/user/add');
                $("#login-form").submit();
            }
        });
    });
}
/**
 * 根据type区分登录框应该显示什么内容  登录or注册  type0注册1登录
 * @param type
 */
function displayLoginContent(type){
    $(".selected-type").css("background-color","");
    $(".selected-type").css("color","");
    if(type == 0){
        $("input[class*='validatebox-invalid']").validatebox('readonly',false);
        $("#content-div").css("height","400px");
        $("#content-div").append($("#register-content-div").html());
        $("#register-btn").css("margin-left","35%");
        $(".input-div").css("padding-left","18%");
        $("#top-div").css("padding-left","15%");

        $("#regist-div").css("background-color","#2194DE");
        $("#regist-div").css("color","white");
    }else if(type == 1){
        $("#content-div").css("height","300px");
        $("#content-div").css("width","30%");
        $("#content-div").append($("#login-content-div").html());
        $(".input-div").css("padding-left","22%");

        $("#login-div").css("background-color","#2194DE");
        $("#login-div").css("color","white");
    }
}
/**
 * 提交时校验
 */
function validate(){
    if($("#login-for").form("validate")){
        return true;
    }
    return false;
}
