package chap6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap6/mondai5")
public class Mondai5 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String prefecture = request.getParameter("prefecture");
		String transport[] = request.getParameterValues("transport");
		String anxiety = request.getParameter("anxiety");
		String str = "";
		for(int i=0;i<transport.length;i++){
			str += transport[i];
			if(i != transport.length-1){
				str += ",";
			}
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("ご入力頂いた内容の確認です。よろしければ、下の登録ボタンを押してください。<br><br>");
		out.printf("<dl><dt>お名前：</dt><dd>%s</dd>",name);
		out.printf("<dt>ご年齢：</dt><dd>%d</dd>",age);
		out.printf("<dt>お住まい：</dt><dd>%s</dd>",prefecture);
		out.printf("<dt>利用交通機関：</dt><dd>%s</dd>",str);
		out.printf("<dt>お問い合わせ内容：</dt><dd>%s</dd>",anxiety);
		out.print("</dl>");
		out.print("<form><button>登録</button></form>");

	}

}
