<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap22/mondai12</title>
</head>
<body>
	<p>新規に登録する学生の情報を入力してください。</p>
	<form action ="/kadai/chap22/mondai12/insert">
		<table border="1">
		<tr><th>学生名</th><th>所属コース</th></tr>
		<c:forEach var="i" begin="1" end="5">
		<tr>
			<td><input type="text" name="${"name" += i }"></td>
			<td>
				<select name="${"courseId" += i }">
				<c:forEach var="cou" items="${courseList }">
					<option value="${cou.courseId }">${cou.courseName}</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		</c:forEach>
		</table>
		<input type="submit" value="送信">
	</form>
</body>
</html>