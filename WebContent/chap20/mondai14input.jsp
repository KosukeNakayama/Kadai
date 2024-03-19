<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap20/mondai14</title>
</head>
<body>
	<p>追加するコースの名前を入力してください。</p>
	<form action="/kadai/chap20/mondai14/insert" method="get">
	<input type="text" name="courseName" required>
	<input type="submit" value="送信">
	</form>
</body>
</html>