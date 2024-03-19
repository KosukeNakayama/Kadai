<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Student, java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap18/mondai12disp</title>
</head>
<body>
	<p>こんにちは、<%= request.getAttribute("name") %>さん。<br>
	<% if((Integer)request.getAttribute("count") == 1){ %>
		初めての訪問ですね。ありがとうございます。
	<%}else{ %>
		あなたは<%= request.getAttribute("count")%>回目の訪問ですね。<br>
		前回は、<%= request.getAttribute("lastDate")%>ごろにきていただいたみたいですね。<br>
		再訪、お待ちしていました。
	<%} %>
	</p>
</body>
</html>