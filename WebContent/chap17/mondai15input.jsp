<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.StudentExp, java.util.List" %>
<% List<StudentExp> list = (List<StudentExp>)request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap17/mondai15</title>
</head>
<body>
	<p>表彰する学生を選択してください。</p>
	<form action ="/kadai/chap17/mondai15/add">
	<table border="1">
	<thead><tr><th></th><th>学生番号</th><th>学生名</th><th>コース名</th></tr></thead>
	<tbody>
	<% for(StudentExp stu:list){ %>
		<tr>
			<td><input type="checkbox" name="studentIds" value="<%= stu.getStudentId()%>" <% if(stu.isCheck()){out.print("checked");} %>></td>
			<td><%= stu.getStudentId() %></td>
			<td><%= stu.getStudentName() %></td>
			<td><%= stu.getCourseName() %></td>
		</tr>
	<% } %>
	</tbody>
	</table>
	<input type="submit" value="追加">
	</form>
</body>
</html>