<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.Student, java.util.List" %>
<%String message=(String)request.getAttribute("message");%>
<%Student stu=(Student)request.getAttribute("student");%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chap16/mondai11</title>
</head>
<body>
<p><%= stu.getStudentName() %>さんの${ line > 0 ? "登録に成功しました":"登録に失敗しました" }</p>
</body>
</html>