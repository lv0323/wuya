<%@page import="cn.xdl.tol.vo.WeekExamQuestionUserVo"%>
<%@page import="cn.xdl.tol.bean.Week_Exam"%>
<%@page import="cn.xdl.tol.bean.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>无涯教育在线测评</title>
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/iconfont.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/qintest.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/layui.css"
	rel="stylesheet" type="text/css" />

<style>
.hasBeenAnswer {
	background: #7CA3A8;
	color: #fff;
}

.layui-header {
	background-color: #223d54;
}
</style>

</head>

<body>
	<div class="layui-header">
		<img class="title_img"
			src="${pageContext.request.contextPath}/images/xdf.png" />
	</div>
	<div class="main">
		<!--nr start-->
		<div class="test_main">
			<div class="nr_left">
				<div class="test">
					<form action="week_exam_grade.do" method="get">
						<% 
					 List<WeekExamQuestionUserVo> list =(List)request.getAttribute("user_answer");
					 Week_Exam we = (Week_Exam)request.getAttribute("weekExam");
					%>
						<div class="test_title">

							<font><input type="submit" value="返回周测报告"></font>
						</div>

						<div class="test_content">
							<div class="test_content_title">
								<h2><%=we.getWeek_exam_name() %></h2>
								<p>
									<span>共</span><i class="content_lit"><%=list.size() %></i><span>题，</span><span>合计</span><i
										class="content_fs"></i><span><%=we.getTatal_points() %>分</span>
								</p>
							</div>
						</div>
						<div class="test_content_nr">
							<ul>
								<% 
									for(int i = 0;i<list.size();i++){
										%>
								<li id="qu_0_<%=i %>">
									<div class="test_content_nr_tt"
										id="question_<%=list.get(i).getQuestion_id() %>>">
										<i><%=i+1 %></i><span>(<%=list.get(i).getScore() %>分)
										</span><font><%=list.get(i).getQuestion_name() %></font><b
											class="icon iconfont">&#xe62e;</b>
									</div>

									<div class="test_content_nr_main">
										<ul>
											<li class="option"><input type="radio"
												class="radioOrCheck"
												name="<%=list.get(i).getQuestion_id() %>"
												id="0_answer_<%=i+1 %>_option_1" value="A"
												<%if("A".equalsIgnoreCase(list.get(i).getUserAnswer())){
																	 %>
												checked <%
																 }else{
																	 %>
												disabled <% 
																 } %> /> <label
												for="0_answer_<%=i+1 %>_option_1"> A.
													<p class="ue" style="display: inline;"><%=list.get(i).getOption_A() %></p>
											</label></li>

											<li class="option"><input type="radio"
												class="radioOrCheck"
												name="<%=list.get(i).getQuestion_id() %>"
												id="0_answer_<%=i+1 %>_option_2" value="B"
												<%if("B".equalsIgnoreCase(list.get(i).getUserAnswer())){
																	 %>
												checked <%
																 }else{
																	 %>
												disabled <% 
																 } %> /> <label
												for="0_answer_<%=i+1 %>_option_2"> B.
													<p class="ue" style="display: inline;"><%=list.get(i).getOption_B() %></p>
											</label></li>

											<li class="option"><input type="radio"
												class="radioOrCheck"
												name="<%=list.get(i).getQuestion_id() %>"
												id="0_answer_<%=i+1 %>_option_3" value="C"
												<%if("C".equalsIgnoreCase(list.get(i).getUserAnswer())){
																	 %>
												checked <%
																 }else{
																	 %>
												disabled <% 
																 } %> /> <label
												for="0_answer_<%=i+1 %>_option_3"> C.
													<p class="ue" style="display: inline;"><%=list.get(i).getOption_C() %></p>
											</label></li>

											<li class="option"><input type="radio"
												class="radioOrCheck"
												name="<%=list.get(i).getQuestion_id() %>"
												id="0_answer_<%=i+1 %>_option_4" value="D"
												<%if("D".equalsIgnoreCase(list.get(i).getUserAnswer())){
																	 %>
												checked <%
																 }else{
																	 %>
												disabled <% 
																 } %> /> <label
												for="0_answer_<%=i+1 %>_option_4"> D.
													<p class="ue" style="display: inline;"><%=list.get(i).getOption_D() %></p>
											</label></li>

										</ul>
									</div>
								</li>

							</ul>
							<div class="test_content_title">
								<h2>试题详情：</h2>
								<p>
									<span>正确答案  ： <%=list.get(i).getAnswer() %>；</span>
									<span> <%if(list.get(i).getAnswer().equalsIgnoreCase(list.get(i).getUserAnswer())){
										%> 您的作答正确 ；<%
									}else{
										%> 您的作答错误 ； <%
									} %></span>
									<span>试题分值  ： <%=list.get(i).getScore() %>；</span>
									<span>难易程度  ： <%=list.get(i).getEasy_type() %></span>
								</p>
							</div>
							<% 
								}
							%>
						</div>
					</form>
				</div>

			</div>
			<div class="nr_right">
				<div class="nr_rt_main">
					<div class="rt_nr1">
						<div class="rt_nr1_title">
							<h1>
								<i class="icon iconfont">&#xe63c;</i>答题卡
							</h1>

						</div>

						<div class="rt_content">
							<div class="rt_content_tt">
								<h2>单选题</h2>
								<p>
									<span>共</span><i class="content_lit"><%=list.size() %></i><span>题</span>
								</p>
							</div>
							<div class="rt_content_nr answerSheet">
								<ul>
									<%
										for(int i = 0;i<list.size();i++){
											%>
									<li><a href="#qu_0_<%=i %>"><%=i+1 %></a></li>
									<% 
										}
									%>
								</ul>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<!--nr end-->
		<div class="foot"></div>
	</div>

	<script
		src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.easy-pie-chart.js"></script>
	<!--时间js-->
	<script src="${pageContext.request.contextPath}/js/jquery.countdown.js"></script>
	<script src="${pageContext.request.contextPath}/js/layui.js"></script>

	<script>
		window.jQuery(function($) {
			"use strict";
			
			$('time').countDown({
				with_separators : false
			});
			$('.alt-1').countDown({
				css_class : 'countdown-alt-1'
			});
			$('.alt-2').countDown({
				css_class : 'countdown-alt-2'
			});
			
		});
		
		
		$(function() {
			$('li.option label').click(function() {
			debugger;
				var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
				var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
				// 设置已答题
				/* if(!cardLi.hasClass('hasBeenAnswer')){
					cardLi.addClass('hasBeenAnswer');
				} */
				
			});
		});
	</script>


</body>

</html>