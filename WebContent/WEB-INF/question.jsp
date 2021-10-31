<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Question> questions=(ArrayList<Question>)request.getAttribute("questions");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="QuizAnswer" method="post">
		<% for(int i=0;i<questions.size();i++){%>
			<p><%= questions.get(i).getQuestionString() %></p>
			<input type="text" name="<%=  questions.get(i).getQuestionId()%>">
		<%} %>
		<br>
		<button type="submit">送信</button>
	</form>
	<form action="AddPageController">
		<button type="submit">登録画面へ</button>
	</form>
</body>
</html>