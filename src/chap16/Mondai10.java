package chap16;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import dao.CourseDAO;

@WebServlet(urlPatterns={"/chap16/mondai10"})
public class Mondai10 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		try {
			CourseDAO dao = new CourseDAO();
			List<Course> list = dao.selectAll();

			request.setAttribute("list", list);

			request.getRequestDispatcher("mondai10.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
