<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<style  type="text/css">
td{
    font-size: 18px;

}
</style>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<title>试题列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />

<script type=text/javascript>
	function updatequest() {
		//获取修改后的各属性值
		var question_id = ${	param.id};
		var question_name = $("#timu").val();
		var easy_type = $("#easy_type").val();
		var score = $("#score").val();
		var option_A = $("#aaa").val();
		var option_B = $("#bbb").val();
		var option_C = $("#ccc").val();
		var option_D = $("#ddd").val();
		var answer = $("#answer").val();
	//请求参数
		var senddata= {"easy_type" : easy_type,"question_name": question_name ,"score" : score , "option_A" : option_A
				,"option_B" : option_B , "option_C" : option_C, "option_D" : option_D , "answer" : answer, "question_id" : question_id};
	
		$.ajax({
			url : "updatequest.do",
			type : "post",
			dataType : "json",
			data : senddata,
			success : function(data) {
				//跳转至试题详情展示页面
				
				window.location.href = "${pageContext.request.contextPath}/find_product.jsp?id=${param.id}";

			}

		}

		)
	
	}

	$(function() {
		//获取题目id
		var questionid = ${	param.id};
		$.ajax({
			url : "findquest.do",
			type : "post",
			dataType : "json",
			data : "&questionid=" + questionid,
			success : function(data) {
				
				//将各属性值对应填写到页面
				
				$("#subjectname").html("" + data.body[0].subject_name);
				$("#knowname").html("" + data.body[0].knowlege_name);
				$("#timu").val("" + data.body[0].question_name);
				$("#easy_type").val("" + data.body[0].easy_type);
				$("#score").val("" + data.body[0].score);
				$("#aaa").val("" + data.body[0].option_A);
				$("#bbb").val("" + data.body[0].option_B);
				$("#ccc").val("" + data.body[0].option_C);
				$("#ddd").val("" + data.body[0].option_D);
				$("#answer").val("" + data.body[0].answer);
			}
		})
	})
</script>
</head>
<body>
	<div class="wrap">
		<div class="page-title">
			<span class="modular fl"><i class="add"></i><em>编辑/添加试题</em></span> <span
				class="modular fr"><a href="product_list.jsp"
				class="btn btn-info">试题列表</a></span>
		</div>
		<form action="product_list.jsp ">
			<table class="list-style table-bordered table-condensed table-bordered success ">
				<tr >
					<td style="text-align: right; width: 15%;">所属学科：</td>
					<td><span id="subjectname"> </span></td>
				</tr>
				<tr>
					<td style="text-align: right;">相关知识点：</td>
					<td><span id="knowname"> </span></td>

				</tr>
				<tr>
					<td style="text-align: right;">题目信息：</td>
					<td><input type="text" class="textBox length-long form-control" id="timu" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项A：</td>
					<td><input type="text" class="textBox length-long form-control" id="aaa" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项B：</td>
					<td><input type="text" class="textBox length-long form-control" id="bbb" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项C：</td>
					<td><input type="text" class="textBox length-long form-control" id="ccc" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项D：</td>
					<td><input type="text" class="textBox length-long form-control" id="ddd" /></td>
				</tr>
				<tr>
					<td style="text-align: right; width: 15%;">正确答案：</td>
					<td><select class="textBox form-control" id="answer">
							<option>A</option>
							<option>B</option>
							<option>C</option>
							<option>D</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right; width: 15%;">分值：</td>
					<td><input type="text" class="textBox length-long form-control" id="score" /></td>
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
					<td><textarea class="textarea form-control">请输入解析</textarea></td>
				</tr>
				<tr>
					<td style="text-align: right;"></td>
					<td><input type="button" value="提交" class="btn btn-info" onclick="updatequest()"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
