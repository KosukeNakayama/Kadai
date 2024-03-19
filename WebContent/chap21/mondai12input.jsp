<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Course, java.util.List" %>
<% List<Course> list = (List<Course>)request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap21/mondai12</title>
</head>
<body>
	<p>削除するコースを選択してください。</p>
	<form action ="/kadai/chap21/mondai12/delete">
		<select name="id">
		<% for(Course cou:list){ %>
			<option value="<%= cou.getCourseId()%>"><%= cou.getCourseName() %></option>
		<% } %>
		</select>
		<input type="submit" value="送信">
	</form>
</body>
</html>