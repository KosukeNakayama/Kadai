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

@WebServlet(urlPatterns={"/chap14/mondai24"})
public class Mondai24 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");

		//レスポンスの出力
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			//DBへの接続
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/kadai");
			Connection con=ds.getConnection();

			//SQL文の実行
			PreparedStatement st=con.prepareStatement(
			"SELECT * FROM STUDENT WHERE STUDENT_NAME LIKE ?");
			st.setString(1, "%"+name+"%");
			ResultSet rs=st.executeQuery();

			//DBの中身を表で表示
			out.println("<table border=\"1\"><thead><th>学生番号</th><th>学生名</th><th>コース番号</th></thead>");
			out.println("<tbody>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getInt("student_id")+"</td>");
				out.println("<td>"+rs.getString("student_name")+"</td>");
				out.println("<td>"+rs.getInt("course_id")+"</td>");
				out.println("</tr>");
			}
			out.println("</tbody></table>");

			//DBの接続を切断
			st.close();
			con.close();
		} catch (Exception e) {
			//エラー処理
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
