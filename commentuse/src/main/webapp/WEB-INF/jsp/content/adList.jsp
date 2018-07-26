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
		<form action="${basePath}/ad/search" id="mainForm" method="post">
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
									<input name="title" id="title" value="" class="allInput" type="text"/>
								</td>
	                            <td style="text-align: right;" width="150">
	                            	<input class="tabSub" value="查询" onclick="search('1');" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                            	<t:auth url="/ad/addInit">
	                            		<input class="tabSub" value="添加" onclick="location.href='${basePath}/ad/addInit'" type="button"/>
	                            	</t:auth>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
								    <th>序号</th>
								    <th>标题</th>
								    <th>摘要</th>
								    <th>链接地址</th>
								    <th>操作</th>
								</tr>
								<c:forEach items="${list}" var="item" varStatus="s">
									<tr>
									    <td><input type="checkbox" name="select" value="${item.id } "/></td>
										<td>${s.index + 1}</td>
										<td>${item.title}</td>
										<td>${item.summary }</td>
										<td>${item.link}</td>
										<td>
											<t:auth url="/ad/modifyInit">
												<a href="javascript:void(0);" onclick="modifyInit('${item.id}')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
											</t:auth>
											<t:auth url="/ad/remove">
												<a href="javascript:void(0);" onclick="remove('${item.id}')">删除</a>
											</t:auth>
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
		   $("#mainForm").attr("action",$("#basePath").val() + "/ad/removeBatch");
		   $("#mainForm").submit();
	}
	 	   
	   
	</script>
<script type="text/javascript" src="${basePath}/js/content/adList.js"></script>
	