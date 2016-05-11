<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="/context/context.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>注册</title>
		<meta charset="utf-8">
		<link href="../../../css/login.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

	<script src="${ctx}/js/jquery-1.8.3.min.js"></script>	<%--easyui--%>
	<link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
	<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">

</head>
<body>
	 <!-----start-main---->
	 <div class="main">
		<div class="login-form">
			<h1>Sign up to Recall</h1>
					<div class="head">
						<img src="../../../image/user.png" alt=""/>
					</div>
					<form:form modelAttribute="userCustom" action="${ctx}/user/add" method="post" id="registForm">
					<label class="error-label"><form:errors path="username"></form:errors></label><br/>
						Username
					<input type="text" name="username" value="${requestScope.userCustom.username}" class="easyui-validatebox" data-options="required:true,validType:'length[1,10]'"/>
					<label class="error-label"><form:errors path="email"></form:errors></label><br/>
					Email Address
						<input type="text" name="email" value="${requestScope.userCustom.email}" class="easyui-validatebox tb" data-options="required:true,validType:'email'" />
					<label class="error-label"><form:errors path="pswd"></form:errors></label><br/>
					Password
						<input type="password" name="pswd" id="password" value="${requestScope.userCustom.pswd}" class="easyui-validatebox" data-options="required:true,validType:'length[3,10]'"/>
					<label class="error-label"><form:errors path="confirmPswd"></form:errors></label><br/>
					Confirm Password
						<input type="password" name="confirmPswd" class="easyui-validatebox" value="${requestScope.userCustom.confirmPswd}" data-options="required:true,validType:{length:[3,10],equals:['#password']}"/>
						<div class="submit">
							<input type="submit" value="Register"/>
					</div>	
					<%--<p><a href="#">Forgot Password ?</a></p>--%>
				</form:form>
			</div>
		</div>
			 <!-----//end-main---->

 <script type="text/javascript">
	 $.extend($.fn.validatebox.defaults.rules, {
		 equals: {
			 validator: function(value,param){
				 return value == $(param[0]).val();
			 },
			 message: '确认密码必须与原密码匹配'
		 }
	 });
	 $("#registForm").submit(function(){
		 if($("#registForm").form("validate")){
			 return true;
		 }
		 return false;
	 })
 </script>
</body>
</html>