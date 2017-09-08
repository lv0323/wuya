<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户分析</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add_user"></i><em>用户分析</em></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/findUser.do?page=2" class="pt-link-btn">返回用户列表</a></span>
  </div>
  
  <table class="list-style">
   <tr>
    <td style="width:15%;text-align:right;">编号：</td>
    <td><input type="text" class="textBox length-middle"/></td>
    <td style="width:15%;text-align:right;">账号：</td>
    <td><input type="text" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">密码：</td>
    <td><input type="text" class="textBox length-middle"/></td>
    <td style="text-align:right;">年龄：</td>
    <td><input type="text" class="textBox length-middle"/></td>
   </tr>
   <tr>
   <td style="text-align:right;">性别：</td>
    <td><input type="text" class="textBox length-middle"/></td>
    <td style="text-align:right;">城市：</td>
    <td><input type="text" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">邮箱：</td>
    <td><input type="text" class="textBox length-middle"/></td>
    <td style="text-align:right;">电话：</td>
    <td><input type="text" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">工作：</td>
    <td><input type="text" class="textBox length-middle"/></td>
    <td style="text-align:right;">地址：</td>
    <td><input type="text" class="textBox length-middle"/></td>
   </tr>
  </table>
  
 </div>
 <div>
 	<h1>java学科</h1>
	<table border="1px" >
		<tr>
			<th>知识点</th>
			<th>正确题目/测试题目/总题目</th>
			<th>掌握度</th>
			<th>试题测评率</th>
		</tr>
 </div>
</body>
</html>
