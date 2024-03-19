package chap15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import dao.CourseDAO;
import tool.Page;

@WebServlet(urlPatterns={"/chap15/mondai14"})
public class Mondai14 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			CourseDAO dao = new CourseDAO();
			List<Course> list = dao.selectAll();

			out.println("<table border=\"1\"><thead><th>コース番号</th><th>コース名</th></thead>");
			out.println("<tbody>");
			for(Course cou:list){
				out.println("<tr>");
				out.println("<td>"+cou.getCourseId()+"</td>");
				out.println("<td>"+cou.getCourseName()+"</td>");
				out.println("</tr>");
			}
			out.println("</tbody></table>");

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
