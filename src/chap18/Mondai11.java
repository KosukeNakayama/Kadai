package chap18;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chap18/mondai11"})
public class Mondai11 extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();

		Integer count=null;
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("count")) {
					count=Integer.parseInt(cookie.getValue());
					break;
				}
			}
		}

		if (count==null) count=0;
		count++;

		Cookie cookie=new Cookie("count", count.toString());
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		request.setAttribute("count", count);

		request.getRequestDispatcher("mondai11.jsp").forward(request, response);
	}
}
