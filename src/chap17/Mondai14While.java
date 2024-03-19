package chap17;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/chap17/mondai14/while"})
public class Mondai14While extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			StudentDAO dao = new StudentDAO();
			Student stu = dao.selectById(id);

			HttpSession session = request.getSession();
			session.setAttribute("stu", stu);

			request.getRequestDispatcher("/chap17/mondai14while.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}


	}
}
