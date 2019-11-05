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
}
</script>
</head><body>




<div class="menu">

<table>
<tbody><tr><td><form method="post" action="smbillUser?method=queryAllUsers">
<input name="flag" value="search" class="input-text" type="hidden">
用户名称：<input name="userName" class="input-text" type="text" value="${userName}">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">
<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='userAdd.jsp'" type="button"></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>
    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
  </tr>
  <c:forEach items="${smbillUsers}" var="user">
  <tr>
    <td height="23"><span class="STYLE1">${user.userId}</span></td>
    <td><span class="STYLE1"><a href="#" onclick="doit('mod',1)">${user.userName}</a></span></td>
    <td><span class="STYLE1">${user.userGender}</span></td>
    <td><span class="STYLE1">${user.userAge}</span></td>
    <td><span class="STYLE1">${user.userTel}</span></td>
    <td><span class="STYLE1">${user.userAddress}</span></td>
    <td><span class="STYLE1">${user.userLimited}</span></td>
  </tr>
  </c:forEach>
  <tr align="center">
    <td colspan="7" align="center">
      <a href="smbillUser?method=queryAllUsers&userName=${userName}&apage=1">首页</a> |
      <a href="smbillUser?method=queryAllUsers&userName=${userName}&apage=${apage==1?1:apage-1}">上页</a> |
      <a href="smbillUser?method=queryAllUsers&userName=${userName}&apage=${apage==pageInfo.getPages()?pageInfo.getPages():apage+1}">下页</a> |
      <a href="smbillUser?method=queryAllUsers&userName=${userName}&apage=${pageInfo.getPages()}">尾页</a>
      <a>第 ${pageInfo.getApage()} 页/共 ${pageInfo.getPages()} 页 （共 ${pageInfo.getTotalcount()} 条）</a>
    </td>
  </tr>
</tbody></table>
</div>
</div>
</body></html>