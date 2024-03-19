package chap20;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import dao.CourseDAO;

@WebServlet(urlPatterns={"/chap20/mondai14/insert"})
public class Mondai14insert extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		String name = request.getParameter("courseName");

		try {
			CourseDAO dao = new CourseDAO();
			Course cou = dao.insert(name);

			if(cou != null){
				request.setAttribute("course", cou);
				request.setAttribute("message", "登録完了しました。");
			}else{
				request.setAttribute("message", "登録に失敗しました。再度、お手続きをお願いいたします。");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}



		request.getRequestDispatcher("/chap20/mondai14insert.jsp").forward(request, response);
	}
}
