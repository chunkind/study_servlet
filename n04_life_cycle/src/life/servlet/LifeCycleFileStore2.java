package life.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleFileStore2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private int count = 0; 
//    private String path = "c:\\filestore\\life\\count\\count.txt";
    private String path = "";
    
    public LifeCycleFileStore2() {
    	System.out.println("1. Servlet Instance Creating..");
    }

	public void init() throws ServletException {
		System.out.println("2. init() Calling.. 파일에 저장된 값을 Load함..");
		/*
		 * 서버가 다시 시작될때 이 부분이 로드됨..
		 * 파일에 저장된 값을 찾아서, 읽어서 그 값을 콘솔창으로 출력..
		 * 웹으로는 왜 출력이 안될까요?
		 */
		
		//path 설정
		path = getServletContext().getRealPath("/WebContent/count/count.txt");
		File file = new File(path);
		File dir = new File(file.getParent());
		if(!dir.exists()){
			dir.mkdirs();
		}
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(path);
		
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			count = Integer.parseInt(line);
			System.out.println("init에서 읽어들인 count 값 :: " + count);
			
		}catch(NumberFormatException e){
			count = 0;
		}catch(NullPointerException e){
			count = 0;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. goGet() Calling.." + count);
		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='orange'>");
		out.println("<h2>Count :: </h2>" + ++count);
		out.println("</body><html>");
		
		out.close();
	}

	public void destroy() {
		System.out.println("4. destroy() Calling.. count값을 파일에 저장함.");
		/*
		 * 파일을 하나 생성하고 / 이곳에 count 값을 출력시킴.
		 * 이때 getParentFile(), mkdirs()를 사용한다.
		 * 생성된 파일 count.txt에 count값을 뿌린다.
		 */
		File f = new File(path);
		f.getParentFile().mkdirs();	// 파일을 제외한 디렉토리가 만들어진다.
		System.out.println("File is created..");
		try{
			PrintWriter pw = new PrintWriter(new FileWriter(f), true);
			pw.println(count);
			pw.close();
			System.out.println(path + " count 값 :: " + count + " :: 영구적으로 파일 저장");
		}catch(IOException e ){
			e.printStackTrace();
		}
	}

}
