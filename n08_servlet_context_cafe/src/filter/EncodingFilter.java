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
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("2.filter init call...");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("5.doFilter call... 얘는 요청이 있을때마다 호출됨..");
		
		//사전작업
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//chain연결.. 필터 다음의 서블릿 페이지가 수행..중요
		chain.doFilter(request, response);
		
		//사후작업

	}

	@Override
	public void destroy() {
		System.out.println("12.filter destroy call...");
	}
	
}
