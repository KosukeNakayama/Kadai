package chap10;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class Mondai9 implements Filter {

	public void destroy() {
		//NOTHING
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("サーブレットの前の処理");
		chain.doFilter(request, response);
		System.out.println("サーブレットの後の処理");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//NOTHING
	}

}
