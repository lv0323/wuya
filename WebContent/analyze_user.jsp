<%@page import="cn.xdl.tol.service.QuestionService"%>
<%@page import="cn.xdl.tol.bean.QuestionAndSubjectAndKnowlege"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>查看试题</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/js/page.css" rel="stylesheet"></link>
<link href="${pageContext.request.contextPath}/style/qinadminStyle.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/public.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jqPaginator.min.js" type="text/javascript"></script>
<style  type="text/css">
td{
    font-size: 16px;
}
</style>
<script type="text/javascript">
$(function(){
	var ok=true;
	var totalPages =${totalPages};
	var visiblePages = ${visiblePages};
	var page = ${page};
	$('#page_div').jqPaginator({
	    totalPages: totalPages,
	    visiblePages: visiblePages,
	    currentPage: page,
	    first: '<li class="first"><a href="javascript:void(0);">首页</a></li>',
	    prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
	    next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
	    last: '<li class="last"><a href="javascript:void(0);">末页</a></li>',
	    page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
	    onPageChange: function (num, type) {
	       if(ok){
	    	   ok = false;
	       }else{
	    	   window.location.href="${pageContext.request.contextPath}/findUser.do?page="+num;
	       }
	    }
	});
});
	
	
</script>

	<script type="text/javascript">
	
		//清空用户的选择
		function clr() {
			$("#handfind").val("");

		}
	</script>




</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>用户列表</em></span>
  </div>
  <div class="operate">
   <form id="selectList" action="findUser.do">
 选择查询： 
    
   <input type="text" class="textBox length-long " placeholder="输入用户id..." id="handfind" name="user_id" />
    &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp;  &nbsp;   &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;
    <input type="submit" value="查询" class="tdBtn btn-info" />
   
    <input type="button" value="清空" class="tdBtn btn-danger" onclick="clr()"/>

   </form>
  </div>
    <span id="nomessage"></span>
  <table class="list-style Interlaced table-bordered  table-striped table-hover table-condensed " id="tablecon">
   <tr>
    <th style="width: 50px;">用户ID</th>
    <th >姓名</th>
    <th  style="width: 150px;">密码</th>
    <th >邮箱</th>
    <th >电话</th>
    <th >操作</th>
   </tr>
   
   <c:forEach items="${user }" var="user1">
   	<tr>
	    <td style="width: 50px;">${user1.user_id}</td>
	    <td >${user1.user_name}</td>
	    <td  style="width: 150px;">${user1.user_pass}</td>
	    <td >${user1.email}</td>
	    <td >${user1.tell}</td>
	    <td ><input type="button" value="查看分析" class="tdBtn btn-info" /></td>
   </tr>
   </c:forEach>
   
  </table><br/><br/>
	<div>${error }</div>
   <div class="pagination" id="haha"></div>
  <!-- BatchOperation -->
  <div style="overflow:hidden;" id="page1" >
      <!-- Operation -->
	  
	  <!-- turn page -->
	  <div  class="pagination" id="page_div">
	   
	  </div>
  </div>
   
 </div>

</body>
</html>
