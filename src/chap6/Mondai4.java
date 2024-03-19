package chap6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap6/mondai4")
public class Mondai4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String anxiety = request.getParameter("anxiety");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.printf("お問い合わせ内容は以下間違いないでしょうか。<br>");
		out.printf(anxiety);
	}

}
