<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Student, java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap16/mondai11</title>
</head>
<body>
	<p>登録する学生の情報を入力してください。</p>
	<form action ="mondai11">
		<label>お名前　　：<input name="name"></label><br>
		コース番号：<select name="courseId">
			<option value="1">システム開発コース</option>
			<option value="2">AIシステム・データサイエンスコース</option>
		</select><br>
		<input type="submit" value="送信">
	</form>
</body>
</html>