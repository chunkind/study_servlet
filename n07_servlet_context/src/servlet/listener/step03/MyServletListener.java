package servlet.listener.step03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletListener implements ServletContextListener{
	private ServletContext servletContext;
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("1.listener contextInitialized call... ");
		/*
		 * 1. ServletContext를 받아온다.
		 * 2. getInitParameter()로 DD에 등록된 값을 가져온다. path
		 * 3. 파일에 저장된 내용을 읽어서.
		 *    이 때, getResourceAsStream(), BufferedReader을 사용하세요.
		 * 4. 콘솔로 출력한다.
		 */
		servletContext = servletContextEvent.getServletContext();
		String userFile = servletContext.getInitParameter("userFile");
		System.out.println("userFile :: " + userFile);
		
		InputStream is = null;
		BufferedReader br = null;
		
		try {
			is = servletContext.getResourceAsStream(userFile);
			System.out.println("getResourceAsStream() is called.");
			br = new BufferedReader(new InputStreamReader(is));
			System.out.println("BufferedReader is created.");
			String line = null;
			System.out.println("starting to read the file.");
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("파일 내용을 읽어오지 못했습니다.");
		}
	}
	
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("5.listener contextDestroyed call...");
	}
	
}