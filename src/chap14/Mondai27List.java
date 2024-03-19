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

@WebServlet(urlPatterns={"/chap14/mondai27"})
public class Mondai27List extends HttpServlet {
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
			"SELECT * FROM STUDENT");
			ResultSet rs=st.executeQuery();


			out.println("<p>データを更新する学生を選んでください</p>");
			out.println("<form method=\"get\" action=\"mondai27/input\">");
			out.println("<select name=\"id\">");
			while (rs.next()) {
				out.print("<option value=\"");
				out.println(rs.getInt("student_id")+"\">");
				out.println(rs.getString("student_name"));
				out.println("</option>");
			}
			out.println("<input type=\"submit\" value=\"送信\">");

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
