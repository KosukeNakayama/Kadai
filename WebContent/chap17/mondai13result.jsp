<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Student, java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap17/mondai13</title>
</head>
<body>
	<p>単価<%= session.getAttribute("price") %>円の物を<%= session.getAttribute("quantity") %>個買ったら、
	<%= request.getAttribute("total") %>円です。</p>
</body>
</html>