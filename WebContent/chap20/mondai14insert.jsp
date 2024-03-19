<%@page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="course" class="bean.Course" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap20/mondai14</title>
</head>
<body>
	<p><%= request.getAttribute("message") %></p>
	<% if(request.getAttribute("course") != null){ %>
		<p>登録した内容は以下の通りです。</p>
		<table border="1">
			<tr><th>コース番号</th><td><jsp:getProperty name="course" property="courseId" /></td>
			<tr><th>コース名</th><td><jsp:getProperty name="course" property="courseName" /></td>
		</table>
	<% } %>
</body>
</html>