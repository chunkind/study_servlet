package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemViewController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String path = "index.jsp";
		String itemNumber = request.getParameter("itemId");
		Item rItem = ItemDao.getInstance().getItem(Integer.parseInt(itemNumber));
		
		if(rItem != null){
			ItemDao.getInstance().UpdateRecordCount(Integer.parseInt(itemNumber));
			request.getSession().setAttribute("rItem", rItem);
	
			path = "itemView.jsp";
		}
		
		return new ModelAndView(path, false);
	}
}
