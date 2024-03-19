package chap6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap6/mondai1")
public class Mondai1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String prefecture = request.getParameter("prefecture");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.printf("こんにちは、%sにお住まいなんですね。",prefecture);
	}

}
