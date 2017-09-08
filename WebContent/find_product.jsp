<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<title>试题列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<style  type="text/css">
td{
    font-size: 18px;
}
</style>
<script type=text/javascript>
	$(function() {

		
	var questionid = ${param.id}

		$.ajax({
			url : "findquest.do",
			type : "post",
			dataType : "json",
			data : "&questionid=" + questionid,

			success : function(data) {
 			
 					$("#subjectname").html(""+data.body[0].subject_name);
 					$("#knowname").html(""+data.body[0].knowlege_name);
 					$("#timu").html(""+data.body[0].question_name);
 					$("#easy_type").html(""+data.body[0].easy_type);
 					$("#score").html(""+data.body[0].score);
 					$("#aaa").html(""+data.body[0].option_A);
 					$("#bbb").html(""+data.body[0].option_B);
 					$("#ccc").html(""+data.body[0].option_C);
 					$("#ddd").html(""+data.body[0].option_D);
 					$("#answer").html(""+data.body[0].answer);
			}
		})
	})
</script>
</head>

<body>
	<div class="wrap">
		<div class="page-title">
			<span class="modular fl"><i class="add"></i><em>查看试题详情</em></span> <span
				class="modular fr"><a href="product_list.jsp"
				class="btn btn-info">试题列表</a></span>
		</div>
		<form action="edit_product.jsp">
			<table class="list-style  table-bordered  table-striped table-hover table-condensed ">
				<tr>
					<td style="text-align: right; width: 15%;">所属学科：</td>
					<td><span id="subjectname"> </span></td>
				</tr>
				<tr>
					<td style="text-align: right;">相关知识点：</td>
					<td><span id="knowname"> </span></td>
				</tr>
				<tr>
					<td style="text-align: right;">题目信息：</td>
					<td><span id="timu"> </span></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项A：</td>
					<td><span id="aaa"> </span></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项B：</td>
					<td><span id="bbb"> </span></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项C：</td>
					<td><span id="ccc"> </span></td>
				</tr>
				<tr>
					<td style="text-align: right;">选项D：</td>
					<td><span id="ddd"> </span></td>
				</tr>
				<tr>
					<td style="text-align: right; width: 15%;">正确答案：</td>
					<td><span id="answer"> </span></td>
				</tr>
				<tr>
					<td style="text-align: right; width: 15%;">分值：</td>
					<td><span id="score"> </span></td>
				</tr>

				<tr>
					<td style="text-align: right; width: 15%;">难度：</td>
					<td><span id="easy_type"> </span></td>
				</tr>


				<tr>
					<td style="text-align: right;"></td>
					<td><a href='edit_product.jsp?id=${param.id}' title='编辑' ><input type="button" value="编辑试题" class="btn btn-info" /></a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
