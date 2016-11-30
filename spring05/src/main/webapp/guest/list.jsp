<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<c:if test="${loginGo }">
	<p><a href="../login.do">로그인 페이지</a></p>
</c:if>
</div>
	<h1>list page</h1>
	<table>
	<tr>
		<th>사번</th>
		<th>이름</th>
		<th>날짜</th>
		<th>금액</th>
	</tr>
	<c:forEach items="${alist }" var="bean">
	<tr>
		<td>${bean.sabun }</td>
		<td><a href="detail.do?idx=${bean.sabun }">${bean.name }</a></td>
		<td>${bean.nalja }</td>
		<td>${bean.pay }</td>
	</tr>
	</c:forEach>
	
	</table>
	<c:if test="${loginOk}">
		<p><a href="add.do">입력</a></p>
	</c:if>
</body>
</html>









