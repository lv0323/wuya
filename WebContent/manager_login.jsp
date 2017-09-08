<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=640, target-densitydpi=320, user-scalable=0">
<title>无涯员工统一登录平台</title>
<link href="${pageContext.request.contextPath}/css/Login.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.js"
	type="text/javascript"></script>
 <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Login.js">
<script  type="text/javascript"
	src="${pageContext.request.contextPath}/js/layer.js"></script>
	
<script type="text/javascript">
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
<body>

	<div id="js-login-bg" class="ModuleLogin-bg"
		style="position: fixed; z-index: -1; background: transparent none repeat scroll 0% 0%;">
		<div class="backstretch"
			style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; z-index: -999998; position: absolute; width: 1600px; height: 766px;">
			<img
				style="position: absolute; margin: 0px; padding: 0px; border: medium none; max-height: none; max-width: none; z-index: -999999; width: 1600px; height: 771.469px; left: 0px; top: -2.73466px;"
				src="${pageContext.request.contextPath}/images/4.jpg">
		</div>
	</div>
	<form id="form1"  method="post" action="${pageContext.request.contextPath}/admin.do">
		<div class="ModuleLogin-layer">
			<table>
				<tbody>
					<tr>
						<td>
							<div class="ModuleLogin-wrap">
								<div class="ModuleLogin-logo">&nbsp;</div>
								<div class="ModuleLogin-main">
									<div class="tMainWrap" style="">

										<p class="tUserWrap">
											<i class="tUserImg"></i> <input name="username" id="username"
												class="tUser" placeholder="用户名" type="text" >
												<span style="color: red" id="name_error">${name_error }</span>
										</p>
										<p class="tPasswordWrap">
											<i class="tPasswordImg"></i> <input name="password" id="password"
												class="tPassword" placeholder="密码" type="password">
												<span style="color: red" id="password_error">${password_error }</span>
										</p>
										<input name="loginBtn" value="登&nbsp;&nbsp;录" id="loginBtn"
											class="tSubmit" type="submit">
										<p class="tResetPassword">
											<a href="common_login.jsp">用户登录</a>
										</p>
									</div>
									<div class="tQrcodeWrap">
										<div class="tQrcode">&nbsp;</div>
										<div class="tQrcodeTips">扫一扫下载云办公</div>
									</div>
								</div>
							</div>

							<div class="ModuleLogin-Copyright">
								<p>Copyright Neworiental Corporation, All Rights Reserved</p>
								<p>
									<em>©</em>无涯 版权所有
								</p>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>