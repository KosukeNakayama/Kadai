<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="mondai2error.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chap8/mondai1</title>
</head>
<body>
	<p>こんにちは、<%= request.getParameter("name") %>さん<br>
	10年後は<%= Integer.parseInt(request.getParameter("age")) + 10 %>歳ですね！</p>

</body>
</html>