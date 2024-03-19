package chap21;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import dao.CourseDAO;

@WebServlet(urlPatterns={"/chap21/mondai12/input"})
public class Mondai12input extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		try {
			CourseDAO dao = new CourseDAO();
			List<Course> list = dao.selectAll();

			request.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/chap21/mondai12input.jsp").forward(request, response);
	}
}
