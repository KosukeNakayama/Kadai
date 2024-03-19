<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Student, java.util.List" %>
<% List<Student> list = (List<Student>)request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap17/mondai14</title>
</head>
<body>
	<p>学生を選択してください。</p>
	<form action ="/kadai/chap17/mondai14/while">
		<select name="id">
		<% for(Student stu:list){ %>
			<option value="<%= stu.getStudentId()%>"><%= stu.getStudentName() %></option>
		<% } %>
		</select>
		<input type="submit" value="送信">
	</form>
</body>
</html>