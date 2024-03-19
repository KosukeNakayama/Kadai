<%@page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="student" class="bean.StudentExp" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap20/mondai13</title>
</head>
<body>
	<p>選択された学生の情報です。</p>
	<table border="1">
		<thead><tr><th>学生番号</th><th>学生名</th><th>コース名</th></tr></thead>
		<tbody><tr>
			<td><jsp:getProperty name="student" property="studentId" /></td>
			<td><jsp:getProperty name="student" property="studentName" /></td>
			<td><jsp:getProperty name="student" property="courseName" /></td>
		</tr></tbody>
	</table>
</body>
</html>