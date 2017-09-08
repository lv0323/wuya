<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>智能组卷</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/style/adminStyle.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/public.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
		type="text/javascript"></script>

	<script type="text/javascript">
		$(function() {

			$("#selectList").each(function() {

								var url = "gettype.do";
								var areaJson;
								var temp_html;
								var oProvince = $(this).find("#province");
								var oCity = $(this).find("#city");
								var oDistrict = $(this).find("#district");
								//初始化学科
								var province = function() {

									$
											.each(
													areaJson,
													function(i, province) {
														temp_html += "<option value='"+province.p+"'>"
																+ province.p
																+ "</option>";
													});

									oProvince.html(temp_html);
									city();
								};
								//赋值试卷类型
								var city = function() {

									temp_html = "";
									var n = oProvince.get(0).selectedIndex;
									$
											.each(
													areaJson[n].c,
													function(i, city) {
														temp_html += "<option value='"+city.ct+"'>"
																+ city.ct
																+ "</option>";
													});

									oCity.html(temp_html);
									district();
								};
								//赋值知识点
								var district = function() {
									temp_html = "";
									var m = oProvince.get(0).selectedIndex;
									var n = oCity.get(0).selectedIndex;
									if (typeof (areaJson[m].c[n].d) == "undefined") {
										oDistrict.css("display", "none");
									} else {
										oDistrict.css("display", "inline");
										$
												.each(
														areaJson[m].c[n].d,
														function(i, district) {
															temp_html += "<option value='"+district.dt+"'>"
																	+ district.dt
																	+ "</option>";
														});
										oDistrict.html(temp_html);
									}
									;
								};
								//选择省学科改变试卷类型
								oProvince.change(function() {
									city();
								});
								//选择试卷类型改变知识点
								oCity.change(function() {
									district();
								});
								//获取json数据
								$.getJSON(url, function(data) {

									areaJson = data;
									province();

								});
							});
		});

		//查询所有问题
		function findquestion() {
			
			subjectname = $("#province").val();
			tttype = $("#city").val();
			district = $("#district").val();
			questnumber = $("#questnumber").val();
			
			//验证试题数量不能为空
			var aaa=/^[^0-9]{1,2}$/;
			var bbb=$("#questnumber").val();
			if (bbb.length == 0
					|| bbb == null) {
				$("#slmsg").html("✘请输入试题数量再进行抽题");
				$("#slmsg").css("color", "red");
				$("#slmsg").css("fontSize", "20px");

			}else if(aaa.test(bbb)){
				//验证试题数量输入是否为数字
				$("#slmsg").html("✘请输入数字");
				$("#slmsg").css("color", "red");
				$("#slmsg").css("fontSize", "20px");
			} else {
				$
						.ajax({
							url : "getrandomquest.do",
							type : "post",
							dataType : "json",
							data : "subjectname=" + subjectname + "&tttype="
									+ tttype + "&district=" + district
									+ "&questnumber=" + questnumber,

							success : function(data) {
								//状态码为0 表示查询没有结果
								if (data.status == 0) {
									//将表格内容隐藏
									$("#tablecon").hide();
									//显示没有题目
									$("#nomessage")
											.html(
													"<br><br><center><h1>没有相关题目</h1></center>");
									$("#nomessage").css({
										"fontSize" : "30px",
										"color" : "red",
										"megin" : "auto"
									});
									$("#page1").hide();
									$("#examname").hide();
									$("#shiji").hide();
								} else if (data.status == -1) {
									//将表格内容隐藏
									$("#tablecon").hide();
									//显示没有题目
									$("#nomessage")
											.html(
													"<br><br><center><h1>题库试题数量不足，请重新输入试题数量后再抽题</h1></center>");
									$("#nomessage").css({
										"fontSize" : "30px",
										"color" : "red",
										"megin" : "auto"
									});
									$("#page1").hide();
									$("#examname").hide();
									$("#shiji").hide();
								} else {
									//将表格中内容清空
									$("#tablecon").html("");
									$("#nomessage").html("");
									$("#tablecon").show();
									$("#page1").show();
									$("#examname").show();
									$("#shiji").show();
									$("#tablecon")
											.append(
													"<tr><th>试题编号</th><th>难易程度</th><th>试题内容</th><th>所属学科</th><th>相关知识点</th><th>分值</th></tr>");

									//向表格中循环插入查询到的试题
									for (var i = 0; i < data.body.length; i++) {
										//追加一条试题
										$("#tablecon")
												.append(
														"<tr id='items"+data.body[i].question_id+"'><td><input type='checkbox' class='middle children-checkbox'/>"
																+ data.body[i].question_id
																+ "</td><td>"
																+ data.body[i].easy_type
																+ "</td><td>"
																+ data.body[i].question_name
																+ "</td><td>"
																+ data.body[i].subject_name
																+ "</td><td>"
																+ data.body[i].knowlege_name
																+ "</td><td>"
																+ data.body[i].score
																+ "</tr>");
									}
								}
							}
						});

			}

		}

		//添加一套试卷
		function addexam() {
			//获取所有试题编号，用逗号拼接
			var questdata = "";
			$(":checkbox").each(function() {
				if (questdata == "") {
					questdata += ($(this).parent().text());

				} else {
					questdata += ("," + $(this).parent().text());
				}
			})

			//学科名
			subjectname = $("#province").val();
			//周或阶段类型
			tttype = $("#city").val();
			//第几周或第几阶段
			typedetial = $("#district").val();
			//用户输入的试卷名
			examname = $("#examname").val();

			//正则验证，如果试题名给空，不提交
			if ($("#examname").val().length == 0 || $("#exammsg").val() == null) {

				$("#exammsg").html("✘请输入试卷名");
				$("#exammsg").css("color", "red");
				$("#exammsg").css("fontSize", "20px");

			} else {

				$.ajax({
							url : "addexam.do",
							type : "post",
							dataType : "json",
							data : {
								"questdata" : questdata,
								"subjectname" : subjectname,
								"tttype" : tttype,
								"typedetial" : typedetial,
								"examname" : examname
							},
							success : function(data) {
								if (data == "-1") {
									//试题名重复，提示用户
									alert("试题名已存在，请重新命名后再组卷！")
								} else {
									//插入成功
									f= $("#city").val()
							
									if( f=='周测'){
									
										alert("组卷成功！");
										window.location.href ='${pageContext.request.contextPath}/zbwfindWeekExamQuestion.do?id='+data;
									}else{
										
										alert("组卷成功！")
										window.location.href ='${pageContext.request.contextPath}/zbwfindStageExamQuestion.do?id='+data;
									}
								}
							}
						})
			}
		}

		//验证试题命名不能为空
		function sjtmyz() {
			if ($("#examname").val().length == 0 || $("#exammsg").val() == null) {
				$("#exammsg").html("✘请输入试卷名再进行组卷");
				$("#exammsg").css("color", "red");
				$("#exammsg").css("fontSize", "20px");

			} else {
				$("#exammsg").html("");
			}
		}

		//验证试题数量不能为空且填入为数字
		function sjslyz() {
			var aaa=/^[0-9]*$/;
			var bbb=$("#questnumber").val();
			if (bbb.length == 0
					|| bbb == null) {
				$("#slmsg").html("✘请输入试题数量再进行抽题");
				$("#slmsg").css("color", "red");
				$("#slmsg").css("fontSize", "20px");

			}else if(!aaa.test(bbb)){
				//验证试题数量输入是否为数字
				$("#slmsg").html("✘请输入数字");
				$("#slmsg").css("color", "red");
				$("#slmsg").css("fontSize", "20px");
			} else {
				$("#slmsg").html("");
			}
		}
	</script>
</head>
<body>
	<div class="wrap">
		<div class="page-title">
			<span class="modular fl"><i></i><em>智能组卷</em></span> <span
				class="modular fr"><input type="button" class="pt-link-btn"
				value="+开始抽题" onclick="findquestion()" /></span>
		</div>
		<div class="operate">
			<form id="selectList">
				<select class="inline-select" id="province">
					<option>学科</option>
				</select> <select class="inline-select" id="city">
					<option>试卷类型</option>

				</select> <select class="inline-select" id="district">
					<option>阶段</option>
				</select>
			</form>
			<br> 题目数量：<input type="text" name="numbers" id="questnumber"
				onblur="sjslyz()" /> <span id="slmsg"></span>
			</form>
		</div>
		<span id="nomessage"></span> <span id="shiji">试卷名称：</span> <input
			type="text" class="textBox length-long " placeholder="输入试卷名称..."
			onblur="sjtmyz()" id="examname" /> <span id="exammsg"> </span> <br>
			<br>
				<table id="tablecon"
					class="list-style Interlaced table-bordered  table-striped table-hover table-condensed "
					id="tablecon">
					<tr>
						<th>试题编号</th>
						<th>难易程度</th>
						<th>试题内容</th>
						<th>所属学科</th>
						<th>对应阶段</th>
						<th>相关知识点</th>
						<th>分值</th>

					</tr>

				</table> <br> <!-- BatchOperation -->
					<div style="overflow: hidden;" id="page1">
						<!-- Operation -->
						<div class="BatchOperation fl">
							<input type="button" value="保存试卷" class="btnStyle"
								onclick="addexam()" />
						</div>
						<!-- turn page -->
						<div class="turnPage center fr">
							<a>第一页</a> <a>1</a> <a>最后一页</a>
						</div>
					</div>
	</div>
</body>
</html>
