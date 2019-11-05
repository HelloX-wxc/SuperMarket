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
<body class="frame-bd">
<ul class="left-menu">
	<li><a href="smbillBill?method=queryAllSmbillBill" target="mainFrame"><img src="images/btn_bill.gif" /></a></li>
	<li><a href="smbillSupplier?method=queryAllSuppliers" target="mainFrame"><img src="images/btn_suppliers.gif" /></a></li>
	<li><a href="smbillUser?method=queryAllUsers" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
	<li><a href="smbillUser?method=backDown" onClick="javaScript:alert('确认退出？')"><img src="images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>
