<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人信息 管理</title>
<link href="${pageContext.request.contextPath}/css/normalize.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/p116.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/respond.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.city.select.js"></script>
<script src="${pageContext.request.contextPath}/js/cityselected.js"></script>
<script src="${pageContext.request.contextPath}/js/prettify.js"></script>
<script src="${pageContext.request.contextPath}/js/selectage.js"></script>
</head>
<body>
	<form id="form1">
		<!--riaHtmlStart-->
		<div class="PublicHeaderWrap">
			<div class="PublicHeader">
				<div class="pLogo">
					<a href="#/"
						data-tg="PublicHeader|PublicHeader-Logo"></a>
				</div>
				<div class="p400">888-010-8888</div>
			</div>
		</div>

		<div id="divstep1" class="GridMainWrap">
			<div class="GridMain">
				<div style="height: 10px"></div>
				<div class="p116-info">
					<h2>个人信息 Personal Information</h2>

					<div class="p116-info-item information_container">
						<div class="edit_div">
							<button type="button"
								class="layui-btn layui-btn-primary layui-btn-small edit_info">
								<i class="layui-icon">编辑&#xe642;</i>
							</button>
						</div>
						<div class="p116-info-item">
							<label for="disabledTextInput" class="mTitle"
								style="width: 200px;">用户名：</label>
							<div class="mInputBlock">
								<div class="show_info">12321321</div>
								<input name="txtMail" id="disabledInput" placeholder="用户名"
									class="form-control update_info" type="text"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<!-- 加class样式jquery has-error -->
							<label class="mTitle" style="width: 200px;">邮箱：</label>
							<div class="mInputBlock">
								<div class="show_info">12321321</div>
								<input name="txtMail" id="inputError" placeholder=""
									class="form-control update_info" type="text">
							</div>
						</div>
						<div class="form-group">
							<!-- 加class样式jquery has-error -->
							<label class="mTitle" style="width: 200px;">年龄：</label>
							&nbsp;&nbsp;
							<div class="show_info">12321321</div>
							<div class="control-group update_info"
								style="display: inline-block;">
								<div class="controls" style="display: inline-block;">
									<select id="user_age">
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<!-- 加class样式jquery has-error -->
							<label class="mTitle" style="width: 200px;">性别：</label>
							&nbsp;&nbsp;
							<div class="show_info">12321321</div>
							<div class="control-group update_info"
								style="display: inline-block;">
								<div class="controls" style="display: inline-block;">
									<input type="radio" name="gender" value="1" checked="checked">
									<label for="gender">男</label> <input type="radio" name="gender"
										value="2"> <label for="gender">女</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<!-- 加class样式jquery has-error -->
							<label class="mTitle" style="width: 200px;">所在地：</label>
							&nbsp;&nbsp;
							<div class="show_info">12321321</div>
							<div class="control-group update_info"
								style="display: inline-block;">
								<label class="control-label" for="province">省份</label>
								<div class="controls" style="display: inline-block;">
									<select id="province">
										<option value="载入中">载入中</option>
									</select>
								</div>
							</div>
							<div class="control-group update_info"
								style="display: inline-block;">
								<label class="control-label" for="city">城市</label>
								<div class="controls" style="display: inline-block;">
									<select id="city">
										<option value="载入中">载入中</option>
									</select>
								</div>
							</div>
						</div>

						<div class="form-group">
							<!-- 加class样式jquery has-error -->
							<label class="mTitle" style="width: 200px;">电话：</label>
							<div class="mInputBlock">
								<div class="show_info">12321321</div>
								<input name="txtMail" id="inputError" placeholder=""
									class="form-control update_info" type="text">
							</div>
						</div>

						<div class="form-group">
							<!-- 加class样式jquery has-error -->
							<label class="mTitle" style="width: 200px;">工作：</label>
							<div class="mInputBlock">
								<div class="show_info"></div>
								<input name="txtMail" id="inputError" placeholder=""
									class="form-control update_info" type="text">
							</div>
						</div>

						<div class="form-group">
							<!-- 加class样式jquery has-error -->
							<label class="mTitle" style="width: 200px;">地址：</label>
							<div class="mInputBlock">
								<div class="show_info"> </div>
								<input name="txtMail" id="inputError" placeholder=""
									class="form-control update_info" type="text">
							</div>
						</div>

						<div class="p116-info-item p116-margin-top">
							<label class="mTitle" style="width: 200px;">&nbsp;&nbsp;</label>
							<div class="mInputBlock">
								<input name="btn_first" value="确认提交信息" id="btn_first"
									class="ButtonBlue update_info" type="button">
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		
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