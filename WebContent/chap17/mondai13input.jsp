<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Student, java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap17/mondai13</title>
</head>
<body>
	<p>商品の値段と個数を入力してください。</p>
	<form action ="/kadai/chap17/mondai13/while">
		<label>値段：<input type="number" min="0" name="price" required></label><br>
		<label>個数：<input type="number" min="0" name="quantity" required></label><br>
		<input type="submit" value="送信">
	</form>
</body>
</html>