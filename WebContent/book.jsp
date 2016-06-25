<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ljheee.app.entity.Book ,java.util.*"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示列表</title>
</head>
<body>
<h1> 显示列表</h1>



<% List<Book> list =(List<Book>)request.getAttribute("books"); %>

<div><a href = "book/save">添加新图书 </a> </div>  <!-- 注意路径，-->
<table width="70%" align="center">
<caption>图书列表 </caption>
	<tr>   
	<th> 编号 </th>
	<th> 书名 </th>
	<th> 作者 </th>
	<th> 价格 </th>
	<th> 操作 </th>
	</tr>
	
	<%
	for(Book b : list){
		pageContext.setAttribute("b", b);
	
	%>
	<tr>   
	<td> ${b.id } </td>
	<td> ${b.title } </td>
	<td> ${b.author } </td>
	<td> <%=b.getPrice() %> </td>
	<td>
		<form style="display:inline" action="book/remove" method="post">
		<input type="hidden" name="id" value="${b.id}" />	
		<input type="submit" value="删除" />	
		
		</form>
		<a href="book/edit?&id=${b.id}"> 编辑  </a>  <!-- 带参数，是get-->
	</td>
	
	</tr>

	<%} %>

</table>
<a href="index.html">返回首页</a>
</body>
</html>