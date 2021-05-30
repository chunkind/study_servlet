package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import cartbiz.CartBiz;
/*
 * cartList.jsp를 보여주는데 필요한 로직을 작성...
 * cartList를 받아오고 / sumMoney를 구하고
 */
public class ItemCartListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CartBiz cartBiz = new CartBiz();
		ArrayList<Cart> cartList = cartBiz.getCartList(request);
		
		/*
		 * for문을 돌면서 각각의 Cart정보 / sumMoney를 뽑아야 한다.
		 */
		int sumMoney = 0;
		Cart cart=  null;
		for(int i=0; i<cartList.size(); i++){
			cart = cartList.get(i);
			sumMoney += cart.getPrice()*cart.getQuantity();
		}//for
		request.setAttribute("cartSize", cartList.size());
		request.setAttribute("sumMoney", sumMoney);
		request.setAttribute("cartList", cartList);
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemCartList.jsp"); //포워딩...
		return mv;
	}
}





















