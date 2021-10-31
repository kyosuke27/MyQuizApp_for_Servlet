<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddPageController" method="POST">
		<label>問題</label>
		<input name="question">
		<label>解答</label>
		<input name="answer">
		<button type="submit">登録</button>
		<button type="submit" name="return_top">戻る</button>
	</form>
</body>
</html>