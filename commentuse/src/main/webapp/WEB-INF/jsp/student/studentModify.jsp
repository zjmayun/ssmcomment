<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/jquery.validate.css"/>
		<script type="text/javascript" src="${basePath}/js/common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${basePath}/js/common/validation/jquery.validate.js"></script>
		<script type="text/javascript" src="${basePath}/js/common/validation/messages_zh.js"></script>
		<script type="text/javascript" src="${basePath}/js/common/common.js"></script>
		<script type="text/javascript" src="${basePath}/js/student/studentModify.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form id="mainForm" method="post" action="${basePath}/student/modify" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${student.id}"/>
			<input type="hidden" id="message" value="${pageCode.msg}"/>
			<input type="hidden" id="basePath" value="${basePath}"/>
			<div class="right">
				<div class="current">当前位置：<a href="###">内容管理</a> &gt; 广告管理</div>
				<div class="rightCont">
					<p class="g_title fix">修改学生信息</p>
					<table class="tab1" width="100%">
						<tbody>
							<tr>
							<td align="right" width="10%">姓名<font color="red">*</font>：</td>
							<td width="15%">
								<input id="name" name="name" value="${student.name}" class="allInput" style="width:100%;" type="text"/>
							</td>
							<td align="right" width="10%">学科<font color="red">*</font>：</td>
							<td width="30%">
								<input id="subject" name="subject"  value="${student.subject}" class="allInput" style="width:100%;" type="text"/>
							</td>
						</tr>
						<tr>
							<td align="right" width="10%">分数<font color="red">*</font>：</td>
							<td width="30%">
								<input id="score" name="score"  value="${student.score}" class="allInput" style="width:100%;" type="text"/>
							</td>
						</tr>
					  </tbody>
					</table>
					<div style="text-align: center; margin-top: 30px;">
						<input class="tabSub" value="保     存" type="button" onclick="modify();"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="tabSub" value="返     回" type="button" onclick="goback();"/>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>