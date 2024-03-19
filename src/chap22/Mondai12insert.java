package chap22;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/chap22/mondai12/insert"})
public class Mondai12insert extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		List<Student> list = new ArrayList<>();

		for(int i=1;i<=5;i++){
			String name = request.getParameter("name"+i);
			if(!name.isEmpty()){
				Student stu = new Student();
				stu.setStudentName(name);
				stu.setCourseId(Integer.parseInt(request.getParameter("courseId"+i)));
				list.add(stu);
			}
		}

		if(list.size() != 0){
			try {
				StudentDAO dao = new StudentDAO();
				int line = dao.insertStudents(list);

				request.setAttribute("line", line);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher("/chap22/mondai12insert.jsp").forward(request, response);
	}
}
