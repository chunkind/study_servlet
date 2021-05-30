package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class ShowContentNoHitController implements Controller {
/*
 no, hits를 폼에서 받아온다.
 biz() 호출.....조회수 증가....1)
 no만 인자값으로...getPostingByNo(no) ::VO
 바인딩....show_content.jsp
 */
	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		int hits = Integer.parseInt(request.getParameter("hits"));
		
		BoardDao.getInstance().updateHits(no, hits);
		BoardVO vo = BoardDao.getInstance().getPostingByNo(no);
		
		request.setAttribute("bvo", vo);
		return new ModelAndView("show_content.jsp");
	}

}









