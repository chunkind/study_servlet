package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 이 부분은 여러분들이 직접 작성하세요.
		// setUrl("itemList.jsp");
		
		ArrayList<Item> list= ItemDao.getInstance().getAllItems();
		request.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemList.jsp");
		return mv;
	}
}
