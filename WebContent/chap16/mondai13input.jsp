<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Student, java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap16/mondai13</title>
</head>
<body>
	<p>検索したいお名前を入力してください。</p>
	<form action ="mondai13">
		<label>お名前：<input name="name"></label>
		<input type="submit" value="送信">
	</form>
</body>
</html>