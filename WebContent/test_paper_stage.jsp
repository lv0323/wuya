<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>查看试题</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>阶段测试试卷明细</em></span>
  </div>
  <div class="operate">
 	<span>
 		试卷编号：
 	</span>
 	<span>
 		学科：
 	</span>
 	<span>
 		阶段：
 	</span>
 	<span>
 		试题数量：
 	</span>
 	<span>
 		总分：
 	</span>
  </div>
  <table class="list-style Interlaced">
   <tr>
    <th>试题编号</th>
    <th>难易程度</th>
    <th>试题内容</th>
    <th>所属学科</th>
    <th>对应阶段</th>
    <th>相关知识点</th>
    <th>分值</th>
    <th>操作</th>
   </tr>
   <tr>
    <td>
     <span>
     <input type="checkbox" class="middle children-checkbox"/>
     <i>1</i>
     </span>
    </td>
    <td class="center pic-area"><img src="#" class="thumbnail"/></td>
    <td class="td-name">
      <span class="ellipsis td-name block">这是产品或服务名称(宽度350px,样式自动截取，以省略号表示哦，程序可以处理“截取字符串”)</span>
    </td>
    <td class="center">
     <span>
      JAVA
     </span>
    </td>
    <td class="center">
     <span>
      JAVA SE
     </span>
    </td>
    <td class="center">
     <span>
      if 分支
     </span>
    </td>
    <td class="center">1</td>
    <td class="center">
     <a href="edit_product.jsp" title="查看" ><img src="images/icon_view.gif"/></a>
    </td>
   </tr>
  </table>
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	  <div class="BatchOperation fl">
	   <a  href="product_category_stage.jsp"><input  type="button" value="返回" class="btnStyle" /></a>
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
