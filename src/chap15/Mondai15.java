package chap15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentExp;
import dao.StudentDAO;
import tool.Page;

@WebServlet(urlPatterns={"/chap15/mondai15"})
public class Mondai15 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			StudentDAO dao = new StudentDAO();
			List<StudentExp> list = dao.selectAllWithCourseName();

			out.println("<table border=\"1\"><thead><th>学生番号</th><th>学生名</th><th>コース名</th></thead>");
			out.println("<tbody>");
			for(StudentExp stu:list){
				out.println("<tr>");
				out.println("<td>"+stu.getStudentId()+"</td>");
				out.println("<td>"+stu.getStudentName()+"</td>");
				out.println("<td>"+stu.getCourseName()+"</td>");
				out.println("</tr>");
			}
			out.println("</tbody></table>");

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
