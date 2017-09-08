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
<link href="${pageContext.request.contextPath}/style/adminStyle.css" rel="stylesheet" type="text/css" />
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

/* 

//分页
$(function(){
	requestMepperController();
}); 


function requestMepperController(){
	questionname = $("#handfind").val();
	subjectname = $("#province").val();
	knowlegename = $("#city").val();
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
	    	
		   $.ajax(
		   {url:"getallquestion2.do",
	    	type : "post",
			dataType : "json",
			data : "subjectname=" + subjectname + "&knowlegename="
					+ knowlegename+"&questionname=" + questionname+"&pages="+num,

			success : function(data) {
				
				//状态码为0 表示查询没有结果
				if (data.status == 0) {
					//将表格内容隐藏
					$("#tablecon").hide();
					//显示没有题目
					$("#nomessage").html(
							"<br><br><center><h1>没有相关题目</h1></center>");
					$("#nomessage").css({
						"fontSize" : "30px",
						"color" : "red",
						"megin" : "auto"
					});

				} else {
					//将表格中内容清空
					$("#tablecon").html("");
					$("#nomessage").html("");
					$("#tablecon").show();
					$("#tablecon").append("<tr><th>试题编号</th><th>难易程度</th><th>试题内容</th><th>所属学科</th><th>相关知识点</th><th>分值</th><th>操作</th></tr>");
					
					//向表格中循环插入查询到的试题
					for (var i = 0; i < data.body.length; i++) {
						//追加一条试题
						$("#tablecon").append(
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
										+ "</td><td class='center'> <a href='find_product.jsp?id="+data.body[i].question_id+"' title='查看' >"+
										"<img src='images/icon_view.gif' /></a>"+
										"<a href='edit_product.jsp?id="+data.body[i].question_id+"' title='编辑' >"+
										"<img src='images/icon_edit.gif'  /></a>"+
										"<a onclick='removeitems("+data.body[i].question_id+")' title='删除' >"+
										"<img src='images/icon_drop.gif'/></a></td></tr>");
					}
				}
			}
		});
	      }
	     
	    }
	});
}
*/


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
	
</script>

	<script type="text/javascript">
	
		//清空用户的选择
		function clr() {
			$("#handfind").val("");
			$("#province").val("请选择学科");
			$("#city").val("请选择知识点");

		}
		//按要求查询试题
		function findquestion() {
		
			questionname = $("#handfind").val();
			subjectname = $("#province").val();
			knowlegename = $("#city").val();

			$.ajax({
				url : "getallquestion2.do",
				type : "post",
				dataType : "json",
				data : "subjectname=" + subjectname + "&knowlegename="
						+ knowlegename+"&questionname=" + questionname,

				success : function(data) {
					//状态码为0 表示查询没有结果
					if (data.status == 0) {
						//将表格内容隐藏
						$("#tablecon").hide();
						//显示没有题目
						$("#nomessage").html(
								"<br><br><center><h1>没有相关题目</h1></center>");
						$("#nomessage").css({
							"fontSize" : "30px",
							"color" : "red",
							"megin" : "auto"
						});

					} else {
						//将表格中内容清空
						$("#tablecon").html("");
						$("#nomessage").html("");
						$("#tablecon").show();
						$("#tablecon").append("<tr><th>试题编号</th><th>难易程度</th><th>试题内容</th><th>所属学科</th><th>相关知识点</th><th>分值</th><th>操作</th></tr>");
						
						//向表格中循环插入查询到的试题
						for (var i = 0; i < data.body.length; i++) {
							//追加一条试题
							$("#tablecon").append(
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
											+ "</td><td class='center'> <a href='find_product.jsp?id="+data.body[i].question_id+"' title='查看' >"+
											"<img src='images/icon_view.gif' /></a>"+
											"<a href='edit_product.jsp?id="+data.body[i].question_id+"' title='编辑' >"+
											"<img src='images/icon_edit.gif'  /></a>"+
											"<a onclick='removeitems("+data.body[i].question_id+")' title='删除' >"+
											"<img src='images/icon_drop.gif'/></a></td></tr>");
						}
					}
				}
			});

		} 
		//删除选中的一道试题
		function removeitems(i) {
			$.ajax({
				url : "removequestion.do",
				type : "post",
				dataType : "json",
				data : "questionid=" + i,
				success : function(data) {
				}
			})
			$("#items" + i).remove();

		}
		//全选与取消全选
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
					url : "removequestion.do",
					type : "post",
					dataType : "json",
					data : "questionid=" + i,
					success : function(data) {
					}
				})
				//删除前端页面此条消息
				$(this).parent().parent().remove();
			});


		}
	</script>




</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>试题列表</em></span>
    <span class="modular fr"><a href="add_product.jsp" class="pt-link-btn">+添加试题</a></span>
  </div>
  <div class="operate">
   <form id="selectList">
 选择查询：  <select class="inline-select" id="province">
     <option>请选择学科</option>
    </select>
    <select class="inline-select" id="city">
     <option>请选择知识点</option>
    </select>
   <input type="text" class="textBox length-long " placeholder="输入查询关键字..." id="handfind"/>
    &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp;  &nbsp;   &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;
    <input type="button" value="查询" class="tdBtn btn-info" onclick="findquestion()"/>
   
    <input type="button" value="清空" class="tdBtn btn-danger" onclick="clr()"/>

   </form>
  </div>
    <span id="nomessage"></span>
  <table class="list-style Interlaced table-bordered  table-striped table-hover table-condensed " id="tablecon">
   <tr>
    <th>试题编号</th>
    <th>难易程度</th>
    <th>试题内容</th>
    <th>所属学科</th>
    <th>相关知识点</th>
    <th>分值</th>
    <th>操作</th>
   </tr>
   <tr>
   
 
   </tr>
  </table>

   <div class="pagination" id="haha"></div>
  <!-- BatchOperation -->
  <div style="overflow:hidden;" id="page1" >
      <!-- Operation -->
	  <div class="BatchOperation fl">
	  
	   <label for="del" class="btnStyle middle" id="allcheak" onclick="allcheck()">全选</label>
	   <input type="button" value="批量删除" class="btnStyle" id="haha" onclick="clearall()"/>
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
