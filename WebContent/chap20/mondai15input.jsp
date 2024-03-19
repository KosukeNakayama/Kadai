<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.StudentExp, java.util.List" %>
<% List<StudentExp> list = (List<StudentExp>)request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap20/mondai15</title>
</head>
<body>
	<p>更新する学生をクリックしてください。</p>
	<table border="1">
	<thead><tr><th>学生番号</th><th>学生名</th><th>所属コース</th></tr></thead>
	<% for(StudentExp stu:list){ %>
		<tr>
			<td><%= stu.getStudentId() %></td>
			<td><a href="/kadai/chap20/mondai15/update?id=<%= stu.getStudentId() %>"><%= stu.getStudentName() %></a></td>
			<td><%= stu.getCourseName() %></td>
		</tr>
	<% } %>
	</table>
</body>
</html>