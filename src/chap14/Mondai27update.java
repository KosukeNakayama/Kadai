package chap14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chap14/mondai27/update"})
public class Mondai27update extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int courseId=Integer.parseInt(request.getParameter("courseId"));

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/kadai");
			Connection con=ds.getConnection();

			PreparedStatement st=con.prepareStatement(
				"UPDATE STUDENT SET STUDENT_NAME = ?,COURSE_ID = ? WHERE STUDENT_ID = ?");
			st.setString(1, name);
			st.setInt(2, courseId);
			st.setInt(3, id);
			int line=st.executeUpdate();

			if (line>0) {
				out.println("更新に成功しました。");
			}

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
