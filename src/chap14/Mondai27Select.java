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

@WebServlet(urlPatterns={"/chap14/mondai27/input"})
public class Mondai27Select extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/kadai");
			Connection con=ds.getConnection();

			PreparedStatement st=con.prepareStatement(
				"SELECT * FROM STUDENT WHERE STUDENT_ID = ?");
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();

			out.println("<form method=\"get\" action=\"update\">");
			while (rs.next()) {
				out.println("お名前　　：");
				out.println("<input type=\"hidden\" name=\"id\" value=\""+rs.getInt("student_id")+"\">");
				out.println("<input type=\"text\" name=\"name\" value=\""+rs.getString("student_name")+"\"><br>");
				out.println("コース番号：");
				out.println("<select name=\"courseId\">");
				if(rs.getInt("course_id") == 1){
					out.println("<option selected>1</option>");
					out.println("<option>2</option>");
				}else{
					out.println("<option>1</option>");
					out.println("<option selected>2</option>");
				}
				out.println("</select><br>");
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
