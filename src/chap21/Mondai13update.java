package chap21;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import dao.CourseDAO;

@WebServlet(urlPatterns={"/chap21/mondai13/result"})
public class Mondai13update extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Course cou = new Course();
		cou.setCourseId(id);
		cou.setCourseName(name);

		try {
			CourseDAO dao = new CourseDAO();
			int line = dao.update(cou);

			if(line > 0){
				request.setAttribute("message", "更新が完了しました。");
			}else{
				request.setAttribute("message", "更新出来ませんでした。\n再度お試しください。");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/chap20/mondai15result.jsp").forward(request, response);
	}
}
