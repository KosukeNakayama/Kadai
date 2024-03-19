<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Course, java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap21/mondai13</title>
</head>
<body>
	<p>内容を更新して、送信ボタンをクリックしてください。</p>
	<form action="/kadai/chap21/mondai13/result" method="get">
	<table border="1">
		<tr>
			<th>コース番号</th>
			<td><input type="text" name="id" value="${course.courseId}" readonly></td>
		</tr>
		<tr>
			<th>コース名</th>
			<td><input type="text" name="name" value="${course.courseName}"></td>
		</tr>
	</table>
	<input type="submit" value="送信">
	</form>
</body>
</html>