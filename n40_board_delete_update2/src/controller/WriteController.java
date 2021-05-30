package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;
/*
 * 1. 폼에 입력된 값 받아서...title, writer, content, password
 * 2. pvo 생성
 * 3. biz logic 호출
 * 4. 네비게이션
 */
public class WriteController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardVO pvo = new BoardVO(title, writer, password, content);
		
		BoardDao.getInstance().posting(pvo);
		
		String path = "DispatcherServlet?command=showContent&&no="+pvo.getNo();
		return new ModelAndView(path, true);
	}

}

/*
 * ShowContentController :: 
 * no 값을 받아와서
 * BoardVO vo=getPostingByNo(no) 호출 
 * 바인딩....포워딩..
 * 네비게이션...show_content.jsp(내가 쓴글 내가 보기)
 */
















