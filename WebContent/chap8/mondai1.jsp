<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chap8/mondai1</title>
</head>
<body>
	<p>こんにちは、<%= request.getParameter("name") %>(<%= request.getParameter("age") %>)さん</p>
</body>
</html>