<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Student, java.util.List" %>
<% Student stu = (Student)session.getAttribute("stu"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap17/mondai14</title>
</head>
<body>
	<p>選択された学生の情報です。</p>
	<table border="1">
	<tr><th>学生番号</th><td><%= stu.getStudentId() %></td></tr>
	<tr><th>学生名</th><td><%= stu.getStudentName() %></td></tr>
	<tr><th>コース名</th><td><%= stu.getCourseName() %></td></tr>
	</table>
</body>
</html>