package chap17;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/chap17/mondai13/result"})
public class Mondai13Result extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int price = (Integer)session.getAttribute("price");
		int quantity = (Integer)session.getAttribute("quantity");

		int total = price * quantity;

		request.setAttribute("total", total);

		request.getRequestDispatcher("/chap17/mondai13result.jsp").forward(request, response);

	}
}
