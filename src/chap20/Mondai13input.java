package chap20;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/chap20/mondai13/input"})
public class Mondai13input extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		try {
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.selectAll();

			request.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/chap20/mondai13input.jsp").forward(request, response);
	}
}
