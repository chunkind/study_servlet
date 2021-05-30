package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class ListController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/*
		 * 비지니스 로직 호출..
		 * 리턴받고
		 * 바인딩
		 * 네비게이터
		 */
		//view Page :: show_list.jsp
		ArrayList<BoardVO> list=BoardDao.getInstance().getPostingList();
		System.out.println("getPostingList() call....ed..");
		request.setAttribute("list", list);
		
		
		return new ModelAndView("show_list.jsp");
	}

}


















