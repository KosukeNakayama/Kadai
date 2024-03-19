package chap17;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/chap17/mondai13/while"})
public class Mondai13While extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		HttpSession session = request.getSession();
		session.setAttribute("price", price);
		session.setAttribute("quantity", quantity);

		request.getRequestDispatcher("/chap17/mondai13while.jsp").forward(request, response);

	}
}
