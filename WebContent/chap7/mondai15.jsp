<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chap7/mondai15</title>
</head>
<body>
	<% String str = "問題15はこれにてクリア！お疲れ様でした。"; %>
	<%= str+"<br>" %>
	<% Date date = new Date();%>
	<% String[] dayOfWeek = {"日","月","火","水","木","金","土"}; %>
	<%= String.format("%d年%d月%d日(%s)　%d:%d:%d",date.getYear()+1900,date.getMonth()+1,date.getDate(),dayOfWeek[date.getDay()],date.getHours(),date.getMinutes(),date.getSeconds()) %>
</body>
</html>