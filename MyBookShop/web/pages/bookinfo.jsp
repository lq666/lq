<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<h2>这里是bookinfo.jsp页面</h2>
书的编号：${sh.book.bookid }<br/>
书名：${sh.book.bookName }<br/>
作者：${sh.book.bookAuth }<br/>
出版社：${sh.book.publicPress }<br/>
价格：${sh.book.price }<br/>
库存数量：${sh.bookCount }<br/>
<a href="ac/showAccInfo?bookid=${sh.book.bookid }" >购买</a>
</body>
</html>