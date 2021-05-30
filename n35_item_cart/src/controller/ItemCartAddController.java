package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;
import model.Item;
import model.ItemDao;
/*
 * 장바구니에 itemId에 해당하는 상품을 추가하는 로직을 담고 있는 클래스
 * 데이타베이스가 아니라 장바구니에 (세션에) 상품을 저장, 가져와야 한다.
 * 그래서 장바구니에 관련된 비지니스 로직을 따로 작성해야 한다.
 * Cart(vo) / CartBiz (dao)를 먼저 작성해야 한다. 
 * 
 * 1. 장바구니에 추가하고자 하는 Item을 하나 받아온다.
 * 2. 해당 Item을 장바구니에 담는다...CartBiz의 addCart()가 호출된다.
 * 3. itemCartList.do로 이동.....ItemCartListController가 생성...
 *                              itemCartList.jsp로 이동...
 *                              redirect방식으로 이동한다.
 *  
 */
public class ItemCartAddController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int itemid = Integer.parseInt(request.getParameter("itemid"));
		
		Item item=ItemDao.getInstance().getItem(itemid);
		
		//CartBiz의 addCart()를 호출할 준비가 되었다.
		CartBiz cartBiz = new CartBiz();
		cartBiz.addCart(request, item);
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemCartList.do");
		mv.setRedirect(true);
		
		return mv;
	}
}










