package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemListController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		///// 오늘 본 상품정보를 가지고 오는 로직을 작성 /////
		/*
		 * 1. 클라이언트에 저장된 모든 쿠키를 다 받아서. getCookies()
		 * 2. 그 중에서 내가 보낸 쿠키를 찾는다..
		 * 	  image111/image222/image333.. 와 일치하는 이름의 쿠키를 찾아서
		 * 3. 바인딩
		 */
		ArrayList<String> images = new ArrayList<String>();
		Cookie[ ] cookies = request.getCookies();
		if(cookies != null){
			for(int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().startsWith("image")) {
					images.add(cookies[i].getValue());
				}// if
			}// for
		}// if
		
		request.setAttribute("images", images);
		ArrayList<Item> list=ItemDao.getInstance().getAllItems();
		request.setAttribute("list", list);
		ModelAndView mv=  new ModelAndView();
	
		mv.setUrl("itemList.jsp");
		
		return mv;
	}
}









