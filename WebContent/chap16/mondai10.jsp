<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Course, java.util.List" %>
<%List<Course> list=(List<Course>)request.getAttribute("list");%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chap16/mondai10</title>
</head>
<body>
<h3>コース一覧</h3>

<table border="1">
<thead><th>コース番号</th><th>コース名</th></thead>
<tbody>
<% for (Course cou : list) { %>
	<tr><td><%=cou.getCourseId() %></td><td><%=cou.getCourseName() %></td></tr>
<% } %>
</tbody>
</table>
</body>
</html>