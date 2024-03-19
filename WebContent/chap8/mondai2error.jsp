<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chap8/mondai1/error</title>
</head>
<body>
	<p>こんにちは、<%= request.getParameter("name") %>さん<br>
	年齢の欄には、数値の入力をお願いします。</p>

	<p>以下エラー内容です。<br>
	<%= exception %>
	</p>

</body>
</html>