package chap17;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StudentExp;

@WebServlet(urlPatterns={"/chap17/mondai15/remove"})
public class Mondai15Remove extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String[] ids = request.getParameterValues("studentIds");
		List<StudentExp> list = (List<StudentExp>)session.getAttribute("commendationList");

		if(ids == null){
			request.setAttribute("message", "一人以上を選択してください");
		}else{
			for(String idStr:ids){
				int id = Integer.parseInt(idStr);
				for(int i = 0;i < list.size();i++){
					if(id == list.get(i).getStudentId()){
						list.remove(i);
						i--;
					}
				}
			}
			session.setAttribute("commendationList", list);
			request.setAttribute("message", "リストから削除しました。");
		}
		request.getRequestDispatcher("/chap17/mondai15list.jsp").forward(request, response);
	}
}
