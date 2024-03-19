package chap9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap9/mondai14")
public class Mondai14 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("お名前："+request.getParameter("name"));
		System.out.println("ご年齢："+request.getParameter("age"));
		System.out.println("　性別："+request.getParameter("gender"));
		request.getRequestDispatcher("mondai14.jsp").forward(request, response);

	}

}
