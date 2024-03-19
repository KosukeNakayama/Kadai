package chap16;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/chap16/mondai11"})
public class Mondai11 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Student stu = new Student();
		stu.setStudentName(request.getParameter("name"));
		stu.setCourseId(Integer.parseInt(request.getParameter("courseId")));

		try {
			StudentDAO dao = new StudentDAO();
			int line = dao.insertStudent(stu);

//			String message = "登録に失敗しました。";
//			if(line > 0){
//				message = "登録に成功しました。";
//			}
			request.setAttribute("line", line);
			request.setAttribute("student", stu);
			request.getRequestDispatcher("mondai11.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
