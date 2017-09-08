<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Cache-Control" content="no-transform" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>个人中心</title>
<script>var ctx = '/gwots';</script>

<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
<!-- 获取常量引用版本 -->
<script src="${pageContext.request.contextPath}/js/components.js"></script>
<script src="${pageContext.request.contextPath}/js/audio.min.js"></script>

<script src="${pageContext.request.contextPath}/js/AppUtils.js"></script>
<script src="${pageContext.request.contextPath}/js/noeFunc.js"></script>
<script src="${pageContext.request.contextPath}/js/func.js"></script>
	<!-- 表格样式引入 -->
<%-- <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>


<link href="${pageContext.request.contextPath}/css/style_4.css" rel="stylesheet" type="text/css"/>

		<script src="${pageContext.request.contextPath}/js/report.js"></script>
		<link rel="${pageContext.request.contextPath}/stylesheet" href="css/extraeditor.css" />
		<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/echarts.min.radar.js"></script>
		
		<style type="text/css">
/* 		#recomMore{ */
/* 			float: right; */
/* 		} */
			.nav{
				float: left;
				margin-top: 60px;
				margin-left: 47px;
			}
/* 			#recomMore{ */
/* 				width:230px; */
/* 				float: right; */
/*  				margin-right: 5px; */
/* 			} */
			dd:HOVER{ 
				background-color: #1dcabc; 
			}
			#resultAn{
				padding: 30px 30px 15px 30px;
			}
			#titleRes{
				float: none;
				margin: 30px 0px 30px 10px;
				background-color: #1dbabc;
				width: 125px;
				height: 35px;
				text-align: center;
				padding: 9px;
				
			}
			#reps,#stageReps,#pracReps{
				width: 500px;
				margin: 0 auto;
				display:none;
			}
			#weekPlan,#stagePlan,#pracPlan{
				display:none;
			}
		</style>
	<%
	request.getSession().setAttribute("user_id", 1); 
	int user_id = (Integer)session.getAttribute("user_id"); 
	%>
	<script type="text/javascript">
	var user_id=<%=user_id%>;
	$(function(){
		// 周测报告信息
		$.ajax({
			url:"${pageContext.request.contextPath}/weekReps/list.do",
			type:"get",
			data:"user_id="+user_id,
			dataType:"json",
			//	返回周测报告JSON对象数组
			success:function(data){
				//alert(data);
				if(data!=[]){
					//	 遍历数组得到周测 学科名 试卷名 分数 考试时间  题数信息
					for(var i = 0;i<data.length;i++){
						var subject_name = data[i].subject_name;
						var week_exam_name = data[i].week_exam_name;
						var grade = data[i].grade;
						var time = data[i].time;
						var questions = data[i].questions;
						var times = new Date(time);
						//	得到考试时间年月日 时分秒信息
// 						var year = times.getFullYear();
// 						var mon = times.getMonth()+1;
// 						var day = times.getDate();
// 						var hour = times.getHours();
// 						var min = times.getMinutes();
// 						var sec = times.getSeconds();
						var newTime = times.toLocaleString();
						//alert(subject_name+"--"+grade+"--"+time+"--"+times+"--"+year+"--"+mon+"--"+day+"--"+hour+"--"+min+"--"+sec+"--"+newTime); 
						// 导出单条报告按钮 : <td><button class='btn btn-danger' onclick='exLoad()'>导出</button></td>
						var reports="<tr><td>"+subject_name+"</td><td>"+week_exam_name+"</td><td>"+grade+"</td><td>"
							+questions+"</td><td>"+newTime+"</td></tr>";
						$("#weekReports").append(reports);
					}
				}else{
					$("#repspoint").text("你还没参加过考试,快去参加测验吧!");
				}
			}
		});
		// 阶段报告信息
		$.ajax({
			url:"${pageContext.request.contextPath}/stageReps/list.do",
			type:"get",
			data:"user_id="+user_id,
			dataType:"json",
			//	返回阶段测试报告JSON对象数组
			success:function(data){
				//alert(data);
				if(data!=[]){
					//	遍历数组得到阶段测试学科名 试卷名 分数 考试时间  题数信息
					for(var i = 0;i<data.length;i++){
						var subject_name = data[i].subject_name;
						var stage_exam_name = data[i].stage_exam_name;
						var grade = data[i].grade;
						var time = data[i].time;
						var questions = data[i].questions;
						var times = new Date(time);
						var newTime = times.toLocaleString();
						var reports="<tr><td>"+subject_name+"</td><td>"+stage_exam_name+"</td><td>"+grade+"</td><td>"
							+questions+"</td><td>"+newTime+"</td></tr>";
						$("#stageReports").append(reports);
					}
				}else{
					$("#repspoint").text("你还没参加过考试,快去参加测验吧!");
				}
			}
		});		
		// 刷题信息
		$.ajax({
			url:"${pageContext.request.contextPath}/practiceReps/list.do",
			type:"get",
			data:"user_id="+user_id,
			dataType:"json",
			//	返回阶段测试报告JSON对象数组
			success:function(data){
				//alert(data);
				if(data!=[]){
					//	遍历数组,得到知识点名 刷题数量 分数 考试时间信息
					for(var i = 0;i<data.length;i++){
						var knowlege_name = data[i].knowlege_name;
						var count = data[i].count;
						var score = data[i].score;
						var time = data[i].time;
						var times = new Date(time);
						var newTime = times.toLocaleString();
						var reports="<tr><td>"+knowlege_name+"</td><td>"+score+"</td><td>"+count+"</td><td>"
							+newTime+"</td></tr>";
						$("#pracReports").append(reports);
					}
				}else{
					$("#repspoint").text("你还没参加过考试,快去参加测验吧!");
				}
			}
		});		
	});
	// 	测试分析和建议
	$(function(){
		//	周测试分析
		$.ajax({
			url:"${pageContext.request.contextPath}/week/plan.do",
			type:"get",
			data:"user_id="+user_id,
			dataType:"json",
			// 返回周测分数JSON对象
			success:function(data){
				//alert(data);
				if(data!={}){
					//	计算周测平均分数
					var testScore = data.testScore;
					var userScore = data.userScore;
					var avScore = userScore/testScore;
					var str = Number(avScore*100).toFixed(1);
					var avgScore = str+"%";
					//	把正确率值传给前端显示图表
					$("#weekRightPer").text(avgScore);
					$("#weekRightPic").html("<div class='pi-bar' style='width: "+avgScore+"'></div>");
					//判断掌握程度,给出适当建议和计划
					if(str<=100&&str>=90){
						$("#wknow5").attr("class","p-cir cr");
						$("#weekAnalysis").text("你对本知识点的掌握比较全面，能深入理解典型例题的答题思路，熟练地运用到开发项目中，实现更多的实际需求。"
								+"建议继续努力，平时多阅览学习资料，拓宽知识广度，更好地发掘自己的潜力，实现更高的目标。");
					}else if(str>79){
						$("#wknow4").attr("class","p-cir cr");
						$("#weekAnalysis").text("通过测试可以看到，你的基础较好，对所学知识有较好的认知和运用能力，能较好地开展实践项目，但是在有的学科上思路不够严谨，"
								+"容易对今后的开发和学习造成一些不必要的影响，建议平时可以多了解行业规范和项目，多做练习，养成好的开发习惯，同时也要继续加强知识的积累和经验。");
					}else if(str>69){
						$("#wknow3").attr("class","p-cir cr");
						$("#weekAnalysis").text("你的成绩较好，已经达到现阶段学科要求掌握的平均水平，能满足基本的开发和运用，还有巨大的潜能需要发现和加强。"
								+"在接下来的学习中，要趁热打铁，多做相关练习，梳理知识点结构，培养不同场景下的开发思路，了解更多知识并掌握，达到更高的水平。");
					}else if(str>59){
						$("#wknow2").attr("class","p-cir cr");
						$("#weekAnalysis").text("你对知识点的掌握不够全面，这导致你在答题时思维跳跃，不够严密，在应对综合性试题考查时容易失分。"
								+"建议在接下来的学习中，全面梳理本知识点，深入理解典型例题的答题思路，强化专项训练，争取突破性进展。");
					}else{
						$("#wknow1").attr("class","p-cir cr");
						$("#weekAnalysis").text("最近测试相对客观地反映出你在学习中存在非常严重的问题：基础薄弱、很难将所学知识应用于解题中、缺乏必要的应试技巧……不得不说，你已经落后于现阶段要求达到的学科掌握平均水平。"
								+"然而，这种处境并不可怕，可怕的是自此失去信心和勇气。所以接下来，你需要拿出“置之死地而后生”的魄力，认真思考怎样改变现状，怎样突破困境，如何有效地开展你的学习，尽快走出学习运用能力的低谷。");
					}
				}else{
					//没有考试数据,提示去参加测试
					$("#weekRightPer").text("0.0%");
					$("#weekRightPic").html("<div class='pi-bar' style='width: 0.0%'></div>");
				}
			}
		});
		//	阶段测试分析信息
		$.ajax({
			url:"${pageContext.request.contextPath}/stage/plan.do",
			type:"get",
			data:"user_id="+user_id,
			dataType:"json",
			//	返回阶段测试分数JSON对象
			success:function(data){
				//alert(data);
				if(data!={}){
					//	计算阶段测试平均分数
					var testScore = data.testScore;
					var userScore = data.userScore;
					var avScore = userScore/testScore;
					var str = Number(avScore*100).toFixed(1);
					var avgScore = str+"%";
					//str+="%";
					//	把正确率值传给前端显示图表
					$("#stageRightPer").text(avgScore);
					$("#stageRightPic").html("<div class='pi-bar' style='width: "+avgScore+"'></div>");
					//判断掌握程度,给出适当建议和计划
					if(str<=100&&str>=90){
						$("#sknow5").attr("class","p-cir cr");
						$("#stageAnalysis").text("你对本知识点的掌握比较全面，能深入理解典型例题的答题思路，熟练地运用到开发项目中，实现更多的实际需求。"
								+"建议继续努力，平时多阅览学习资料，拓宽知识广度，更好地发掘自己的潜力，实现更高的目标。");
					}else if(str>79){
						$("#sknow4").attr("class","p-cir cr");
						$("#stageAnalysis").text("通过测试可以看到，你的基础较好，对所学知识有较好的认知和运用能力，能较好地开展实践项目，但是在有的学科上思路不够严谨，"
								+"容易对今后的开发和学习造成一些不必要的影响，建议平时可以多了解行业规范和项目，多做练习，养成好的开发习惯，同时也要继续加强知识的积累和经验。");
					}else if(str>69){
						$("#sknow3").attr("class","p-cir cr");
						$("#stageAnalysis").text("你的成绩较好，已经达到现阶段学科要求掌握的平均水平，能满足基本的开发和运用，还有巨大的潜能需要发现和加强。"
								+"在接下来的学习中，要趁热打铁，多做相关练习，梳理知识点结构，培养不同场景下的开发思路，了解更多知识并掌握，达到更高的水平。");
					}else if(str>59){
						$("#sknow2").attr("class","p-cir cr");
						$("#stageAnalysis").text("你对知识点的掌握不够全面，这导致你在答题时思维跳跃，不够严密，在应对综合性试题考查时容易失分。"
								+"建议在接下来的学习中，全面梳理本知识点，深入理解典型例题的答题思路，强化专项训练，争取突破性进展。");
					}else{
						$("#sknow1").attr("class","p-cir cr");
						$("#stageAnalysis").text("最近测试相对客观地反映出你在学习中存在非常严重的问题：基础薄弱、很难将所学知识应用于解题中、缺乏必要的应试技巧……不得不说，你已经落后于现阶段要求达到的学科掌握平均水平。"
								+"然而，这种处境并不可怕，可怕的是自此失去信心和勇气。所以接下来，你需要拿出“置之死地而后生”的魄力，认真思考怎样改变现状，怎样突破困境，如何有效地开展你的学习，尽快走出学习运用能力的低谷。");
					}
				}else{
					$("#stageRightPer").text("0.0%");
					$("#stageRightPic").html("<div class='pi-bar' style='width: 0.0%'></div>");
					//没有考试数据,提示去参加测试
				}
			}
		});
		//	刷题测试的分析和建议
		$.ajax({
			url:"${pageContext.request.contextPath}/practice/plan.do",
			type:"get",
			data:"user_id="+user_id,
			dataType:"text",
			//	返回刷题测试平均分
			success:function(str){
				//alert(str);
				if(str!=undefined){
					str+="%";
					$("#pracRightPer").text(str);
					$("#pracRightPic").html("<div class='pi-bar' style='width:"+str+"'></div>");
					//判断掌握程度,给出适当建议和计划
					if(str<=100&&str>=90){
						$("#pknow5").attr("class","p-cir cr");
						$("#pracAnalysis").text("你对本知识点的掌握比较全面，能深入理解典型例题的答题思路，熟练地运用到开发项目中，实现更多的实际需求。"
								+"建议继续努力，平时多阅览学习资料，拓宽知识广度，更好地发掘自己的潜力，实现更高的目标。");
					}else if(str>79){
						$("#pknow4").attr("class","p-cir cr");
						$("#pracAnalysis").text("通过测试可以看到，你的基础较好，对所学知识有较好的认知和运用能力，能较好地开展实践项目，但是在有的学科上思路不够严谨，"
								+"容易对今后的开发和学习造成一些不必要的影响，建议平时可以多了解行业规范和项目，多做练习，养成好的开发习惯，同时也要继续加强知识的积累和经验。");
					}else if(str>69){
						$("#pknow3").attr("class","p-cir cr");
						$("#pracAnalysis").text("你的成绩较好，已经达到现阶段学科要求掌握的平均水平，能满足基本的开发和运用，还有巨大的潜能需要发现和加强。"
								+"在接下来的学习中，要趁热打铁，多做相关练习，梳理知识点结构，培养不同场景下的开发思路，了解更多知识并掌握，达到更高的水平。");
					}else if(str>59){
						$("#pknow2").attr("class","p-cir cr");
						$("#pracAnalysis").text("你对知识点的掌握不够全面，这导致你在答题时思维跳跃，不够严密，在应对综合性试题考查时容易失分。"
								+"建议在接下来的学习中，全面梳理本知识点，深入理解典型例题的答题思路，强化专项训练，争取突破性进展。");
					}else{
						$("#pknow1").attr("class","p-cir cr");
						$("#pracAnalysis").text("最近测试相对客观地反映出你在学习中存在非常严重的问题：基础薄弱、很难将所学知识应用于解题中、缺乏必要的应试技巧……不得不说，你已经落后于现阶段要求达到的学科掌握平均水平。"
								+"然而，这种处境并不可怕，可怕的是自此失去信心和勇气。所以接下来，你需要拿出“置之死地而后生”的魄力，认真思考怎样改变现状，怎样突破困境，如何有效地开展你的学习，尽快走出学习运用能力的低谷。");
					}
				}else{
					$("#pracRightPer").text("0.0%");
					$("#pracRightPic").html("<div class='pi-bar' style='width: 0.0%'></div>");
					//没有考试数据,提示去参加测试
				}
			}
		});
	});
	</script>
		<script type="text/javascript">
			//  周测试
			function findWeekRep(){
				$("#stageReps").hide();//隐藏阶段测试div
				$("#pracReps").hide();//显示刷题测试div
				$("#reps").show();//显示周测div
			}
			//阶段测试
			function findStageRep(){
				$("#reps").hide();//隐藏周测div
				$("#pracReps").hide();//显示刷题测试div
				$("#stageReps").show();//显示阶段测试div
			}
			//刷题测试
			function findPracRep() {
				$("#reps").hide();//隐藏周测div
				$("#stageReps").hide();//隐藏阶段测试div
				$("#pracReps").show();//显示刷题测试div
			}
			//周测试分析
			function findWeekPlan() {
				$("#stagePlan").hide();//隐藏阶段测试div
				$("#pracPlan").hide();//隐藏刷题测试div
				$("#weekPlan").show();//显示周测测试div
			}
			//阶段测试分析
			function findStagePlan() {
				$("#weekPlan").hide();//隐藏周测div
				$("#pracPlan").hide();//隐藏刷题测试div
				$("#stagePlan").show();//显示阶段测试div
			}
			//刷题测试分析
			function findPracPlan() {
				$("#weekPlan").hide();//隐藏周测div
				$("#stagePlan").hide();//隐藏阶段测试div
				$("#pracPlan").show();//显示刷题测试div
			}
			
			var user_id=<%=user_id%>;
			
			//	导出所有周测报告
	 		function loadWeekReport(){
	 			//alert("导出zhou......");
	 			$.ajax({
	 				url:"${pageContext.request.contextPath}/load/weekReps.do",
		 			type:"post",
		 			data:"user_id="+user_id,
		 			dataType:"text",
		 			success:function(data){
		 				//alert(data);
		 				if(1==data){
		 					alert("导出完成!已保存在本地磁盘 C:\测试报告 文件下!");
		 				}else{
		 					alert("导出失败...请重试!");
		 				}
		 			}
	 			});
	 		}
			//	导出所有阶段测试报告
			function loadStageReport(){
				//alert("导出阶段......");
				$.ajax({
					url:"${pageContext.request.contextPath}/load/stageReps.do",
					type:"post",
					data:"user_id="+user_id,
					dataType:"text",
					success:function(data){
						//alert(data);
						if(1==data){
							alert("导出完成!已保存在本地磁盘 C:\测试报告 文件下!");
						}else{
							alert("导出失败...请重试!");
						}
					}
				});
			}
			//	导出所有刷题报告
			function loadPracReport(){
				//alert("导出刷题......");
				$.ajax({
					url:"${pageContext.request.contextPath}/load/pracReps.do",
					type:"post",
					data:"user_id="+user_id,
					dataType:"text",
					success:function(data){
						//alert(data);
						if(1==data){
							alert("导出完成!已保存在本地磁盘 C:\测试报告 文件下!");
						}else{
							alert("导出失败...请重试!");
						}
					}
				});
			}
		</script>
	</head>
	
	<body>
		<div class="header">
<div class="w1000 cf">
	<a href="#" class="t-logo"> 
	<img src="images/xdf.png" alt="新东方" />
	</a>
	<div class="t-cities accessType">
				<!-- 当没有paperSchName，因为不知道显示那个学校，所以不显示 -->
				<!-- <a href="javascript:;"></a> -->
	</div>
	<div class="t-log accessType">
							<a href="/gwots/otstest/passport/login" class="btn btn-s">登录</a>
							<a href="http://passport.xdf.cn/i/m2pc/Register.aspx?returnUrl=http://tps.xdf.cn/gwots/otstest/passport/callBack/0000" class="btn btn-e">注册</a>
	</div>
</div>		</div>	
		<div class="nav">
					<h2>个人中心</h2>
					<dl>
						<dt>
							<span class="out">
								关于你
						    </span>
						</dt>
								<dd>
									<a href="user_information.jsp">修改个人信息</a> 
								</dd>
								<dd>
									<a href="changepass.jsp">修改密码</a> 
								</dd>
					</dl>
					<dl>
						<dt>
							<span class="out">
								报告
						    </span>
						</dt>
								<dd>
									<a href="#pos1"><span onclick="findWeekRep()">周测试</span></a>
								</dd>
								<dd>
									<a href="#pos2"><span onclick="findStageRep()">阶段测试</span></a>
								</dd>
								<dd>
									<a href="#pos3"><span onclick="findPracRep()">刷题测试</span></a>
								</dd>
					</dl>
					<dl>
						<dt>
							<span class="out">
								计划
						    </span>
						</dt>
								<dd>
									<a href="#pos4"><span onclick="findWeekPlan()">周计划</span></a>
								</dd>
								<dd>
									<a href="#pos5"><span onclick="findStagePlan()">阶段计划</span></a>
								</dd>
								<dd>
									<a href="#pos6"><span onclick="findPracPlan()">刷题计划</span></a>
								</dd>
					</dl>
					<dl>
						<dt>
							<span class="out">
								导出
						    </span>
						</dt>
								<dd>
									<a ><span onclick="loadWeekReport()">周测报告</span></a>
								</dd>
								<dd>
									<a><span onclick="loadStageReport()">阶段报告</span></a>
								</dd>
								<dd>
									<a><span onclick="loadPracReport()">刷题报告</span></a>
								</dd>
					</dl>
				</div>
		<div class="w1000 cf">
			<div class="crump">
					<a href="/gwots/otstest/home/index">首页</a><i class="iconfont">&gt;</i>
				个人中心
			</div>
			<div class="wl">
				<div class="level">
					<div class="level-line">
						<div class="level-n">你的等级<span>4</span></div>
					</div> 
					<div class="level-step">
						<div class="model p4"></div>
						<div class="ruler"></div>
						
						<ul class="steps">
							<li class="st-1"><span>1</span></li>
							<li class="st-2"><span>2</span></li>
							<li class="st-3"><span>3</span></li>
							<li class="st-4"><span>4</span></li>
						</ul>
					</div>
				</div>
				<div id="resultAn">
<!-- 				class="analysis" 上面div的属性-->
<!-- 					<div class="serial"> -->
					<div id="titleRes">
						<h1 style="color: white;font-size: 18px; ">测评报告</h1>
<!-- 						<p>结果分析</p> -->
					</div>
					<div id="reps"><a id="pos1"></a>
						<table id="weekReports" class="table table-striped table-hover table-bordered" style="text-align: center;">
							<tr class="danger" >
								<td>学科</td>
								<td>试卷</td>
								<td>成绩</td>
								<td>题数</td>
								<td>考试时间</td>
							</tr>
						</table>
					</div>
					<div id="stageReps"><a id="pos2"></a>
						<table id="stageReports" class="table table-striped table-hover table-bordered" style="text-align: center;">
							<tr class="danger" >
								<td>学科</td>
								<td>试卷</td>
								<td>成绩</td>
								<td>题数</td>
								<td>考试时间</td>
							</tr>
						</table>
					</div>
					<div id="pracReps"><a id="pos3"></a>
						<table id="pracReports" class="table table-striped table-hover table-bordered" style="text-align: center;">
							<tr class="danger" >
								<td>知识点</td>
								<td>分数</td>
								<td>题数</td>
								<td>刷题时间</td>
							</tr>
						</table>
					</div>
					<p id="repspoint" style="font-size: 16px;color: gray;text-align: center;">注 : 报告可以反映您近期的学习情况!</p>
<!-- 					<div class="tester"> -->
<!-- 						亲爱的<span class="cr">下周五</span>同学: -->
<!-- 					</div> -->
<!-- 					<p class="para">你于 <span class="cr">2017年07月27日 22时19分</span>参加新东方 <span class="cr">英语语法</span>，用时<span class="cr">2分5秒</span>得分
<span class="cr">0</span>分/满分100，当前总测评数<span class="cr">561</span>当前排名<span class="cr">522</span>。以下是对测评情况的详细分析。</p> -->
<!-- 					<p class="para">你的<span class="cr">英语</span>学科能力位处<span class="cr">等级4</span>，这说明你对本学科现阶段所要求知识点的掌握不够扎实，</p> -->
<!-- 					<div class="cf"> -->
<!-- 						<div class="w380 l" style="margin:0 auto;"> -->
<!-- 							<table border="0" cellspacing="0" cellpadding="0" class="tbl"> -->
<!-- 								<tr> -->
<!-- 									<th>考点</th> -->
<!-- 									<th>正确题目/总题目</th> -->
<!-- 									<th>得分</th> -->
<!-- 									<th>掌握度</th> -->
<!-- 								</tr> -->
<!-- 									<tr> -->
<!-- 										<td title="英语语法">英语语法</td> -->
<!-- 										<td>0/10</td> -->
<!-- 										<td>0</td> -->
<!-- 										<td>0.0%</td> -->
<!-- 									</tr> -->
<!-- 							</table> -->
<!-- 						</div> -->
<!-- 						<div class="w380 r" id="imgRadarMapId" style="display:none;width:345px;height:270px;">  -->
<!-- 							<img id="radarMapImgId" src="" style="width:100%;height:100%"/>  -->
<!-- 						</div> -->
<!-- 						<div id="radarMapId" class="w380 r" style="display:none;width:345px;height:270px;"></div> -->
<!-- 					</div> -->
<!-- 						<a href="javascript:void(0);" id="checkAnswer" class="btn btn-s">查看答案</a> -->
				</div>
<!-- 				<div class="analysis"> -->
				<div id="resultAn">
<!-- 					<div class="serial"> -->
					<div id="titleRes">
<!-- 						<span></span>单项分析 -->
							<h1 style="color: white;font-size: 18px; ">测评总结</h1>
					</div>
						<!-- 周测试分析和适当学习计划-->
	                    <div id="weekPlan" class="key-points end cf">
	                    	<a id="pos4"><div class="key-tit">周测分析</div></a>
							<div class="key-prg">
								<div class="percents pc1">
									<h3><span class="p-n">题目比重</span><span class="pcr">100.0%</span></h3>
									<div class="po-bar"><div class="pi-bar" style="width: 100.0%;"></div></div>
								</div>
								<div class="percents pc2">
									<h3><span class="p-n">答题正确率</span><span id="weekRightPer" class="pcr">0.0%</span></h3>
									<div id="weekRightPic" class="po-bar"><!-- <div class="pi-bar" style="width: 10.0%;"></div> --></div>
								</div>
								<div class="percents pc3">
									<h3><span class="p-n">掌握程度</span><span class="pcr"></span></h3>
									<span id="wknow1" class='p-cir'><b><i>不足</i></b></span><span id="wknow2" class='p-cir'><b><i>了解</i></b></span><span id="wknow3" class='p-cir'><b><i>熟悉</i></b></span>
									<span id="wknow4" class='p-cir'><b><i>掌握</i></b></span><span id="wknow5" class='p-cir'><b><i>精通</i></b></span>
								</div>
							</div>
							<div class="result-analysis">
								<h3>结果分析</h3>
								<p id="weekAnalysis" class="para">你还没参加过测评,赶快开始做题吧!</p>
							</div>
	                    </div>
						<!-- 阶段测试分析和适当学习计划-->
	                    <div id="stagePlan" class="key-points end cf">
	                    	<a id="pos5"><div class="key-tit">阶段分析</div></a>
							<div class="key-prg">
								<div class="percents pc1">
									<h3><span class="p-n">题目比重</span><span class="pcr">100.0%</span></h3>
									<div class="po-bar"><div class="pi-bar" style="width: 100.0%;"></div></div>
								</div>
								<div class="percents pc2">
									<h3><span class="p-n">答题正确率</span><span id="stageRightPer" class="pcr">0.0%</span></h3>
									<div id="stageRightPic" class="po-bar"><!-- <div class="pi-bar" style="width: 10.0%;"></div> --></div>
								</div>
								<div class="percents pc3">
									<h3><span class="p-n">掌握程度</span><span class="pcr"></span></h3>
									<span id="sknow1" class='p-cir'><b><i>不足</i></b></span><span id="sknow2" class='p-cir'><b><i>了解</i></b></span><span id="sknow3" class='p-cir'><b><i>熟悉</i></b></span>
									<span id="sknow4" class='p-cir'><b><i>掌握</i></b></span><span id="sknow5" class='p-cir'><b><i>精通</i></b></span>
								</div>
							</div>
							<div class="result-analysis">
								<h3>结果分析</h3>
								<p id="stageAnalysis" class="para">你还没参加过测评,赶快开始做题吧!</p>
							</div>
	                    </div>
						<!-- 刷题测试分析和适当学习计划-->
	                    <div id="pracPlan" class="key-points end cf">
	                    	<a id="pos6"><div class="key-tit">刷题分析</div></a>
							<div class="key-prg">
								<div class="percents pc1">
									<h3><span class="p-n">题目比重</span><span class="pcr">100.0%</span></h3>
									<div class="po-bar"><div class="pi-bar" style="width: 100.0%;"></div></div>
								</div>
								<div class="percents pc2">
									<h3><span class="p-n">答题正确率</span><span id="pracRightPer" class="pcr">0.0%</span></h3>
									<div id="pracRightPic" class="po-bar">
										<!-- <div class="pi-bar" style="width: 10.0%;"></div> -->
									</div>
								</div>
								<div class="percents pc3">
									<h3><span class="p-n">掌握程度</span><span class="pcr"></span></h3>
									<span id="pknow1" class='p-cir'><b><i>不足</i></b></span><span id="pknow2" class='p-cir'><b><i>了解</i></b></span>
									<span id="pknow3" class='p-cir'><b><i>熟悉</i></b></span><span id="pknow4" class='p-cir'><b><i>掌握</i></b></span><span id="pknow5" class='p-cir'><b><i>精通</i></b></span>
								</div>
							</div>
							<div class="result-analysis">
								<h3>结果分析</h3>
								<p id="pracAnalysis" class="para">你还没参加过测评,赶快开始做题吧!</p>
							</div>
	                    </div>
	                    <p id="planPoint" style="font-size: 16px;color: gray;text-align: center;">注 : 测评分析和学习计划能帮助您更好地学习进步!</p>
				</div>
<!-- 				<div class="analysis"> -->
<!-- 					<div class="serial"> -->
<!-- 						<span></span>测评总结 -->
<!-- 					</div> -->
<!-- 					<p class="para"> -->
<!-- 						本次测试相对客观地反映出你在学习中存在非常严重的问题：基础薄弱、很难将所学知识应用于解题中、缺乏必要的应试技巧……不得不说，你已经落后于现阶段要求达到的学科掌握平均水平。 -->
<!-- 						然而，这种处境并不可怕，可怕的是自此失去信心和勇气。所以接下来，你需要拿出“置之死地而后生”的魄力，认真思考怎样改变现状，怎样突破困境，如何有效地开展你的学习，尽快走出学习的低谷。 -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 				<div class="analysis cf"> -->
<!-- 					<div class="serial"> -->
<!-- 						<span></span>推荐课程 -->
<!-- 					</div> -->
<!-- 					<div class="course"> -->
<!-- 							<div class="hd-nothing">没有相关推荐课程信息</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
<!-- 			<div class="wr"> -->
<!-- 			</div> -->
				<!-- 以下为改动元素 -->
<!-- 			<div id="recomMore"> -->
<!-- 					<div class="more"> -->
<!-- 						<h2>更多测评</h2> -->
<!-- 						<ul class="test-list"> -->
<!-- 										<li title="英语单词"><a href="/gwots/testprocess/control/index?paperId=AB7C658F-B9B3-4294-ABA1-AD2F77AAC707&clientType=pc">英语单词</a></li> -->
<!-- 										<li title="英语阅读"><a href="/gwots/testprocess/control/index?paperId=6BB142A5-63F1-4D2A-941A-EDD8197967B8&clientType=pc">英语阅读</a></li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 				<div class="imgPub"> -->
<!-- 					<img src="picture/a1_1.jpg" alt="" /> -->
<!-- 				</div> -->
<!-- 		</div> -->
			<div class="wr">
					<div class="more">
						<h2>更多测评</h2>
						<ul class="test-list">
										<li title="英语单词"><a href="/gwots/testprocess/control/index?paperId=AB7C658F-B9B3-4294-ABA1-AD2F77AAC707&clientType=pc">英语单词</a></li>
										<li title="英语阅读"><a href="/gwots/testprocess/control/index?paperId=6BB142A5-63F1-4D2A-941A-EDD8197967B8&clientType=pc">英语阅读</a></li>
						</ul>
					</div>
<!-- 				<div class="imgPub"> -->
<!-- 					<img src="picture/a1_1.jpg" alt="" /> -->
<!-- 				</div> -->
			</div>
		</div>
		
	</body>
</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>