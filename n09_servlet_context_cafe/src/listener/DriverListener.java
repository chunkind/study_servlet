package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DriverListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("꼴까닥...");	
	}

	@Override
	public void contextInitialized(ServletContextEvent sec) {
		//dd를 읽어서 드라이버 로딩 하는 로직을 작성..
		System.out.println("contextInitialized()....call....");	
		String ODriver = sec.getServletContext().getInitParameter("ODriver");
		try{
			Class.forName(ODriver);
			System.out.println("드라이버 로딩 성공....");
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패함...");
		}
	}
}












