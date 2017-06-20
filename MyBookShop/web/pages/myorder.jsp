<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript">
function pay(){
	buybookform.submit();
}
</script>
</head>
<body>
<form name="buybookform" action="shc/paymoney" method="post" >
	<input type="hidden" value="${book.bookid }" name="bookid" id="bookid" /><br/>
	欢迎您：${sessionScope.users.realname }<br/>
	您选择的书籍是：《${book.bookName }》,价格为:<fmt:formatNumber value="${book.price }" pattern="￥0.00" ></fmt:formatNumber> <br/>
	请选择您准备付款的账户：<br/>
		<c:forEach items="${acclist }" var="acc" varStatus="ac" >
			<!-- ac.index : 就是用来获取当前行的索引号
					也可以使用ac.count
			 -->
		<input type="radio" value="${acc.accid }" ${ac.index==0?"checked":"" } name="accid" />账户：${acc.accid },余额：${acc.balance }<br/>
		</c:forEach>
	<a href="javascript:pay();">结算</a>
</form>
</body>
</html>