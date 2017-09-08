<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>左侧导航</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
<body style="background:#313131">
<div class="menu-list">
 <a href="main.jsp" target="mainCont" class="block menu-list-title center" style="border:none;margin-bottom:8px;color:#fff;">主页</a>
 <ul>
  <li class="menu-list-title">
   <span>试题管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="product_list.jsp" title="商品列表" target="mainCont">查看试题</a></li>
   </ul>
  </li>
 
  <li class="menu-list-title">
   <span>试卷管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="product_category_week.jsp" title="商品列表" target="mainCont">周测试卷</a></li>
    <li><a href="product_category_stage.jsp" title="商品分类" target="mainCont">阶段试卷</a></li>
    <li><a href="make_test_paper_by_person.jsp" title="商品分类" target="mainCont">人工组卷</a></li>
    <li><a href="make_test_paper_by_random.jsp" title="商品分类" target="mainCont">智能组卷</a></li>
   </ul>
  </li>
  
  <li class="menu-list-title">
   <span>数据分析</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="user_list.jsp" title="用户列表" target="mainCont">用户统计</a></li>
    <li><a href="test_user_list.jsp" title="成绩统计" target="mainCont">成绩统计</a></li>
    <li><a href="analyze_user.jsp" title="用户分析" target="mainCont">用户分析</a></li>
   </ul>
  </li>
  
  <li class="menu-list-title">
   <span>系统设置</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="basic_settings.jsp" title="站点基本设置" target="mainCont">基本设置</a></li>
    <li><a href="admin_list.jsp" title="站点基本设置" target="mainCont">管理员信息</a></li>
   </ul>
  </li>
  
  <li class="menu-list-title">
   <span>广告管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="advertising_list.jsp" title="站点基本设置" target="mainCont">广告列表</a></li>
   </ul>
  </li>
    
 </ul>
</div>

</body>
</html>
