<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 페이지</h1>
	<form action="update.hb" method="post">
		<p>
			<label for="sabun">sabun</label>
			<input type="text" name="sabun" id="sabun" value="${dto.sabun }"/>
		</p>
		<p>
			<label for="name">name</label>
			<input type="text" name="name" id="name" value="${dto.name }" />
		</p>
		<p>
			<label for="pay">pay</label>
			<input type="text" name="pay" id="pay" value="${dto.pay }" />
		</p>
		<p>
			<button type="submit">수정</button>
			<button type="reset">취소</button>
		</p>
	</form>
</body>
</html>











