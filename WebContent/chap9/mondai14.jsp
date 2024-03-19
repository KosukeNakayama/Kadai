<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chap9/mondai14</title>
</head>
<body>
	<p>こんにちは。こちらはフォワードされたJSPです。<br>
	入力頂いた内容は以下でよろしいでしょうか？</p>
	<p>お名前：<%= request.getParameter("name") %><br>
	   ご年齢：<%= request.getParameter("age") %><br>
	   　性別：<%= request.getParameter("gender") %></p>
</body>
</html>