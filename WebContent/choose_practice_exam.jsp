<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<style>
ul { list-style-type: none;}
li { display: inline-block;}
li { margin: 10px 0;}
input.labelauty + label { font: 12px "Microsoft Yahei";}

</style>
<script>
$(function(){
	$(':input').labelauty();
	/* 控制动态样式 */
	$(".third_menu").hide(); 
	$(".fourth_menu").hide();
	
	/* 提交选择开始刷题 */
	$("#submit_choose_btn").click(function() {
		var knowledge_ids = "";
	    $(".third_menu input:checkbox").each(function(){     
            if ($(this).is(":checked")){           //判断当前是否被选中
                knowledge_ids += knowledge_ids==""?"":",";    //不为空则用逗号隔开
                knowledge_ids += $(this).attr("value");    //拼接取值
            }                 
	    });
	   var easy_type = "";
	   easy_type = $(".fourth_menu input:radio:checked").val();
	   window.location.href="${pageContext.request.contextPath}/practice_exam.do?knowledge_ids=" + knowledge_ids + "&easy_type=" + easy_type;
	});
});
/* 通过用户选择学科发起ajax获取相关知识点列表和难度列表 */
function showinfo(subject_id) {
	$("#msg").hide();
	$.ajax({
		url:"${pageContext.request.contextPath}/showChooseInfo.do",
		type:"post",
		dataType:"json",
		data:"subject_id="+subject_id,
		success:function(data){
			$(".second_menu").show();
			$(".third_menu").show(); 
			$(".fourth_menu").show();
			$(".third_menu ul").empty();
			$(".fourth_menu ul").empty();
			if (data.knowlege_list.length != 0) {//将知识点循环遍历展示
				for (var i = 0; i < data.knowlege_list.length; i++) {
					var knowlege_id = data.knowlege_list[i].knowlege_id;
					var knowlege_name = data.knowlege_list[i].knowlege_name;
					var knowlege = "<li id='knowlegeli" + knowlege_id + "'><input type='checkbox' id='knowlege" + knowlege_id + "' value='" + knowlege_id + "' name='knowlege_id'><label for='knowlege" + knowlege_id + "'>" + knowlege_name + "</label></li>";
					$(".third_menu ul").append(knowlege);
				}
			} else {//如果获取的知识点没有，将知识点列表隐藏
				$(".third_menu").hide(); 
			}
			if (data.easy_type.length != 0) {//将难度循环遍历展示
				for (var i = 0; i < data.easy_type.length; i++) {
					var easy_type_name = data.easy_type[i];
					var easy_type = "<li id='easy_typeli" + i + "'><input type='radio' id='easy_type" + i + "' name='easy_type_name' value='" + easy_type_name + "' ><label for='easy_type" + i + "'>" + easy_type_name + "</label></li>";
					$(".fourth_menu ul").append(easy_type);
				}
			} else {//如果获取的难度没有，将难度列表隐藏
				$(".fourth_menu").hide();
			}
		}
	});
}
</script>
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
						<!-- 循环展示学科并将学科id作为样式id -->
						<c:forEach items="${vo}" var="subject">
						<button id="subject${subject.subject_id}" class="layui-btn layui-btn-big layui-btn-primary layui-btn-radius" onclick="showinfo(${subject.subject_id})">${subject.subject_name}</button>
						</c:forEach>
						</div>
					</div>
					
					<%-- <div class="second_menu">
							<h1>Stage:</h1>
							<div>
							<ul class="dowebok">
							<!-- 循环拿出每个学科的阶段集合 -->
							<c:forEach var="i" begin="0" end="${fn:length(vo)}">
								<!-- 循环遍历展示每个学科的阶段名，并将学科id作为样式id方便区分 -->
								<c:forEach items="${vo[i].stage_list}" var="stage">
								<li id="stage${stage.subject_id}"><input type="radio" name="radio" data-labelauty="${stage.stage_name}"></li>
								</c:forEach>
							</c:forEach>
							</ul>
							</div>
					</div> --%>
					<div class="third_menu">
							<h1>Knowledge:</h1>
							<div>
							<ul >
							<!-- 每个学科vo遍历拿出 -->
							<%-- <c:forEach items="${vo}" var="practice_paper_choose_VO">
								<!-- 将每个学科所有  按阶段划分的知识点的集合  遍历拿出 -->
								<c:forEach items="${practice_paper_choose_VO.knowlege_list}" var="stage_knowledge_list">
									<!-- 将每个阶段的知识点名循环遍历出来 -->
									<c:forEach items="${stage_knowledge_list}" var="stage_knowledge">
									<li><input class="knowledge${stage_knowledge.subject_id}${stage_knowledge.stage_id}" type="checkbox" name="checkbox" data-labelauty="${stage_knowledge.knowlege_name}"></li>
									</c:forEach>
								</c:forEach>
							</c:forEach> --%>
							</ul>
							</div>
					</div>
					<div class="fourth_menu">
							<h1>Difficulty:</h1>
							<div>
							<ul >
							<!-- 遍历取出单个学科vo对象 -->
							<%-- <c:forEach items="${vo}" var="practice_paper_choose_VO">
								<!-- 遍历vo对象中每个学科的包含难度 -->
								<c:forEach items="${practice_paper_choose_VO.easy_type}" var="easy_type">
								<li><input class="easy_type${practice_paper_choose_VO.subject_id}" type="radio" name="radio" data-labelauty="${easy_type}"></li>
								</c:forEach>
							</c:forEach> --%>
							</div>
					</div>
					<div class="submit_choose">
					<button class="layui-btn layui-btn-big" id="submit_choose_btn" >开始刷题</button>
					<span id="msg" style="color: red;">${msg}</span>
					</div>
				</div>
				
			</div>
			
	</body>
</html>