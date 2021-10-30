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
			<input type="text" name="question<%= i %>">
		<%} %>
		<br>
		<button type="submit">送信</button>
	</form>
</body>
</html>