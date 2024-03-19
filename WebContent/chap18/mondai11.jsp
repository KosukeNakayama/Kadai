<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Student, java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap18/mondai11</title>
</head>
<body>
	<p>あなたは<%= request.getAttribute("count")%>回目の訪問ですね。</p>
</body>
</html>