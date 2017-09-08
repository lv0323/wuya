<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>无涯教育在线测评</title>
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/iconfont.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/test.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/layui.css" rel="stylesheet" type="text/css" />

<style>
.hasBeenAnswer {
	background: #7CA3A8;
	color:#fff;
}
.layui-header {
	background-color: #223d54;
}
</style>

</head>

<body>
	<div class="layui-header">
		<img class="title_img" src="${pageContext.request.contextPath}/images/xdf.png" />
	</div>
	<div class="main">
		<!--nr start-->
		<div class="test_main">
			<div class="nr_left">
				<div class="test">
					<form action="${pageContext.request.contextPath}/finish_practice.do" method="post">
						<div class="test_title">
							<p class="test_time">
								<i class="icon iconfont">&#xe60e;</i><b class="alt-1">01:00</b>
							</p>
							<font><input type="button" name="test_jiaojuan" onclick="finish()" value="交卷"></font>
						</div>
						
							<div class="test_content">
								<div class="test_content_title">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">${fn:length(paper)}</i><span>题，</span><span>合计</span><i class="content_fs">${paperScore}</i><span>分</span>
									</p>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
									<!-- 用于发送题目总数 -->
									<input type="hidden" id="total" value="${fn:length(paper)}" name="total_count"  />
									<input type="hidden"  value="${paperScore}" name="total_score"  />
									<c:forEach items="${paper }" var="question" varStatus="q">
										<!-- 遍历试题 -->
										<li id="qu_${question.question_id }">
											<div class="test_content_nr_tt">
												<!-- count用于显示每次循环的次数，可以作为题号 -->
												<i>${q.count}</i><span>(<fmt:formatNumber type="number" value="${question.score }" pattern="0"/>分)</span><font>${question.question_name }（  ）</font><b class="icon iconfont">&#xe62e;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
																<!-- 用页面题目编号作为name  选项使用'题目本身id和,选项'传递值 -->
																<input type="radio" class="radioOrCheck" name="${q.count }"
																	id="0_answer_${q.count}_option_1" value="${question.question_id },A"
																/>
															
															
															<label for="0_answer_${q.count}_option_1">
																A.
																<p class="ue" style="display: inline;">${question.option_A }</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="${q.count }"
																	id="0_answer_${q.count}_option_2"  value="${question.question_id },B"
																/>
															
															
															<label for="0_answer_${q.count}_option_2">
																B.
																<p class="ue" style="display: inline;">${question.option_B }</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="${q.count }"
																	id="0_answer_${q.count}_option_3" value="${question.question_id },C"
																/>
															
															
															<label for="0_answer_${q.count}_option_3">
																C.
																<p class="ue" style="display: inline;">${question.option_C }</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="${q.count }"
																	id="0_answer_${q.count}_option_4" value="${question.question_id },D"
																/>
															
															
															<label for="0_answer_${q.count}_option_4">
																D.
																<p class="ue" style="display: inline;">${question.option_D }</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									</c:forEach>
										
										
								</ul>
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
							<p class="test_time">
								<i class="icon iconfont">&#xe60e;</i><b class="alt-1">01:00</b>
							</p>
						</div>
						
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">${fn:length(paper)}</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										<c:forEach items="${paper }" var="question" varStatus="q">
										<li><a href="#qu_${question.question_id }">${q.count }</a></li>
										</c:forEach>
										
										
									</ul>
								</div>
							</div>
							
					</div>

				</div>
			</div>
			
			<%-- <c:forEach items="${paper}" var="question"  varStatus="q">
				<span>i:${q.index }</span>
				<span>c:${q.count }</span>
			</c:forEach> --%>
		</div>
		<!--nr end-->
		<div class="foot"></div>
	</div>

	<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.easy-pie-chart.js"></script>
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
				if(!cardLi.hasClass('hasBeenAnswer')){
					cardLi.addClass('hasBeenAnswer');
				}
				
			});
		});
	</script>
	<!-- 将实际答题数目发给服务器 -->
	<script type="text/javascript">
	var total = $("#total").val();
	function finish() {
		var num = 0;
		for (var i = 1; i <= total; i++) {
			var val=$('input:radio[name="'+ i +'"]:checked').val();
			if (val != null) {
				num+=1;
			}
		}
		/* $("#total").val(num);
		$("form").submit(); */
	/* 控制所有题目刷完才能交卷 */
		if (num == total) {
			$("form").submit();
		} else {
			alert("请作答全部题目");
		}
	}
</script>

</body>

</html>