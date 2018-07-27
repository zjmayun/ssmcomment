<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
		<script type="text/javascript" src="${basePath}/js/common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${basePath}/js/common/common.js"></script>
		
	</head>
	
	
	<body style="background: #e1e9eb;">
		<form action="${basePath}/student/query" id="mainForm" method="post">
			<input type="hidden" id="id" name="id"/>
			<input type="hidden" id="subString" name="subString"/>
			<input type="hidden" id="message" value="${pageCode.msg}"/>
			<input type="hidden" id="basePath" value="${basePath}"/>
			<input type="hidden" name="page.currentPage" id="currentPage" value="1"/>
			<div class="right">
				<div class="current">当前位置：<a href="#">内容管理</a> &gt; 广告管理</div>
				<div class="rightCont">
					<p class="g_title fix">广告列表</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td align="right" width="80">标题：</td>
								<td>
									<input name="name" id="name" value="" class="allInput" type="text"/>
								</td>
	                            <td style="text-align: right;" width="150">
	                            	<input class="tabSub" value="查询" onclick="search('1');" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                            		<input class="tabSub" value="添加" onclick="location.href='${basePath}/student/addInit'" type="button"/>
	                            </td>
	                            <td>
	                             <input class="tabSub" value="全选" id="checkAll" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                             
	                             <input class="tabSub" value="批量删除 " id="removeBatch" onclick="remo()" type="button"></input>
	                            </td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>select</th>
								    <th>sequence</th>
								    <th>name</th>
								    <th>subject</th>
								    <th>score</th>
								    <th>操作</th>
								</tr>
								<c:forEach items="${studentList}" var="item" varStatus="s">
									<tr>
									    <td><input type="checkbox" name="select" value="${item.id } "/></td>
										<td>${s.index + 1}</td>
										<td>${item.name}</td>
										<td>${item.subject }</td>
										<td>${item.score}</td>
										<td>
												<a href="javascript:void(0);" onclick="modifyInit('${item.id}')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
												<a href="javascript:void(0);" onclick="remove('${item.id}')">删除</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						
						
						
						<!-- 分页 -->
						<t:page jsMethodName="search" page="${searchParam.page}"></t:page>
					</div>
				</div>
			</div>
		</form>
		
		<input class="tabSub" value="max/avg" onclick="location.href='${basePath}/student/queryMaxAndAvg'" type="button"/>
		<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>subject</th>
								    <th>MaxScore</th>
								    <th>MinScore</th>
								</tr>
								<c:forEach items="${maxSubject}" var="item" varStatus="s">
									<tr>
										<td>${item.subject}</td>
										<td>${item.score}</td>
										<td>${avgSubject[s.count-1].score}</td>
									</tr>
								</c:forEach>
							</tbody>
		</table>
		
	</body>
	
</html>

<script type="text/javascript">
	 
	   
	   function remo(){
		   var temp="";
		   var each="";
		   var select=document.getElementsByName("select");
		   for(var i=0;i<select.length;i++){
			   if(select[i].checked){
				   each=select[i].value;
				   temp=temp+","+each;
			   }
		   }
		   document.getElementById("subString").value=temp.substring(1,temp.length);
		   $("#mainForm").attr("action",$("#basePath").val() + "/student/removeBatch");
		   $("#mainForm").submit();
	}
	 	   
	   
	</script>
<script type="text/javascript" src="${basePath}/js/student/studentlist.js"></script>
	