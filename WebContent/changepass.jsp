<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>重置密码 - 企业账户管理</title>
<link href="${pageContext.request.contextPath}/css/normalize.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/p116.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/respond.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js">
</script>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/changepass.do" id="form1">
		<div class="aspNetHidden">
			<input name="__VIEWSTATE" id="__VIEWSTATE"
				value="zk9MVwStGmndXg7Z4kF0sa1CVyXBP5JuVTg0CFJRuAt17hRj7YQnSQ9AEdB6DzWMOvew0JC8BFLtcNkPwbDH8iI1j+/aKsHS3IKQda2PLRaNW9UaN5caX96TkSqSbrYp2IHwwp9bf43ctQs37CvIkw=="
				type="hidden">
		</div>

		<div class="aspNetHidden">

			<input name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR"
				value="D51752D0" type="hidden"> <input
				name="__EVENTVALIDATION" id="__EVENTVALIDATION"
				value="qiz6NXASS9tBVvmDj43tp5kM7M31h4YZTlfk4C85joNPpvHgi7xT08htfh0/FcOXe7sDeaNJZDnbqvSKL595WrLW4DMI0kc4fLVmL2GlxskbWTMfjK0s8Phnx6LCxcQebA5gnl0DLPfWJWIPW9i1FyYmcNwoUk/doLVar8M3HYAy8XcyCOWDFrPZPYCvUPoH"
				type="hidden">
		</div>
		<!--riaHtmlStart-->
		<div class="PublicHeaderWrap">
			<div class="PublicHeader">
				<div class="pLogo">
					<a href="#"
						data-tg="PublicHeader|PublicHeader-Logo"></a>
				</div>
				<div class="p400">888-010-8888</div>
			</div>
		</div>

		<div id="divstep1" class="GridMainWrap">
			<div class="GridMain">
				<div style="height: 10px"></div>
				<div class="p116-info">
					<h2>重置密码 Reset Password</h2>
					<div class="p116-info-item">(提示：请填写您要重置的密码)</div>
					<div class="p116-info-item">
						<label class="mTitle" style="width: 200px;">用户名：</label>
						<div class="mInputBlock">
							<input name="login_name" id="login_name" placeholder=""
								class="mSelectInput" type="text" value="<%=request.getSession().getAttribute("username")%>" disabled="disabled">
								<span style="color: red" id="name_error">${name_error }</span>
						</div>
					</div>
					<div class="p116-info-item">
						<label class="mTitle" style="width: 200px;">旧密码：</label>
						<div class="mInputBlock">
							<input name="password" id="password" placeholder=""
								class="mSelectInput" type="password">
								<span style="color: red" id="password_error">${password_error }</span>
						</div>
					</div>
					<div class="p116-info-item">
						<label class="mTitle" style="width: 200px;">新密码：</label>
						<div class="mInputBlock">
							<input name="password1" id="password1" placeholder=""
								class="mSelectInput" type="password">
						</div>
					</div>
					<div class="p116-info-item">
						<label class="mTitle" style="width: 200px;">再次输入新密码：</label>
						<div class="mInputBlock">
							<input name="password2" id="password2" placeholder="" 
								class="mSelectInput" type="password">
						</div>
					</div>

					<div class="p116-info-item p116-margin-top">
						<label class="mTitle" style="width: 200px;">&nbsp;&nbsp;</label>
						<div class="mInputBlock">
							<input name="loginBtn" value="确认更改" id="loginBtn"
								class="ButtonBlue" type="submit">
						<span style="color: red">${success}</span>
						</div>
					</div> 
				</div>
			</div>
		</div>

		<!-- 第二步 -->
		<!--riaHtmlStart-->
		<div class="PublicFooter">
			<div class="pCopyright">
				<div class="pQRcodeWrap">
					<div class="pQRcode">
						<img src="${pageContext.request.contextPath}/images/qrcode.png">
						<p class="pQRcodeTips">扫一扫下载云办公</p>
					</div>
				</div>
				<p>无涯教育科技集团有限公司</p>
				<p>Copyright 2011-2015 Neworiental Corporation, All Rights
					Reserved</p>
				<p>
					<em>©</em> 2011-2015 无涯 版权所有
				</p>
			</div>
		</div>
		<!--riaEnd-->
	</form>
</body>
</html>