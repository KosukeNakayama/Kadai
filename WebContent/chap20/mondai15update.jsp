<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.StudentExp, bean.Course, java.util.List" %>
<jsp:useBean id="student" class="bean.StudentExp" scope="request"/>
<% List<Course> courseList = (List<Course>)request.getAttribute("courseList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap20/mondai15</title>
</head>
<body>
	<p>内容を更新して、送信ボタンをクリックしてください。</p>
	<form action="/kadai/chap20/mondai15/result" method="get">
	<table border="1">
		<tr>
			<th>学生番号</th>
			<td><input type="text" name="id" value="<jsp:getProperty name="student" property="studentId" />" readonly></td>
		</tr>
		<tr>
			<th>学生名</th>
			<td><input type="text" name="name" value="<jsp:getProperty name="student" property="studentName" />"></td>
		</tr>
		<tr>
			<th>所属コース</th>
			<td>
				<select name="courseId">
					<% for(Course cou : courseList){ %>
						<option value="<%= cou.getCourseId() %>" <%if(cou.getCourseId() == student.getCourseId()){out.println("selected");}%>>
						<%= cou.getCourseName() %></option>
					<% } %>
				</select>
			</td>
		</tr>
	</table>
	<input type="submit" value="送信">
	</form>
</body>
</html>