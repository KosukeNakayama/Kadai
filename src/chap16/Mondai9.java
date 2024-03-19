package chap16;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/chap16/mondai9"})
public class Mondai9 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		try {
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.selectAll();

			request.setAttribute("list", list);

			request.getRequestDispatcher("mondai9.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
