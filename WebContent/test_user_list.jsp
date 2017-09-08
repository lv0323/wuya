<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>成绩统计</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="user"></i><em>成绩统计</em></span>
  </div>
  <div class="operate">
   <form>
    <select class="inline-select">
     <option>学科</option>
     <option>JAVA</option>
     <option>PHP</option>
    </select>
    <select class="inline-select">
     <option>分数段</option>
     <option>90-100</option>
     <option>80-90</option>
     <option>70-80</option>
     <option>60-70</option>
     <option>60以下</option>
    </select>
    <input type="button" value="查询" class="tdBtn"/>
   </form>
  </div>
  <table class="list-style Interlaced">
   <tr>
     <th>用户编号</th>
     <th>会员昵称</th>
     <th>邮件地址</th>
     <th>手机号码</th>
     <th>用户密码</th>
     <th>****</th>
     <th>****</th>
     <th>****</th>
     <th>操作</th>
   </tr>
   <tr>
    <td>
     <input type="checkbox"/>
     <span class="middle">0</span>
    </td>
    <td class="center">DeathGhost</td>
    <td class="center">DeathGhost@sina.cn</td>
    <td class="center">18309275673</td>
    <td class="center">123456</td>
    <td class="center">
     <span>
      <i>￥</i>
      <b>5000000.00</b>
     </span>
    </td>
    <td class="center">
     <span>
      <i>￥</i>
      <b>300.00</b>
     </span>
    </td>
    <td class="center">2015-04-17</td>
    <td class="center">
     <a href="check_user.jsp" class="inline-block" title="查看"><img src="images/icon_view.gif"/></a>
    </td>
   </tr>
   
   
  </table>
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	  <div class="BatchOperation fl">
	   <label  class="btnStyle middle">总计：</label>
	   <span> 25人</span>
	   <label  class="btnStyle middle">平均分：</label>
	   <span> 90.0分</span>
	  </div>
	  <!-- turn page -->
	  <div class="turnPage center fr">
	   <a>第一页</a>
	   <a>1</a>
	   <a>最后一页</a>
	  </div>
  </div>
 </div>
</body>
</html>
