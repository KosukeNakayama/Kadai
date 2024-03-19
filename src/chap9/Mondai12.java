package chap9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap9/mondai12")
public class Mondai12 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("<h1>こちらのタイトルはServletで記述しています！</h1>");
		request.getRequestDispatcher("mondai12.jsp").include(request, response);
		out.printf("<p>こちらの文はServletで記述しています！</p>");

	}

}
