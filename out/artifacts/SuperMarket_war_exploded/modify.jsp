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
	<form method="get" action="smbillBill?method=queryAllSmbillBill">
		商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="payStatus">
			<option value="-1">请选择</option>
			<option value="1">已付款</option>
			<option value="0">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='smbillBill?method=queryAllSupplier'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form method="post" action="smbillBill?method=addSmbillBill">
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">账单编号：</td>
					<td><input type="text" name="billNum" class="text" /></td>
				</tr>
				<tr>
					<td class="field">商品名称：</td>
					<td><input type="text" name="commodity" class="text" /></td>
				</tr>
				<tr>
					<td class="field">商品数量：</td>
					<td><input type="text" name="commNum" class="text" /></td>
				</tr>
				<tr>
					<td class="field">交易金额：</td>
					<td><input type="text" name="money" class="text" /></td>
				</tr>
				<tr>
					<td class="field">商品描述：</td>
					<td><textarea name="discription"></textarea></td>
				</tr>
				<tr>
					<td class="field">供应商名称：</td>
					<td>
						<select name="supplierIdAndName">
							<c:forEach items="${smbillSuppliers}" var="supplier">
								<option value="${supplier.supplierId},${supplier.supplierName}">${supplier.supplierName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>账单创建时间：</td>
					<td><input type="date"></td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td><select name="isPay">
						<option value="1">是</option>
						<option value="0">否</option>
					</select></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="确认" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
</body>
</html>
