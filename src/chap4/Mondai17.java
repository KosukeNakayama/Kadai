package chap4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/chap4/mondai17")
public class Mondai17 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Date date = new java.util.Date();
		String[] daysOfWeek = {"日","月","火","水","木","金","土"};

		out.println("問題１５はこれにてクリア！お疲れ様でした。<br>");
		out.printf("%s年%s月%s日(%s) %s:%s:%s",date.getYear()+1900,date.getMonth()+1,date.getDate(),daysOfWeek[date.getDay()],date.getHours(),date.getMinutes(),date.getSeconds());
	}

}
