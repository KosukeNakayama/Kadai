<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap22/mondai12</title>
</head>
<body>
	<p>${line != null && line > 0 ? line += "人分の登録に成功しました。" : "登録出来ませんでした。" }<br>
	追加の登録は<a href="/kadai/chap22/mondai12/input">こちらのリンクから入力ページへどうぞ</a></p>
</body>
</html>