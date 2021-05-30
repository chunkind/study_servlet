package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("filter is over.");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 사전 작업 ~ 아래의 chain을 반드시 해주어야 한다.
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// chain 연결, 필터 다음의 서블릿 페이지가 수행.
		chain.doFilter(request, response);
		
		// 사후작업
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter is on.");
	}
}
