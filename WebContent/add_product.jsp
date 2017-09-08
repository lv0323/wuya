<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<title>试题列表</title>
<style type="text/css">
td {
	font-size: 18px;
}
</style>
<script type=text/javascript>
	
	
	
	$(function() {
		$("#selectList").each(
				function() {
					var url = "getKnowlege.do";
					var areaJson;
					var temp_html;
					var oProvince = $(this).find("#province");
					var oCity = $(this).find("#city");
					
					//初始化学科
					var province = function() {
					
						$.each(areaJson, function(i, province) {
							temp_html += "<option value='"+province.p+"'>"
									+ province.p + "</option>";
						});
					
						oProvince.html(temp_html);
						city();
					};
					//赋值知识点
					var city = function() {
						
						temp_html = "";
						var n = oProvince.get(0).selectedIndex;
						$.each(areaJson[n].c, function(i, city) {
							temp_html += "<option value='"+city.ct+"'>"
									+ city.ct + "</option>";
						});
						
						oCity.html(temp_html);
					};
				
					//选择学科改变知识点
					oProvince.change(function() {
						city();
					});
					
					//获取json数据
					$.getJSON(url, function(data) {
						
						areaJson = data;
						province();
					
					});
				
				});
	
	});
	
//验证输入
	function reg1() {
		var aaa=/^\d{1,2}$/
		if(aaa.test($("#score").val())){
			$("#scorereg").html("✔");
			$("#scorereg").css("color","green");
			$("#scorereg").css("fontSize","20px");
			
			
		}else{
			$("#scorereg").html("✘请输入0—99之间的数值");
			$("#scorereg").css("color","red");
			$("#scorereg").css("fontSize","20px");
			
		}
	}

		function addquest() {
			var subjectname = $("#province").val();
			var knowlegename = $("#city").val();
			var question_name = $("#timu").val();
			var easy_type = $("#easy_type").val();
			var score = $("#score").val();
			var option_A = $("#aaa").val();
			var option_B = $("#bbb").val();
			var option_C = $("#ccc").val();
			var option_D = $("#ddd").val();
			var answer = $("#answer").val();
			//请求参数
			var senddata = {
				"subjectname" : subjectname,
				"knowlegename" : knowlegename,
				"easy_type" : easy_type,
				"question_name" : question_name.trim(),
				"score" : score.trim(),
				"option_A" : option_A.trim(),
				"option_B" : option_B.trim(),
				"option_C" : option_C.trim(),
				"option_D" : option_D.trim(),
				"answer" : answer,
			};
			
			//验证 若有未填项则提示请完善信息后再提交！
			if("请选择学科"==subjectname || "请选择知识点"== knowlegename || option_A.length==0 || option_B.length==0  || option_C.length==0  || option_D.length==0  || answer.length==0  ||question_name.length==0 ||
					option_A.trim()=="" || option_B.trim()==""  || option_C.trim()==""  || option_D.trim()==""  || answer.trim()==""  ||question_name.trim()==""||$("#scorereg").html()=="✘请输入0—99之间的数值"){
				$("#yanzheng").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请完善信息后再提交！");
				$("#yanzheng").css("color","red");
				$("#yanzheng").css("fontSize","20px");
			}else{
				$("#yanzheng").html("");
			$.ajax({
				url : "addquest.do",
				type : "post",
				dataType : "json",
				data :senddata,
				success : function(data) {

					//将各属性值对应填写到页面
						alert("插入成功");
						window.location.href="${pageContext.request.contextPath}/product_list.jsp";
				}
			})
			}
		}
	</script>
</head>
<body>
	<div class="wrap">
		<div class="page-title">
			<span class="modular fl"><i class="add"></i><em>编辑/添加试题</em></span> <span
				class="modular fr"><a href="product_list.jsp"
				class="btn btn-info">试题列表</a></span>
		</div>
		<form action="product_list.jsp " >
			<table id="selectList"
				class="list-style table-bordered table-condensed table-bordered success ">
				<tr>
					<td style="text-align: right; width: 15%;">所属学科：</td>
					<td><select class="textBox form-control" id="province">
							<option>请选择学科</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right;">相关知识点：</td>

					<td><select class="textBox form-control" id="city">
							<option>请选择知识点</option>
					</select></td>

				</tr>
				<tr>
					<td style="text-align: right;">题目信息：</td>
					<td><input type="text"
						class="textBox length-long form-control" id="timu" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项A：</td>
					<td><input type="text"
						class="textBox length-long form-control" id="aaa" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项B：</td>
					<td><input type="text"
						class="textBox length-long form-control" id="bbb" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项C：</td>
					<td><input type="text"
						class="textBox length-long form-control" id="ccc" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项D：</td>
					<td><input type="text"
						class="textBox length-long form-control" id="ddd" /></td>
				</tr>
				<tr>
					<td style="text-align: right; width: 15%;">正确答案：</td>
					<td><select class="textBox form-control" id="answer">
							<option>A</option>
							<option>A</option>
							<option>B</option>
							<option>C</option>
							<option>D</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right; width: 15%;">分值：</td>
					<td><input type="text" style="float: left;"
						class="textBox length-long form-control" id="score"  onblur="reg1()"/>
						<span id="scorereg"></span>
						</td>
						
				</tr>

				<tr>
					<td style="text-align: right; width: 15%;">难度：</td>
					<td><select class="textBox form-control" id="easy_type">
							<option>简单</option>
							<option>难</option>
							<option>困难</option>
					</select>
				</tr>

				<tr>
					<td style="text-align: right;">试题解析：</td>
					<td><textarea class="textarea form-control">请输入解析(可不填)</textarea></td>
				</tr>
				<tr>
					<td style="text-align: right;"></td>
					<td><input type="button" value="提交" class="btn btn-info"
						onclick="addquest()"  />
						<span id="yanzheng"></span></td>
					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
