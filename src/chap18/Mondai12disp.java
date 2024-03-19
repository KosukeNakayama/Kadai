package chap18;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chap18/mondai12/disp"})
public class Mondai12disp extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		String name = request.getParameter("name");
		Cookie[] cookies=request.getCookies();

		Integer count=null;
		String lastDate = null;
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("count")) {
					count=Integer.parseInt(cookie.getValue());
				}
				if (cookie.getName().equals("lastDate")) {
					lastDate=cookie.getValue();
				}
				if (cookie.getName().equals("name")) {
					if(name == null){
						name=URLDecoder.decode(cookie.getValue(),"utf-8");
					}
				}
			}
		}

		if (count==null){
			count=0;
		}
		count++;
		Date date = new Date();
		if(name==null){
			name = "名無しの権兵衛";
		}

		Cookie cookieCount=new Cookie("count", count.toString());
		cookieCount.setMaxAge(60*60*24*30);
		name = URLEncoder.encode(name,"utf-8");
		Cookie cookieName = new Cookie("name", name);
		cookieName.setMaxAge(60*60*24*30);
		Cookie cookieDate=new Cookie("lastDate", date.toString());
		cookieDate.setMaxAge(60*60*24*30);
		response.addCookie(cookieCount);
		response.addCookie(cookieName);
		response.addCookie(cookieDate);
		request.setAttribute("count", count);
		request.setAttribute("lastDate", lastDate);
		request.setAttribute("name", URLDecoder.decode(name,"utf-8"));

		request.getRequestDispatcher("/chap18/mondai12disp.jsp").forward(request, response);
	}
}
