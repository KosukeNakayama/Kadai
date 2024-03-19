<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Course, java.util.List" %>
<% List<Course> list = (List<Course>)request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap21/mondai13</title>
</head>
<body>
	<p>更新するコースをクリックしてください。</p>
	<table border="1">
	<thead><tr><th>学生番号</th><th>コース名</th></tr></thead>
	<% for(Course cou:list){ %>
		<tr>
			<td><%= cou.getCourseId() %></td>
			<td><a href="/kadai/chap21/mondai13/update?id=<%= cou.getCourseId() %>"><%= cou.getCourseName() %></a></td>
		</tr>
	<% } %>
	</table>
</body>
</html>