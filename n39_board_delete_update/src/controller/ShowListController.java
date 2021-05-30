package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class ShowListController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ArrayList<BoardVO>  rlist = BoardDao.getInstance().getPosting();
		System.out.println(rlist);
		request.setAttribute("rlist", rlist);

		return new ModelAndView("show_list.jsp");
	}
}