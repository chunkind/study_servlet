package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import cartbiz.CartBiz;

public class ItemCartListController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int totalPrice = 0;
		
		//System.out.println("ItemCartListController : " + request.getSession().getAttribute("cartList"));
		HttpSession session = request.getSession();
		
		
		ArrayList<Cart> rList = CartBiz.getCartList(request);
		System.out.println(rList);
		
		for(Cart c: rList) {
			totalPrice += c.getPrice()*c.getAmount();
		}
		System.out.println("totalPrice"+totalPrice);
		session.setAttribute("totalPrice", totalPrice);
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemCartList.jsp");
		
		
		//ArrayList<Cart> rCartList = CartBiz.getCartList(request);
		return mv;
	}

}
