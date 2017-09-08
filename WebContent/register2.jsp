<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>无涯测评通行证 注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/easyfrom.css"  >
<link rel="stylesheet"href="${pageContext.request.contextPath}/css/style.css">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/p167.css"> --%>
<script src="${pageContext.request.contextPath}/js/jquery-1.js"></script>
<script src="${pageContext.request.contextPath}/js/p167.js"></script>
<script src="${pageContext.request.contextPath}/js/ToolX3.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/V92Register.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"
	type="text/javascript"></script>	
<script src="${pageContext.request.contextPath}/js/easyform.js.js"
	type="text/javascript"></script>
<style type="text/css">
.icoRight {
	display: none;
}
/* 最外层div用icoError会自动隐藏 */
.p167-permit-form1 input.pwdReg {
	border-bottom: 1px solid #ebebeb;
}

.p167-permit-form1 input.vcodeInput {
	width: 100px;
	height: 52px;
	line-height: 52px;
	padding-left: 0
}

.p167-permit-form1 input.p167-permit-phone2 {
	border-bottom: 0;
}
.p167-passportbox {
	text-align: center;
	margin-top: 40px;
}

.p167-passportleft {
	border-right: 1px solid #bebebe;
	padding-right: 10px;
	margin-right: 10px;
}
</style>
<style type="text/css">
.PublicHeaderWrap {
	background-color: #4ab2c8;
	height: 70px;
	width: 100%;
	z-index: 2;
	position: relative;
}

.PublicHeader {
	width: 960px;
	height: 100%;
	margin: 0 auto;
	position: relative;
}

.PublicHeader .pLogo {
	float: left;
	width: 300px;
	height: 40px;
	margin-top: 15px;
	background: url(images/logo.png) 0 50% no-repeat;
	overflow: hidden;
}

.PublicHeader .pLogo a {
	display: block;
	width: 100%;
	height: 100%;
}

.PublicHeader .pphone {
	position: absolute;
	top: 1000px;
	right: 10px;
}

.PublicHeader .p400 {
	float: right;
	font-size: 16px;
	color: #fff;
	background: url(images/icon-phone-32.png) 0 center no-repeat;
	height: 70px;
	line-height: 70px;
	padding-left: 32px;
	padding-right: 40px;
}

.PublicHeader .p400 a {
	color: #fff;
	text-decoration: none;
}

.PublicHeader .p400 a:hover {
	color: #fff;
	text-decoration: none;
}
</style>
<script type="text/javascript">
	$(function(){
		
		//给form元素绑定onsubmit事件函数
		$("#button").click(function(){
			//清空上次提示信息
			$("#name_error").html("");
			$("#password_error").html("");
			$("#repassword_error").html("");
			$("#email_error").html("");
			var check = true;//表单通过检查
			//检查用户名
			
			var login_name = $("#login_name").val().trim();
			if(login_name==""){
				$("#name_error").html("用户名不能为空!");
				check = false;
			}
			
			//检查密码
			var password = $("#password").val().trim();
			if(password==""){
				$("#password_error").html("密码不能为空!");
				check = false;
			}
			//检查确认密码
			var repassword = $("#repassword").val().trim();
			if(repassword==""){
				$("#repassword_error").html("确认密码不能为空!");
				check = false;
			}else if(repassword != password){
				$("#repassword_error").html("两次输入的密码不一致!");
				check = false;
			}
			//检查邮箱
			
			var email = $("#email").val().trim();
			if(email==""){
				$("#email_error").html("邮箱不能为空!");
				check = false;
			}
			
			//TODO检查验证码
			//都通过检测允许提交表单
			return check;
		});
	});

</script>  
</head>


<body style="min-height: 800px;">
	<form name="regist_form" method="get" action="register.do" id="form">
		<div>
			<input name="__VIEWSTATE" id="__VIEWSTATE"
				value="WlDrA1ym1M20foTvn4eid2IuumgBSzDH5s5CPjawiUzLiEzPIidIjFvPnUEIylivAKBg7dMtA8C+qMKbjjoKOL+c59S7050GS1SlZbSAWB6joLsGo2Imj6ltImc="
				type="hidden">
		</div>

		<div>

			<input name="__EVENTVALIDATION" id="__EVENTVALIDATION"
				value="iXvCDK++6NLTAr7s2I701C1fkrQCG80CheIIcrG4BXZ151o4+l7kUa8WXAiJYnHhhNETuS8ToqCEcMYsEsZ3Onow2Wpt9UhmyqC0qqXWvQ5qZ7L7SX4lIVgSjitpE6Rm20sPZ4VkwZELpHoGj55Fk7ml+KDDREgxwpzoxRzPD++9a2sx+IuZf5SwE/bbU+vWiuqspCzsjZ7XY6UswDk7qRPRTnEgpWoLDZzymERKmYDT/PUwCA5RtwNLato="
				type="hidden">
		</div>


		<script src="${pageContext.request.contextPath}/js/m2pc_m2.js"></script>


		<div class="p167-nav">
			<div class="PublicHeaderWrap">
				<div class="PublicHeader">
					<div class="pLogo">
						<a href="#" data-tg="PublicHeader|PublicHeader-Logo"></a>
					</div>
					<div class="p400">888-010-8888</div>
					<span class="p167-nav-in-right"><a href="#" class="toplink1">登录</a><span
						class="p167-nav-in-right-s">|</span><a href="#"
						class="p167-nav-in-right-register toplink2">返回首页</a></span>

				</div>
			</div>

		</div>



		<div class="p167-permit" style="margin-bottom: 0; position: relative;">

			<div class="" id="txtUserIcon"
				style="position: absolute; top: -85px; left: 0;">
				<i></i><span id="txtUserTip"></span>
			</div>

			<h1>注册无涯通行证</h1>

			<div class="p167-permit-form1">

				<input name="login_name" id="login_name"
					class="p167-permit-phone " placeholder="请输入昵称"  value="${user.loginName }" type="text">
					<span style="color:red" id="name_error">${name_error }</span>
				<input name="password" maxlength="20" id="password" class="pwdReg"
					placeholder="请输入至少6位密码" type="password"> 
					<span style="color:red" id="password_error"></span>
				<input name="repassword" maxlength="20" id="repassword" class="pwdReg"
					placeholder="请再次输入密码" type="password">
					<span style="color:red" id="repassword_error"></span>
				<input name="email" id="email"
					placeholder="请输入邮箱"  value="${user.email }" type="text" >
					<span style="color:red" id="email_error"></span>

                <input class="p167-bind-btn" type="submit" id="button" name="button" value="注册" />
		</div>

		<!--20160825改S-->

		<div class="p167-passportbox">
			<a href="${pageContext.request.contextPath}/common_login.jsp"
				class="p167-passport p167-passportleft" style="display: inline;">
				<span>通行证登录</span> <i></i>
			</a> <a href="${pageContext.request.contextPath}/manager_login.jsp"
				class="p167-passport" style="display: inline;"> <span>管理员登录</span>
				<i></i>
			</a>
		</div>
</div>
<style type="text/css">
.p167-passportbox {
	text-align: center;
	margin-top: 40px;
}

.p167-passportleft {
	border-right: 1px solid #bebebe;
	padding-right: 10px;
	margin-right: 10px;
}
</style>

		<!--20160825改E-->

		<div class="p167-footer">
			<p>Copyright Neworiental Corporation, All Rights Reserved</p>
			<p>© 无涯 版权所有</p>
		</div>

	</form>
</body>
</html>