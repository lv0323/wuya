<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
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
<script type="text/javascript">
function subjectchoose(subject_id){
	/*  清空ajax产生的数据*/
	$(".dowebok").empty();
	$.ajax({
		url:"${pageContext.request.contextPath}/stageList.do",
		type:"get",
		data:"subject_id="+subject_id,
		dataType:"json",
		success:function(data){
			for(var i in data){
				var stage_id=data[i].stage_id;
				var stage_name=data[i].stage_name
				/* 循环产生选择框传入阶段id作为选择时的value值 */
				$(".dowebok").append("<li><input type='radio' id='aaa"+i+"' name='stage_id' value='"+stage_id+"'/><label for='aaa"+i+"'>"+stage_name+"</label></li>");
			}
		}
	});
}
function answerquestion(){
	/* 单选框哪一个被选择就获得那个单选框的值 */
	var stage_id=$("input:radio:checked").val();
	/*  如果单选框传递的阶段id值为空代表未选择*/
	if(stage_id==null){
		alert("请选择你要测试的阶段");
	}else{
		$.ajax({
			url:"${pageContext.request.contextPath}/getStageEaxmList.do",
			type:"get",
			data:"stage_id="+stage_id,
			dataType:"json",
			success:function(dat){
				/* 判断后台查询返回的json */
				if(dat.errorCode==0){
					/*  没查到此试卷*/
					alert("此阶段没有试卷");
				}else{
					window.location.href="${pageContext.request.contextPath}/getStageExamQuestion.do?stage_id="+stage_id;
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
						<!-- 循环展示学科列表 -->
						<c:forEach items="${subjectlist}" var="sbl">
							<button class="layui-btn layui-btn-big layui-btn-primary layui-btn-radius" onclick="subjectchoose(${sbl.subject_id})">${sbl.subject_name}</button>
						</c:forEach>
						</div>
					</div>
					
					<div class="second_menu">
							<h1>Stage:</h1>
							<div>
							<!--<ul class="dowebok">
							<li><input type="checkbox" name="checkbox" disabled checked data-labelauty="HTML"></li>-->
							<!-- <li><input type="checkbox" name="checkbox" data-labelauty="CSS"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="JavaScript"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="SEO"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="PHP"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty="JAVA"></li>
							<li><input type="checkbox" name="checkbox" data-labelauty=".NET"></li>
							</ul> -->
							<!-- 单选框代码 -->
							<ul class="dowebok">
								
							</ul>
							</div>
					
					</div>
					<div class="submit_choose">
					<!-- 触发后台查询试卷 -->
					<input class="layui-btn layui-btn-big" id="submit_choose_btn" type="button" onclick="answerquestion()" value="开始答题"></input>
					</div>
				</div>
				
			</div>
			
	</body>
</html>