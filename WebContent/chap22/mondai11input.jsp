<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap22/mondai11</title>
</head>
<body>
	<p>学生を選択してください。</p>
	<form action ="/kadai/chap22/mondai11/disp">
		<select name="id">
		<c:forEach var="stu" items="${list}">
			<option value="${stu.studentId}">${stu.studentName}</option>
		</c:forEach>
		</select>
		<input type="submit" value="送信">
	</form>
</body>
</html>