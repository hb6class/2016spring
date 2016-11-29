<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.err{
		text-align: center;
		color: red;
	}
</style>
</head>
<body>
	<h1>로그인 페이지</h1>
	<div class="err">${errMsg }</div>
	<form action="result.do">
		<p>
			<label for="id">id:</label>
			<input type="text" name="id" id="id" />
		</p>
		<p>
			<label for="pw">pw:</label>
			<input type="text" name="pw" id="pw" />
		</p>
		<p>
			<button type="submit">로그인</button>
			<button type="reset">취소</button>
		</p>
	</form>
</body>
</html>









