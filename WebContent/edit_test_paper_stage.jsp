<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>查看试题</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/js/page.css" rel="stylesheet"></link>
<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jqPaginator.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/public.js" type="text/javascript"></script>
<script type="${pageContext.request.contextPath}/text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
 $(function(){
	requestMepperController();
}); 


function requestMepperController(){
	var ok = true;
	$('#haha').jqPaginator({
	    totalPages:${totalPages},
	    visiblePages: 5,
	    currentPage:${page},
	    onPageChange: function (num, type) {
	      // alert('当前第' + num + '页');
	      if(ok){
	    	 ok = false; 
	      }else{
	    	 window.location.href="${pageContext.request.contextPath}/zbwfindStageExamQuestion.do?pages="+num+"&id="+${param.id};
	      }
	     
	    }
	});
}
function deleteQuestionById(id){
	
	layer.confirm('是否删除？', {
		time: 20000,
		  btn: ['是','否'] //按钮
		}, function(){
		  layer.msg('已删除');
		  $.ajax({
				url:"/WuYa/zbwdeletestagequestion.do",
				type:"post",
				data:"questionId="+id+"&examId="+${id},
				dataType:"json",
				success:function(data){
					window.location.reload();
				}
			 });
		}, function(){
			layer.msg('已取消');
		  }); 
}

function allcheck() {
	//判断是否被选中
	if ($(":checkbox").is(':checked')) {
		//已选中，将复选框的checked属性移除
		$(":checkbox").removeAttr("checked");
		//将按钮的文字改为全选
		$("#allcheak").html("全选");
	} else {
		//未选中选中，将复选框的checked属性设置为true
		$(":checkbox").prop("checked", 'true');
		//将按钮的文字改为取消全选
		$("#allcheak").html("取消全选");
	}
}


//批量删除试题试题
function clearall() {
	//获取所有被勾选的元素
	$(":checkbox:checked").each(function() {
		//获取一条被选中框的内容
		i = $(this).parent().text();
		//发起ajax删除一条试题内容
		$.ajax({
				url:"/WuYa/zbwdeletestagequestion.do",
				type:"post",
				data:"questionId="+i+"&examId="+${id},
				dataType:"json",
				success:function(data){
					window.location.reload();
				}
			 });
		//删除前端页面此条消息
		$(this).parent().parent().remove();
	});


}

</script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>编辑阶段测试试卷</em></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/zbwselectstagequestion.do?id=${id}&subject=${subject}" class="pt-link-btn">+添加试题</a></span>
  </div>
   <div class="operate">
  	<span>
 		试卷编号：${id}
 	</span>
 	<span>
 		学科：${subject}
 	</span>
 	<span>
 		试题数量：${countQuestion}
 	</span>
 	<span>
 		总分：${score}
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
      <c:forEach items="${Stage_Exam_Question_List_vo}" var="w">
   <tr>
    <td>
     <input type="checkbox" class="middle children-checkbox"/>
     <i>${w.id}</i>
    </td>
    <td class="center pic-area">${w.easy}</td>
    <td class="td-name">
      <span class="ellipsis td-name block">${w.name}</span>
    </td>
    <td class="center">
     <span>
      ${w.subject}
     </span>
    </td>
    <td class="center">
     <span>
      ${w.stage}
     </span>
    </td>
    <td class="center">
     <span>
      ${w.knowlege}
     </span>
    </td>
    <td class="center">${w.score}</td>
    <td class="center">
     <a href="edit_product.jsp?id=${w.id}" title="查看/修改试题" ><img src="images/icon_view.gif"/></a>
     <a title="删除" onclick="deleteQuestionById(${w.id})"><img src="images/icon_drop.gif"/></a>
    </td>
   </tr>
   </c:forEach>
  </table>
    <div class="pagination" id="haha"></div>
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	  <div class="BatchOperation fl">
	   <label for="del" class="btnStyle middle" onclick="allcheck()">全选</label>
	   <input type="button" value="批量删除" id="allcheak" class="btnStyle" onclick="clearall()"/>
	   <input  type="button" value="保存"  class="btnStyle" onclick="window.location.href='${pageContext.request.contextPath}/product_category_stage.jsp'"/>
 	<a  href="product_category_stage.jsp"><input  type="button" value="返回" class="btnStyle" /></a>

 </div>
 </div>
</body>
</html>
