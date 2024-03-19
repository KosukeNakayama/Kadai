package chap20;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentExp;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/chap20/mondai15/input"})
public class Mondai15input extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		try {
			StudentDAO dao = new StudentDAO();
			List<StudentExp> list = dao.selectAllWithCourseName();

			request.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/chap20/mondai15input.jsp").forward(request, response);
	}
}
