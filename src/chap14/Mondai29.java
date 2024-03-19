package chap14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chap14/mondai29"})
public class Mondai29 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/kadai");
			Connection con=ds.getConnection();

			PreparedStatement st=con.prepareStatement(
			"SELECT * FROM STUDENT LEFT OUTER JOIN COURSE ON STUDENT.COURSE_ID = COURSE.COURSE_ID");
			ResultSet rs=st.executeQuery();

			out.println("<table border=\"1\"><thead><th>学生番号</th><th>学生名</th><th>コース名</th></thead>");
			out.println("<tbody>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getInt("student_id")+"</td>");
				out.println("<td>"+rs.getString("student_name")+"</td>");
				out.println("<td>"+rs.getString("course_name")+"</td>");
				out.println("</tr>");
			}
			out.println("</tbody></table>");

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
