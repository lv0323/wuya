<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>试卷列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<link href="Insert%20title%20here_files/topbar.css" rel="stylesheet" />
<link href="Insert%20title%20here_files/profile.css" rel="stylesheet" />
<link href="Insert%20title%20here_files/mypaper.css" rel="stylesheet" />
<link href="Insert%20title%20here_files/lc_switch.css" rel="stylesheet" />
<script src="Insert%20title%20here_files/jquery-1.js" type="text/javascript"></script>
<script src="Insert%20title%20here_files/jquery.js" type="text/javascript"></script>
<script src="Insert%20title%20here_files/lc_switch.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"/WuYa/zbwweekexamsubject.do",
			type:"get",
			dataType:"JSON",
			success:function(data){
				for(var i = 0;i<data.length;i++){
					$("#subject").append("<option>"+data[i]+"</option>");
				}
			}
		})
	});
	
	function findWeek(){
		$.ajax({
			url:"/WuYa/zbwweekexamweek.do",
			type:"post",
			data:"name="+$("#subject").val(),
			dataType:"JSON",
			success:function(data){
				$(".optiona").remove();
				for(var i = 0;i<data.length;i++){
					$("#week").append("<option class='optiona'>"+data[i].weekly_type_name+"</option>");
				} 
			}
		});
	}

	function empty_seek(){
		$("#subject").val("学科");
		$("#week").val("周")
		$("#search").val("");
	}
	 
	function hehe(id){
		var element1 = document.getElementById("33"+id);
		var status = element1.value;
		if(status==1){
			$("#33"+id).val(0);
		}else{
			$("#33"+id).val(1);
		}
		status==0?status=1:status=0;
		status==0?element1.className="lcs_switch  lcs_on lcs_checkbox_switch":element1.className="lcs_switch  lcs_off lcs_checkbox_switch";

		$.ajax({
			url:"/WuYa/zbwweekexamdisplay.do",
			type:"post",
			data:"id="+id+"&status="+status,
			dataType:"JSON",
			success:function(data){
				
			}
			
		});
	}
	
	
	
	function submit_seek(){
		var search = $("#search").val();
		var subject = $("#subject").val();
		var week = $("#week").val();
		$.ajax({
			url:"/WuYa/zbwweekexamlist.do",
			type:"post",
			data:"search="+search+"&subject="+subject+"&week="+week,
			dataType:"json",
			success:function(data){
				$(".selecttr").remove();
				for(var i = 0 ; i < data.length;i++){
					var id=data[i].id;
					var name=data[i].name;
					var time=data[i].time;
					var week=data[i].week;
					var subject=data[i].subject;
					var total=data[i].tatal_points;
					var display=data[i].display;
					if(display==1){
						var asdfghjkl="lcs_switch  lcs_off lcs_checkbox_switch";
					}else{
						var asdfghjkl="lcs_switch  lcs_on lcs_checkbox_switch";
						
					}
					$("#week_exam_list").append(" <tr class='selecttr'><td><input type='checkbox' value='"+id+"'/><span>"+id+"</span></td><td class='center'>"+subject+"</td><td class='center'>"+week+"</td>"+
							
							
							
							
							"<td class='center'>"+name+"</td><td class='center'>"+time+"</td><td class='center'>"+total+"</td><td class='center'><div class='lcs_wrap' onclick='hehe("+id+")' id='"+id+"'><input name='188' value='"+display+"' class='lcs_check' autocomplete='off'	type='checkbox'><div class='"+asdfghjkl+"' id ='33"+id+"'><div class='lcs_cursor'></div><div class='lcs_label lcs_label_on'>开启</div><div class='lcs_label lcs_label_off'>关闭</div></div></div></td>"+
							
							
							
							
							
							"<td class='center'><a href='${pageContext.request.contextPath}/zbwfindWeekExamQuestion.do?id="+id+"' title='编辑'><img src='images/icon_edit.gif'/></a><a  title='删除' onclick='deleteExam("+id+")'><img src='images/icon_trash.gif'/></a>"+
							"</td></tr>");
					if(display==1){
						$("#33"+id).val(1);
					}else{
						$("#33"+id).val(0);
					}
				}
			}
		});
		
	}

	 function deleteExam(id){
		 $.ajax({
			url:"/WuYa/zbwdeleteexam.do",
			type:"post",
			data:"id="+id,
			dataType:"json",
			success:function(data){
				submit_seek();
			}
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
					url:"/WuYa/zbwdeleteexam.do",
					type:"post",
					data:"id="+i,
					dataType:"json",
					success:function(data){
						submit_seek();
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
    <span class="modular fl"><i></i><em>周测试卷列表</em></span>
  </div>
   <div class="operate">
   <form>
    <select class="inline-select" id="subject" onchange="findWeek()" >
     <option>学科</option>
    </select>
    <select class="inline-select" id="week">
     <option>周</option>
    </select>
    <input type="text" id="search" class="textBox length-long" placeholder="输入试卷名称..."/>
    <input type="button" value="清空" class="tdBtn" onclick="empty_seek()"/>
    <input type="button" value="查询" class="tdBtn" onclick="submit_seek()"/>
   </form>
  </div>
  <table class="list-style" id="week_exam_list" >
   <tr>
    <th>试卷编号</th>
    <th>所属学科</th>
    <th>对应周</th>
    <td>试卷名称</td>
    <th>创建时间</th>
    <th>总分</th>
    <th>是否启用</th>
    <th>操作</th>
   </tr>
  </table>
  
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	  <div class="BatchOperation fl">
	   <input type="checkbox" id="del"/>
	   <label for="del" class="btnStyle middle" onclick="allcheck()">全选</label>
	   <input type="button" value="批量删除" id="allcheak" class="btnStyle" onclick="clearall()"/>
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
