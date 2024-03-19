package chap5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/chap5/mondai7")
public class Mondai7 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.printf("こんにちは、%sさん<br>",name);
		out.printf("10年後は%d歳ですね！",age+10);
	}

}
