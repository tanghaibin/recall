<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/context/context.jsp" %>
<!DOCTYPE>
<html>

<head>
	<title>登录</title>
		<meta charset="utf-8">
		<link href="../../../css/login.css" rel='stylesheet' type='text/css' />
	<script src="${ctx}/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="/js/login.js"></script>
	<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
</head>
<br>
	<form action="${ctx}/login" method="post" id="login-form">
		<div id="content-div">
			<div id="top-div">
				<div id="login-div" class="selected-type">快速登录</div>
				<div id="regist-div" class="selected-type">快速注册</div>
			</div>
			<canvas id="canvas"></canvas>
		</div>
	</form>


<div id="login-content-div" style="">
	<label class="error-label">${msg}</label>
	<div class="input-div">
		账号：<input type="text" name="email" required="required" value="${user.email}"/>
	</div>
	<div class="input-div">
		密码：<input type="password" name="pswd" required="required" value="${user.pswd}"/>
	</div>
	<div id="login-btn">登 录</div>
</div>
<div id="register-content-div" style="display: none">
	<label class="error-label">${msg}</label>
	<div class="input-div">
		&nbsp;&nbsp;&nbsp;&nbsp;用户名：<input type="text" name="username"  value="${user.username}" class="easyui-validatebox" data-options="required:true,validType:'length[1,10]'"/>
	</div>
	<div class="input-div">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账号：<input type="text" name="email"  value="${user.email}" class="easyui-validatebox" data-options="required:true,validType:'email'"/>
	</div>
	<div class="input-div">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：<input type="password" name="pswd"  id="pswd" value="${user.pswd}" class="easyui-validatebox" data-options="required:true,validType:'length[3,10]'"/>
	</div>
	<div class="input-div">
		确认密码：<input type="password" name="confirmPswd" value="${user.confirmPswd}" class="easyui-validatebox" data-options="required:true,validType:{length:[3,10],equals:['#password']}"/>
	</div>
	<div id="register-btn">注 册</div>
</div>

<script type="text/javascript">

	if('${type}' != ''){
		displayLoginContent(${type});
	}else{
		displayLoginContent(${1});
	}


	$.extend($.fn.validatebox.defaults.rules, {
		equals: {
			validator: function(value,param){
				return value == $("#pswd").val();
			},
			message: '确认密码必须与原密码匹配'
		}
	});
</script>
</body>
</html>