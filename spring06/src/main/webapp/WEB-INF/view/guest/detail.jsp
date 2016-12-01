<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세페이지</h1>
	<table>
		<tr>
			<td>sabun</td>
			<td>${dto.sabun }</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<td>nalja</td>
			<td>${dto.nalja }</td>
		</tr>
		<tr>
			<td>pay</td>
			<td>${dto.pay }</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="edit.hb?idx=${dto.sabun }">수정</a>
				<a href="del.hb?idx=${dto.sabun }">삭제</a>
			</td>
		</tr>
	</table>
</body>
</html>







