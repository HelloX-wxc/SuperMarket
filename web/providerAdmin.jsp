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
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
	window.location = "provider.do?id="+id+"&flag="+flag;
}
</script>
</head>
<body>
<div class="menu">

<table>
<tbody><tr><td><form method="post" action="smbillSupplier?method=queryAllSuppliers">
<input name="flag" value="search" type="hidden">
供应商名称：<input name="providerName" class="input-text" type="text" value="${providerName}"> &nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc" class="input-text" type="text" value="${providerDesc}">&nbsp;&nbsp;&nbsp;&nbsp;<input value="组 合 查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">
<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='providerAdd.jsp'" type="button"></em>
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
    <c:if test="${pageInfo.totalcount > 0}">
	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
    <td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
    <td width="100"><div class="STYLE1" align="center">联系人</div></td>
    <td width="100"><div class="STYLE1" align="center">电话</div></td>
    <td width="100"><div class="STYLE1" align="center">地址</div></td>
  </tr>
  <c:forEach items="${smbillSuppliers}" var="supplier">
  <tr>
      <td>${supplier.supplierId}</td>
      <td>${supplier.supplierName}</td>
      <td>${supplier.supplierDesc}</td>
      <td>${supplier.supplierLink}</td>
      <td>${supplier.supplierTel}</td>
      <td>${supplier.supplierAddress}</td>
  </tr>
  </c:forEach>
  <tr align="center">
      <td colspan="6" align="center">
          <a href="smbillSupplier?method=queryAllSuppliers&providerName=${providerName}&providerDesc=${providerDesc}&apage=1">首页</a> |
          <a href="smbillSupplier?method=queryAllSuppliers&providerName=${providerName}&providerDesc=${providerDesc}&apage=${apage==1?1:apage-1}">上页</a> |
          <a href="smbillSupplier?method=queryAllSuppliers&providerName=${providerName}&providerDesc=${providerDesc}&apage=${apage==pageInfo.getPages()?pageInfo.getPages():apage+1}">下页</a> |
          <a href="smbillSupplier?method=queryAllSuppliers&providerName=${providerName}&providerDesc=${providerDesc}&apage=${pageInfo.getPages()}">尾页</a>
          <a>第 ${pageInfo.getApage()} 页/共 ${pageInfo.getPages()} 页 （共 ${pageInfo.getTotalcount()} 条）</a>
      </td>
  </tr>
</tbody></table>
	</div>
    </c:if>
    <c:if test="${pageInfo.totalcount == 0}"><h1 align="center">暂无数据！</h1></c:if>
</div>
</body></html>