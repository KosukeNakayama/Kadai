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

@WebServlet(urlPatterns={"/chap14/mondai30/input"})
public class Mondai30input extends HttpServlet {

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
					"SELECT MAX(STUDENT_ID) as max FROM STUDENT");
			ResultSet rs=st.executeQuery();
			rs.next();
			int max = rs.getInt("max");

			st=con.prepareStatement("SELECT * FROM COURSE");
			rs=st.executeQuery();

			out.println("<p>追加する学生の情報を入力してください。</p>");
			out.println("<form action=\"insert\" method=\"get\">");
			out.println("学生番号：<input type=\"number\" name=\"id\" value=\""+(max+1)+"\" readonly><br>");
			out.println("学生名　：<input type=\"text\" name=\"name\"><br>");
			out.println("コース名：<select name=\"courseId\">");

			while (rs.next()) {
				out.print("<option value=\"");
				out.println(rs.getInt("course_id")+"\">");
				out.println(rs.getString("course_name"));
				out.println("</option>");
			}
			out.println("</select><br>");
			out.println("<input type=\"submit\" value=\"送信\">");
			out.println("</form>");

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
