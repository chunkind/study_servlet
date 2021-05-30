package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemListController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//setUrl("itemList.jsp");
		ArrayList<Item> rList = ItemDao.getInstance().getAllItems();
		request.setAttribute("rList", rList);
		
		return new ModelAndView("itemList.jsp", false);
	}
}
