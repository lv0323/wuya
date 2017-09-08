<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
﻿<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Cache-Control" content="no-transform" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>周测评测评报告</title>
<script>var ctx = '/gwots';</script>

<!-- 获取常量引用版本 -->
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/qincomponents.js"></script>
<script src="js/qinaudio.min.js"></script>
<script>
if(!Array.indexOf){
	   Array.prototype.indexOf = function(obj){             
	        for(var i=0; i<this.length; i++){
	            if(this[i]==obj){
	                return i;
	            }
	        }
	        return -1;
	   }
}
</script>
<script src="js/qinapputils.js"></script>
<script src="js/qinnoefunc.js"></script>
<script src="js/qinfunc.js"></script>


<link href="css/qiniconfont.css" rel="stylesheet" type="text/css"/>
<link href="css/qinstyle.css" rel="stylesheet" type="text/css"/>

		<script src="js/qinreport.js"></script>
		<link rel="stylesheet" href="css/qinextraeditor.css" />
		<!-- <script src="js/qinecharts.min.js"></script> -->
		<script src="js/qinecharts.min.radar.js"></script>
		<script>
			var testId = '09E5C67A-03AD-4F4A-838C-5ED7FAC33EB6';
			var paperId = '69E37BFC-4592-4A13-8E69-D768B365BF25';
			var pointData = "[{text: 'Liste...', max: 175.0},{text: 'Readi...', max: 40.0},{text: 'Readi...', max: 70.0},{text: 'Readi...', max: 70.0},{text: 'Readi...', max: 70.0}]";
			var pointCorrectData = "[21.0,0.0,0.0,0.0,0.0]";
			var acType = '';
			var roleType = "";
		
			var str = 'sp'+${rank};
				
			$(function(){
				/* if(acType == 'teacher'){
					$(".accessType").remove();
				}
				
				$('.test-list li:odd').addClass('cr1');
				report.init();  */
				$("#"+str).addClass('cr');
			});
			
			
		</script>
	</head>
	<body>
		<div class="header">
<div class="w1000 cf">
	<a href="${pageContext.request.contextPath}/home_index.jsp" class="t-logo"> 
	<img src="images/xdf.png"  />
	</a>
	<div class="t-cities accessType">
				<!-- 当没有paperSchName，因为不知道显示那个学校，所以不显示 -->
				<!-- <a href="javascript:;"></a> -->
	</div>
	<div class="t-log accessType">
	</div>
</div>		</div>	
		<div class="w1000 cf">
			<div class="crump">
					<a href="${pageContext.request.contextPath}/home_index.jsp">首页</a><i class="iconfont">&gt;</i>
				周测评测试报告
			</div>
			<div class="wl">
				<div class="level">
					<div class="level-line">
						<div class="level-n">
							你的等级
								<span>
									${rank }
								</span>
							</div>
					</div> 
					<div class="level-step">
						<div class="model p${rank }"></div>
						<div class="ruler"></div>
						
						<ul class="steps">
							<li class="st-1"><span>1</span></li>
							<li class="st-2"><span>2</span></li>
							<li class="st-3"><span>3</span></li>
							<li class="st-4"><span>4</span></li>
						</ul>
					</div>
				</div>
				<div class="analysis">
					<div class="serial">
						<span></span>结果分析
					</div>
					<div class="tester">
						亲爱的<span class="cr">${user.user_name }</span>同学:
					</div>
					<p class="para">你于 <span class="cr">${week_exam_time }</span>参加无涯测评的 <span class="cr">${week_exam_message.week_exam_name }</span>，得分<span class="cr">${grade }</span>分/满分${week_exam_message.tatal_points }。以下是对测评情况的详细分析。</p>
					<p class="para">你的<span class="cr">${week_exam_message.week_exam_name }</span>测评能力位处<span class="cr">等级${rank }</span>，${evaluate }</p>
					<div class="cf">
						<div class="w380 l" style="margin:0 auto;">
							<table border="0" cellspacing="0" cellpadding="0" class="tbl">
								<tr>
									<th>知识点</th>
									<th>正确题目/总题目</th>
									<th>得分/总分</th>
									<th>掌握度</th>
								</tr>
								<c:forEach items="${weekExamKnowlege}" var="w" >
									<tr>
										<td title="Listening ">${w.knowlege_name }</td>
										<td>${w.rightCount}/${w.count }</td>
										<td>${w.rightGrade}/${w.grade }</td>
										<td><fmt:formatNumber type="number" value="${w.rightCount*100/w.count}" maxFractionDigits="0"/>%</td>
									</tr>
								</c:forEach>	
							</table>
						</div>
						<div class="w380 r" id="imgRadarMapId" style="display:none;width:345px;height:270px;"> 
							<img id="radarMapImgId" src="" style="width:100%;height:100%"/> 
						</div>
					</div>
						<a href="week_exam_result.do?week_exam_id=${week_exam_message.week_exam_id }&week_grade_id=${week_grade_id }" id="checkAnswer" class="btn btn-s">查看答案</a>
				</div>
				<div class="analysis">
					<div class="serial">
						<span></span>程度分析
					</div>
	                    <div class="key-points cf">
	                    	<div class="key-tit">掌握程度</div>
							<div class="key-prg">
								<div class="percents pc3">
									<h3><span class="p-n"></span><span class="pcr"></span></h3>
									<span id="sp4" class='p-cir'><b><i>不足</i></b></span><span id="sp3" class='p-cir'><b><i>了解</i></b></span><span id="sp2" class='p-cir'><b><i>熟悉</i></b></span><span id="sp1" class='p-cir'><b><i>掌握</i></b></span>
								</div>
							</div>
							
	                    </div>
	                   
				</div>
				<div class="analysis">
					<div class="serial">
						<span></span>测评总结
					</div>
					<p class="para">
						${analysis }
					</p>
			<a href="${pageContext.request.contextPath}/home_index.jsp" id="checkAnswer" class="btn btn-s">返回主页</a>
				</div>
			
			</div>
			<div class="wr">
					<div class="more">
						<h2>更多测评</h2>
						<ul class="test-list">
								<li>没有更多测评内容</li>
						</ul>
					</div>
				<div class="imgPub">
					<img src="picture/a1.jpg" alt="" />
				</div>
			</div>
		</div>
	</body>
</html>
