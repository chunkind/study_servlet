 servletContext - 하나의 Context 내에서 다른 Servlet간 공유가 가능한 global한 자원
 
 1.Read only
 	1)DD에서 설정한다.
 	<context-param>
 		<param-name>key</param-name>
 		<param-value>value</param-value>
 	</context-param>
 	*태그의 범위가 <servlet></servlet>밖이라는걸 명심해야함!!!
 
 	2)java에서 사용한다.
 	ServletContext context = getServletContext();
 	String value = context.getInitParameter("key");
 
 	3)jsp에서 익스프레션으로 사용.
 	<%= config.getServletContext().getInitParameter("key") %>
 	<%= application.getInitParameter("key") %>
 	<%= pageContext.getServletContext().getInitParameter("key") %>
 
 	4)jsp에서 el로 사용한다.
 	${initParam.key }
 
 2.Read Write
 	1)java에서 설정한다.
 	ServletContext context = getServletContext();
 	String value = context.setAttribute("key", "value");
 
 	2)java에서 사용한다.
 	ServletContext context = getServletContext();
 	String value = context.getAttribute("key");
 
 	3)jsp에서 익스프레션으로 사용.
	<%= config.getServletContext().getAttribute("key") %>
	<%= pageContext.getServletContext().getAttribute("key") %>
	<%= application.getAttribute("key") %>
 
 	4)jsp에서 el로 사용한다.
 	${applicationScope.projectName}
 
  *scope에 관하여
  pageScope < requestScope < sessionScope < applicationScope

  
  3.ServletConfig와 ServletContext의 차이
  ServletConfig는 한서블릿에서 설정하는 초기화 자원이지만 ServletContext 는 모든 서블릿이 global하게 접근 가능한 자원임을 명심하자!!
  
  
  
  
  
  
  
  
  
  
  
  
Listener

	웹 어플리케이션은 이벤트를 통해 서블릿 컨텍스트(환경)의 상태나 HTTP 세션 객체의 상태 변화를
	통지해 준다. 이 상태변화에 응답하는 서블릿 클래스가 리스너 클래스이다. 리스너를 사용하기 위
	해서는 다음과 같은 과정이 필요한다.
	
	1) 구현항 기능과 관련된 이벤트 리스너 인터페이스를 구현하는 서블릿 클래스 생성(생성시 인자
	없는 생성자를 반드시 구현해야함)
	2) web.xml(배포 서술자)에 리스너 엘레멘트를 사용하여 구현한 리스너 클래스를 등록
	
	ex) 웹 서버가 시작될 때 동작하는 리스너
	
	1.해당 이벤트가 발생했을 경우 수행할 리스너 클래스 작성.
	
	import javax.servlet.ServletContextEvent;
	import javax.servlet.ServletContextListener;
	
	public class TestListener implements ServletContextListener{
		
		public TestListener(){}
		
		public void contextinitialized(ServletContextEvent contextEvent){
			System.out.println("웹 컨테이너가 시작되네요!!");
		}
		
		public void contextDestoryed(ServletContextEvent contextEvent){
			System.out.println("웹 컨테이너가 종료되네요!!");		
		}
		
	}
	
	2.web.xml에 리스너 등록
	<listener>
		<listener-class>리스너 클래스 경로</listener-class>
	</listener>
	
	3.listener 종류
	
	1) ServletContextListener
	웹 어플리케이션의 시작과 종료시 자동으로 발생되는 이벤트를 수행하기 위한 메소드를 정의한
	인터페이스
	
		구현해야 할 메소드
		
		contextInitialized(ServletContextEvent sce) : void
		웹 컨테이너가 처음 구동될 때 실행되는 메소드
		
		contextDestoryed(ServletContextEvent sce) : void
		웹 컨테이너가 종료될 때 실행되는 메소드
		
		
		
	2) ServletContextAttributeListener
	컨테이너에 저장된 속성 값들의 변화가 있을 때 수행하기 위한 메소드를 정의한 인터페이스
	
		구현해야 할 메소드
		
		attributeAdded(ServletContextAttributeEvetn scae) : void
		새로운 속성 값이 추가될 때 실행되는 메소드
		
		attributeRemoved(ServletContextAttributeEvetn scae) : void
		속성 값이 제거될 때 실행되는 메소드
		
		
	
	3) HttpSessionListener
	HTTP 세션이 활성화 되거나 비활성화 되려할 때 혹은 속성 값들이 추가, 삭제, 변경될 경우
	수행하기 위한 인터페이스
	
		구현해야 할 메소드
		
		sessionCreated(HttpSession se) : void
		세션이 생성되었을 경우 이 메소드가 실행
		
		sessionDestoryed(HttpSession se) :void
		세션이 무효화 되었을 경우 이 메소드 실행
		
		
	
	4) HttpSessionAttributeListener
	HTTP 세션에 대한 속성 값이 변경되었을 경우 수행하기 위한 인터페이스
	
		구현해야 할 메소드
		
		attributeAdded(HttpSessionBindingEvent e) : void
		세션에 새로운 속성 값이 추가될 때 실행
		
		attributeRemoved(HttpSessionBindingEvent e) : void
		세션의 속성 값이 제거될 때 실행
		
		attributeReplaced(HttpSessionBindingEvent e) : void
		세션의 속성 값이 변경될 때 실행
		
		
		
	5) HttpSessionActivationListener
	세션에 대한 내용이 새로 생성되어 세션이 활성화 되었을 때 발생하는 이벤트를 수행하기 위한
	인터페이스
	
		구현해야 할 메소드
		
		sessionDidActivate(HttpSessionEvent e) : void
		세션이 활성화 될 때 실행
		
		sessionWillPassivate(HttpSessionEvent e) : void
		세션이 비활성화 되려고 할 때 실행
		
		
		
	6) HttpSessionBindingListener
	클라이언트의 세션 정보에 대한 바인딩이 이루어졌을 경우 감지되는 이벤트를 수행하기 위한 
	인터페이스
	
		구현해야 할 메소드
		
		valueBound(HttpSessionBindingEvent e) : void
		세션에 연결될 때 발생하는 이벤트를 실행
		
		valueUnBound(HttpSessionBindingEvent e) : void
		세션으로부터 연결이 해제될 때 발생하는 이벤트를 실행
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	