<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="menu">
	<form method="post" action="smbillBill?method=queryAllSmbillBill">
		商品名称：<input type="text" name="productName" class="input-text" value="${productName}"/>&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="payStatus">
			<option value="-1" <c:if test="${payStatus==-1}">selected</c:if> >请选择</option>
			<option value="1" <c:if test="${payStatus==1}">selected</c:if> >已付款</option>
			<option value="0" <c:if test="${payStatus==0}">selected</c:if> >未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='smbillBill?method=queryAllSupplier'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
<c:if test="${pageInfo.getTotalcount()>0}">
	<div class="content">
		<table class="list">
			<tr>
				<td>账单编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>交易金额</td>
				<td>是否付款</td>
				<td>供应商名称</td>
				<td>商品描述</td>
				<td>账单时间</td>
			</tr>
			<c:forEach items="${smbillBills}" var="smbillBill">
			<tr>
				<td>${smbillBill.billId}</td>
				<td>${smbillBill.billName}</td>
				<td>${smbillBill.billCommNum}</td>
				<td>${smbillBill.billMoney}</td>
				<td>${smbillBill.billYsono}</td>
				<td>${smbillBill.supplierName}</td>
				<td>${smbillBill.billCommdesc}</td>
				<td>${smbillBill.billCreatedate}</td>
			</tr>
			</c:forEach>
			<tr align="center">
				<td colspan="8" align="right">
					<a href="smbillBill?method=queryAllSmbillBill&productName=${productName}&payStatus=${payStatus}&apage=1">首页</a> |
					<a href="smbillBill?method=queryAllSmbillBill&productName=${productName}&payStatus=${payStatus}&apage=${apage==1?1:apage-1}">上页</a> |
					<a href="smbillBill?method=queryAllSmbillBill&productName=${productName}&payStatus=${payStatus}&apage=${apage==pageInfo.getPages()?pageInfo.getPages():apage+1}">下页</a> |
					<a href="smbillBill?method=queryAllSmbillBill&productName=${productName}&payStatus=${payStatus}&apage=${pageInfo.getPages()}">尾页</a>
					<a>第 ${pageInfo.getApage()} 页/共 ${pageInfo.getPages()} 页 （共 ${pageInfo.getTotalcount()} 条）</a>
				</td>
			</tr>
		</table>
	</div>
</c:if>
<c:if test="${pageInfo.getTotalcount()==0}"><h1 align="center">暂无数据！</h1></c:if>
</div>
</body>
</html>
