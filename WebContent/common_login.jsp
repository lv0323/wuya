<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>无涯通行证 登录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script src="${pageContext.request.contextPath}/js/jquery-1.js"></script>
<script src="${pageContext.request.contextPath}/js/p167.js"></script>

<script src="${pageContext.request.contextPath}/js/ToolX3.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/V8Index.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function RefreshImage() {
		RefreshImageById("Image1");
	}

	function clickbtnNext() {
		if (Verify())
			$("#btnNext").click();
	}
</script>

<script type="text/javascript">
	var enableStat = "0"; //ga统计js全局变量
</script>
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

.icoRight {
	display: none;
}
/* 最外层div用icoError会自动隐藏 */
.p167-permit-form1 input.p139-input {
	height: 52px;
	line-height: 52px;
}

.p167-permit-form1 input.p139-input-n2 {
	border-top: 1px solid #ebebeb;
	padding-left: 0;
}

.p167-permit {
	padding: 10px 40px 36px 40px;
}

.p167-passportbox {
	text-align: center;
	margin-top: 40px;
}

.p167-passportleft {
	border-right: 1px solid #bebebe;
	padding-right: 10px;
	margin-right: 4px;
}
</style>
<script type="text/javascript">
$(function(){
	//检测cookie是否有用户名，有的话取出来，显示到输入框
	var username = getCookie("user");
	if(username!=""){
		$("#username").val(username);
	}
});

$(function(){
	//点登录按钮会触发<form onsubmit=时间>
	$("#loginBtn").click(function(){
		//先清除上次错误信息
		$("#name_error").html("");
		$("#password_error").html("");
		//检查用户名
		var check = true;//默认表单项通过检测
		var username = $("#username").val().trim();
		if(username==""){
			$("#name_error").html("用户名为空");
			check = false;
		}
		//检查密码
		var password = $("#password").val().trim();
		if(password==""){
			$("#password_error").html("密码为空");
			check = false;
		}
		//确定是否提交表单
		return check;
	});
});
 
</script>
</head>

<body style="min-height: 800px;">
	<form name="form1" method="post" action="${pageContext.request.contextPath}/common_login.do" id="login_form">
		<div>
			<input name="__VIEWSTATE" id="__VIEWSTATE"
				value="aDK0GeseeMaEVomsiaQU9yK8ho1IrP8dHwJo/B9U6rLmrCqJBj4m7KNHdUWUG0XEpN9LinVu2pDveJfw1FwEy55rLwESEdjNC33DHeuaQleKymROEEbnfjOVSA697GaC7q1MlRblTfPjxuTvOklm3Nhtn1tfgppF3wCW5k/g4VrqEdyMjSF3B//QsudH58LRrEzQ13u4oVCwhSta8/mkv/lWCgqz5JHJqLQ+cr1KmNAVvIhCJDf2O31wEmjX2Gi85gyWT+PT+kf3PgsPHl7waZKxYCfyVT1sJ4kJCTFKHxkJ3kzI22I1F+wr1q0tqHcsE+wUA7mpwRnaxQft2yE0CKHCJrxz6lBEZxDV+P4HBLp/DwL/QSYjhIOES3mxxdYgdoeLe//8/FPkTCTuYrodQADgiKtkZJisX6877zL9qUbyEQRwC0Ez8R9uggalHf7uqOPzbeupjD40oQ0xAZ3tDxs+ZeVgWP7UNSC++KX9J+VmJPsU+JZPRyc35cA6KzBbWcXfhgoCyEcCWUtAe5xLX8XsM8ijScnXl8qZzlLOP7jY3xJe/+/oEjcI++ib5qjtrL8SGgh0eee6ep9Qe68nFM6uRXMsRhtMqQJrY1a6uUTiTkMk1MNb0jxP6dIXW02dRo/gh33m6RQkw2lYD4n3wfH771xc8isJJ2P2ro7dIRglp43iuhMxgNQr0OI42O01njt78vyUT7w5t3vy5hfTsaNJh/T0w13Y5mSXgl/hX3yVszn7JtV7+7W6P0jlzyCNl1Wx5Q=="
				type="hidden">
		</div>

		<div>

			<input name="__EVENTVALIDATION" id="__EVENTVALIDATION"
				value="zP/7Kum/I9duk9DYz/wxr5lYHyQmpufqonihdRg9M6wUMP2qZzx/05qQiaBERY9MlK8Szb3x2iutqDXYk3YYG3DiOmS8g7Nh75/j1gckEjjbcCIrH4f7jqKYhHi9+kyJxvCVR8+NnpreiETBKTtsBORhO4fIqgofC3K/UcaZVLMKx/IYBd8huRWpHfbowGcsLZOOL3P93hBz0KKog6AUuq5cvwdNOpPs0Zs3mg=="
				type="hidden">
		</div>


		<script src="${pageContext.request.contextPath}/js/m2pc_m2.js"></script>


		<div class="p167-nav">

			<div class="PublicHeaderWrap">
				<div class="PublicHeader">
					<div class="pLogo">
						<a href="#"
							data-tg="PublicHeader|PublicHeader-Logo"></a>
					</div>
					<div class="p400">888-010-8888</div>
					<span class="p167-nav-in-right"><a
						href="home_index.jsp" class="toplink1">返回首页</a><span
						class="p167-nav-in-right-s">|</span><a
						href="user_register.jsp"
						class="p167-nav-in-right-register toplink2">注册</a></span>

				</div>
			</div>
		</div>
		<div class="p167-permit" style="margin-bottom: 0; position: relative;">
			<h1>无涯通行证 登录</h1>
			<div class="p167-permit-form1">
				<input name="username" id="username" value="${username}"
					class="p167-permit-phone" placeholder="请输入用户名" type="text">
				<span style="color: red" id="name_error">${name_error }</span>
				
				<input name="password" id="password"   class="passkey2"
					placeholder="请输入密码" type="password">
				<span style="color: red" id="password_error">${password_error }</span>
					
				<input name="loginBtn" value="登&nbsp;&nbsp;录" id="loginBtn"
					      class="p167-permit-phone" type="submit" >

			</div>
			<a href="#" class="p167-permit-tips" style="margin-bottom: 0;">忘记密码？</a>
		</div>
		<!--20160825改S-->
		<div class="p167-passportbox">
			<a href="manager_login.jsp" class="p167-passport p167-passportleft"
				style="display: inline;"> <span>管理员登录</span> <i></i>
			</a>
		</div>
		
		<div class="p167-footer">
			<p>Copyright Neworiental Corporation, All Rights Reserved</p>
			<p>© 无涯 版权所有</p>
		</div>
	</form>
</body>
</html>