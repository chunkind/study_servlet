package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class UpdateViewController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * 수정하고자 하는 글의 no를 받아와서
		 * no에 해당하는 BoardVO를 하나 리턴받아야 한다.
		 * bvo를 바인딩
		 * update.jsp로 페이지 연결...
		 */
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO vo=BoardDao.getInstance().getPostingByNo(no);
		
		request.setAttribute("bvo", vo);
		 
		return new ModelAndView("update.jsp");
	}
}


















