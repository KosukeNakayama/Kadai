<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap21/mondai12</title>
</head>
<body>
	<p><%= request.getAttribute("message") %></p>
	<% if(request.getAttribute("course") != null){ %>
		<p>削除したコースの内容は以下の通りです。</p>
		<table border="1">
			<tr><th>コース番号</th><td>${course.courseId }</td>
			<tr><th>コース名</th><td>${course.courseName }</td>
		</table>
	<% } %>
</body>
</html>