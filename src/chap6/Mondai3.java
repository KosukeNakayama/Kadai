package chap6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap6/mondai3")
public class Mondai3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String transport[] = request.getParameterValues("transport");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String str = "";
		for(int i=0;i<transport.length;i++){
			str += transport[i];
			if(i != transport.length-1){
				str += ",";
			}
		}
		out.printf("%sで通学ですね。",str);
	}

}
