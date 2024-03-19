<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap21/mondai11</title>
</head>
<body>
	<p>選択された学生の情報です。</p>
	<table border="1">
		<thead><tr><th>学生番号</th><th>学生名</th><th>コース名</th></tr></thead>
		<tbody><tr>
			<td>${student.studentId}</td>
			<td>${student.studentName}</td>
			<td>${student.courseName}</td>
		</tr></tbody>
	</table>
</body>
</html>