서블릿 필터란?
리스너와 함께 대표적인 특별한형태의 서블릿.
사용자 요청에 따라 특정 서블릿이나 JSP가 실행 되기전 사전 작업 수행
여러개의 서블릿을 다양한 조건으로 설정해 하나의 요청에 여러 필터가 사전에 수행 될 수 있도록 할 수 있음.


사용법
1.DD에 설정한다.
<filter>
	<filter-name>EncodingFilter</filter-name>
	<filter-class>filter.EncodingFilter</filter-class>
	<init-param>
		<param-name>key</param-name>
		<param-value>value</param-value>
	</init-param>
</filter>
<filter-mapping>
	<filter-name>EncodingFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>

2.<filter-class> 에 설정한 클래스를 javax.servlet.Filter 인터페이스로 구현한다.

3.doFilter()메서드를 오버라이드 한다.

4.init과 destroy는 옵션