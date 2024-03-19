package chap15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Page;

@WebServlet(urlPatterns={"/chap15/mondai13"})
public class Mondai13 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.selectAll();

			out.println("<table border=\"1\"><thead><th>学生番号</th><th>学生名</th><th>コース番号</th></thead>");
			out.println("<tbody>");
			for(Student stu:list){
				out.println("<tr>");
				out.println("<td>"+stu.getStudentId()+"</td>");
				out.println("<td>"+stu.getStudentName()+"</td>");
				out.println("<td>"+stu.getCourseId()+"</td>");
				out.println("</tr>");
			}
			out.println("</tbody></table>");

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
