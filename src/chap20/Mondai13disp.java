package chap20;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentExp;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/chap20/mondai13/disp"})
public class Mondai13disp extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			StudentDAO dao = new StudentDAO();
			StudentExp stu = dao.selectById(id);

			request.setAttribute("student", stu);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/chap20/mondai13disp.jsp").forward(request, response);
	}
}
