<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/context/context.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>登录</title>
		<meta charset="utf-8">
		<link href="../../../css/login.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
	 <!-----start-main---->
	 <div class="main">
		<div class="login-form">
			<h1>Sign in to Recall</h1>

					<div class="head">
						<img src="../../../image/user.png" alt=""/>
					</div>

				<form:form action="${ctx}/login">
						<p style="color: red">${requestScope.msg}</p><br/>
						<input type="text" class="text" name="email" value="${requestScope.user.email}"  />
						<input type="password" name="pswd" value="${requestScope.user.pswd}"/>
						<div class="submit">
							<input type="submit" onclick="myFunction()" value="LOGIN" >
					</div>	
					<p><a href="#">Forgot Password ?</a></p>
				</form:form>
			</div>
		</div>
			 <!-----//end-main---->
		 		
 
</body>
</html>