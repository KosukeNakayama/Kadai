<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Student, java.util.List" %>
<%List<Student> list=(List<Student>)request.getAttribute("list");%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chap16/mondai9</title>
</head>
<body>
<h3>学生一覧</h3>

<table border="1">
<thead><th>学生番号</th><th>学生氏名</th><th>コース番号</th></thead>
<tbody>
<% for (Student stu : list) { %>
	<tr>
		<td><%=stu.getStudentId() %></td>
		<td><%=stu.getStudentName() %></td>
		<td><%=stu.getCourseId() %></td>
	</tr>
<% } %>
</tbody>
</table>
</body>
</html>