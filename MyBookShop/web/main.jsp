<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>这里是main.jsp页面</h2>
	<table border="1" cellspacing="0" width="800" >
		<tr>
			<th>编号</th>
			<th>名字</th>
			<th>作者</th>
			<th>出版社</th>
			<th>价格</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${booklist }" var="bl" >
		<tr>
			<td>${bl.bookid }</td>
			<td><a href="shc/showbookinfo?bookid=${bl.bookid }">${bl.bookName }</a></td>
			<td>${bl.bookAuth }</td>
			<td>${bl.publicPress }</td>
			<td>${bl.price }</td>
			<td>
				<a href="">编辑</a>
				<a href="" >删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>