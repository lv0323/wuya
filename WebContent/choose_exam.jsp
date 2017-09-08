<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Cache-Control" content="no-transform" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>无涯在线测评系统</title>
		<script>var ctx = '/gwots';</script>

<!-- 获取常量引用版本 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-labelauty.js"></script>

	
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/zzsc.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style1111.css">

<link href="${pageContext.request.contextPath}/css/layui.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/iconfont1111.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/style2222.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/jquery-labelauty.css" rel="stylesheet" type="text/css"/>
<style>
ul { list-style-type: none;}
li { display: inline-block;}
li { margin: 10px 0;}
input.labelauty + label { font: 12px "Microsoft Yahei";}

</style>
<script>
$(function(){
	$(':input').labelauty();
});
</script>
<link rel="stylesheet" href="css/jquery-labelauty.css">
<style>
ul { list-style-type: none;}
li { display: inline-block;}
li { margin: 10px 0;}
input.labelauty + label { font: 12px "Microsoft Yahei";}
</style>
</head>

<body>
<div class="header">
	<div class="w1000 cf">
		<a href="#" class="t-logo"> 
			<img src="images/xdf.png" alt="" />
		</a>
	
		<div class="t-log accessType">
			<a href="/gwots/otstest/passport/login" class="btn btn-s">登录</a>
			<a href="http://passport.xdf.cn/i/m2pc/Register.aspx?returnUrl=http://tps.xdf.cn/gwots/otstest/passport/callBack/0000" class="btn btn-e">注册</a>
		</div>
	</div>		
</div>	
			<div class="w1000 cf">
				
				<div class="cont">
					<div class="slider"></div>
					<div class="nav"></div>
					<div data-target='right' class="side-nav side-nav--right"></div>
					<div data-target='left' class="side-nav side-nav--left"></div>
				</div>
				
				<div class="content111">
					<div class="first_menu">
						<h1>Subject:</h1>
						<div>
						<button class="layui-btn layui-btn-big layui-btn-primary layui-btn-radius">java</button>
						<button class="layui-btn layui-btn-big layui-btn-primary layui-btn-radius">c++</button>
						<button class="layui-btn layui-btn-big layui-btn-primary layui-btn-radius">php</button>
						<button class="layui-btn layui-btn-big layui-btn-primary layui-btn-radius">html5</button>
						<button class="layui-btn layui-btn-big layui-btn-primary layui-btn-radius">android</button>
						<button class="layui-btn layui-btn-big layui-btn-primary layui-btn-radius">ios</button>
						</div>
					</div>
					
					<div class="second_menu">
							<h1>Stage:</h1>
							<div>
							<ul class="dowebok">
							<!--<li><input type="checkbox" name="checkbox" disabled checked data-labelauty="HTML"></li>-->
							<li><input type="checkbox" name="checkbox" data-labelauty="CSS"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="JavaScript"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="SEO"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="PHP"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="JAVA"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty=".NET"></li>
							</ul>
							</div>
					<!-- 单选框代码 -->
					<!--<ul class="dowebok">
						<li><input type="radio" name="radio" data-labelauty="视觉设计师"></li>
						<li><input type="radio" name="radio" data-labelauty="交互设计师"></li>
						<li><input type="radio" name="radio" data-labelauty="前端工程师"></li>
						<li><input type="radio" name="radio" data-labelauty="数据分析师"></li>
						<li><input type="radio" name="radio" disabled data-labelauty="不可用"></li>
					</ul>-->
					</div>
					<div class="third_menu">
							<h1>Knowledge:</h1>
							<div>
							<ul class="dowebok">
							<!--<li><input type="checkbox" name="checkbox" disabled checked data-labelauty="HTML"></li>-->
							<li><input type="checkbox" name="checkbox" data-labelauty="if语句"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="for循环"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="List集合"></li>
							</ul>
							</div>
					<!-- 单选框代码 -->
					<!--<ul class="dowebok">
						<li><input type="radio" name="radio" data-labelauty="视觉设计师"></li>
						<li><input type="radio" name="radio" data-labelauty="交互设计师"></li>
						<li><input type="radio" name="radio" data-labelauty="前端工程师"></li>
						<li><input type="radio" name="radio" data-labelauty="数据分析师"></li>
						<li><input type="radio" name="radio" disabled data-labelauty="不可用"></li>
					</ul>-->
					</div>
					<div class="fourth_menu">
							<h1>Difficulty:</h1>
							<div>
							<ul class="dowebok">
							<!--<li><input type="checkbox" name="checkbox" disabled checked data-labelauty="HTML"></li>-->
							<li><input type="checkbox" name="checkbox" data-labelauty="简单"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="难"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="困难"></li>
							</ul>
							</div>
					<!-- 单选框代码 -->
					<!--<ul class="dowebok">
						<li><input type="radio" name="radio" data-labelauty="视觉设计师"></li>
						<li><input type="radio" name="radio" data-labelauty="交互设计师"></li>
						<li><input type="radio" name="radio" data-labelauty="前端工程师"></li>
						<li><input type="radio" name="radio" data-labelauty="数据分析师"></li>
						<li><input type="radio" name="radio" disabled data-labelauty="不可用"></li>
					</ul>-->
					</div>
					<div class="submit_choose">
					<button class="layui-btn layui-btn-big" id="submit_choose_btn" >开始答题</button>
					</div>
				</div>
				
			</div>
			
	</body>
</html>