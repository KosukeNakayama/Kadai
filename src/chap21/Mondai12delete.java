package chap21;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import dao.CourseDAO;

@WebServlet(urlPatterns={"/chap21/mondai12/delete"})
public class Mondai12delete extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			CourseDAO dao = new CourseDAO();
			Course cou = dao.delete(id);

			if(cou != null){
				request.setAttribute("course", cou);
				request.setAttribute("message", "削除完了しました。");
			}else{
				request.setAttribute("message", "削除に失敗しました。再度、お手続きをお願いいたします。");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/chap21/mondai12delete.jsp").forward(request, response);
	}
}
