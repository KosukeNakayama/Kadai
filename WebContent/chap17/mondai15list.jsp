<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.StudentExp, java.util.List" %>
<% List<StudentExp> commendationList = (List<StudentExp>)session.getAttribute("commendationList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap17/mondai15</title>
</head>
<body>
	<small>システムメッセージ：<%= request.getAttribute("message") %></small><br>
	<h3>表彰する学生一覧</h3>
	<p>リストから削除する場合はチェックを入れて削除ボタンを押してください。<br>
	追加する場合は次のリンクから追加ページへ
	<a href="/kadai/chap17/mondai15/input">追加画面</a></p><br>
	<form action ="/kadai/chap17/mondai15/remove">
	<table border="1">
	<thead><tr><th></th><th>学生番号</th><th>学生名</th><th>コース名</th></tr></thead>
	<tbody>
	<% for(StudentExp stu:commendationList){ %>
		<tr>
			<td><input type="checkbox" name="studentIds" value="<%= stu.getStudentId()%>"></td>
			<td><%= stu.getStudentId() %></td>
			<td><%= stu.getStudentName() %></td>
			<td><%= stu.getCourseName() %></td>
		</tr>
	<% } %>
	</tbody>
	</table>
	<input type="submit" value="削除">
	</form>
</body>
</html>