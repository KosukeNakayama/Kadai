package chap16;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentExp;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/chap16/mondai12"})
public class Mondai12 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		try {
			StudentDAO dao = new StudentDAO();
			List<StudentExp> list = dao.selectAllWithCourseName();

			request.setAttribute("list", list);

			request.getRequestDispatcher("mondai12.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
