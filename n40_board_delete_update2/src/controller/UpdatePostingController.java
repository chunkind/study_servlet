package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;
/*
 * 주석...
 * 폼의 값 받아서
 * pvo 생성
 * biz() 호출
 * 네비게이션..redirect
 */
public class UpdatePostingController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		System.out.println(vo);
		BoardDao.getInstance().updatePosting(vo);
		
		String path = "DispatcherServlet?command=showContent&&no="+vo.getNo();
		return new ModelAndView(path);		
	}
}


















