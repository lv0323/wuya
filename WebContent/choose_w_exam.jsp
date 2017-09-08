<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Cache-Control" content="no-transform" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>无涯在线测评系统</title>
		<script>var ctx = '/gwots';</script>
<link rel="stylesheet" href="css/jquery-labelauty.css">
<style>
ul { list-style-type: none;}
li { display: inline-block;}
li { margin: 10px 0;}
input.labelauty + label { font: 12px "Microsoft Yahei";}
</style>
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
<!-- 获取常量引用版本 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-labelauty11.js"></script>

	
<script src="${pageContext.request.contextPath}/js/main.js"></script>

<script>
$(function(){
	$(':input').labelauty();
});

function findWeek(subject_id) {
	$(".dowebok").empty();
	$.ajax({
		url:"${pageContext.request.contextPath}/week_list.do",
		type:"post",
		dataType:"json",
		data:"subject_id="+subject_id,
		success:function(dat){
			for(var i = 0;i<dat.length;i++){
				var weeklyId = dat[i].weekly_type_id;
				var weekly = dat[i].weekly_type_name;
			    var week = "<li class='week'><input   type='radio' id='aaa"+i+"' name='weekly_type_id' value='"+weeklyId+"'><label  for='aaa"+i+"'>"+weekly+"</label></li>" 
				$(".dowebok").append(week);
			}

		}
	});
}

function find() {
	var weekly_type_id = $("input:radio:checked").val(); 
	if(weekly_type_id==null){
		alert("请先选择要参加的周测试")
	}else{
		
		$.ajax({
			url:"${pageContext.request.contextPath}/find_week_exam.do",
			type:"post",
			dataType:"json",
			data:"weekly_type_id="+weekly_type_id,
			success:function(dat){
				if(dat.error==0){
					alert("该周测没有试题，请选择其他周测");
				}else{
					window.location.href="${pageContext.request.contextPath}/week_exam.do?weekly_type_id="+weekly_type_id;
				}
			}
		});
	}
}


</script>

</head>

<body>
<div class="header">
	<div class="w1000 cf">
		<a href="${pageContext.request.contextPath}/home_index.jsp" class="t-logo"> 
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
						<c:forEach items="${subject }" var="subject1">
								<button class='layui-btn layui-btn-big layui-btn-primary layui-btn-radius' onclick='findWeek(${subject1.subject_id })'>${subject1.subject_name }</button>
						</c:forEach>
						</div>
					</div>
					<form action="week_exam.do" method="get">
					<div class="second_menu">
							<h1>Week:</h1>
							<div>
							<ul class="dowebok">
								<!-- <li><input type="radio" name="radio" data-labelauty="视觉设计师"></li>-->
							</ul>
							</div>
					</div>
				
					<div class="submit_choose">
					<input type="button" class="layui-btn layui-btn-big" id="submit_choose_btn" value="开始答题" onclick="find()"></button>
					</div>
				</div>
				</form>
			</div>
			
	</body>
</html>