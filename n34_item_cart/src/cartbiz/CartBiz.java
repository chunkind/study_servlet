package cartbiz;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Item;

/*
 * 장바구니의 비지니스 로직 ::
 *  1. item 이 장바구니에 추가되는 로직 addCart() / 
 *  2. 장바구니에 담겨진 모든 상품들을 다 가지고 오는 로직 getCartList()
 * --------------------------------------------------------------------
 *  1.
 *   1) 이미 담겨져 있는 상품을 추가할때와 / 장바구니에 없는 상품을 추가할때
 *      이것부터 알아야 한다. 
 *      세션에서 가지고 와서 살펴봐야 한다...
 *      세션에 상품들을 어떤 이름으로 바인딩 했었는지 미리 알고 있어야 한다.
 *      cartList로 바인딩 했다고 치고..... 로직을 작성하자.
 *    
 */
public class CartBiz {
	public void addCart(HttpServletRequest request, Item item){
		HttpSession session=  request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList==null) cartList   = new ArrayList<Cart>();
		boolean newCart = true;// cart가 비었다면..
		Cart cart = null;
		
		//1) 지금 선택한 상품이 Cart 에 담겨져 있는 상품이라면 수량만 증가시키고
		for(int i=0; i<cartList.size(); i++){
			cart=cartList.get(i); //알아두자..
			if(item.getName().equals(cart.getName())){
				newCart = false;
				cart.setQuantity(cart.getQuantity()+1);
			}//if
		}//for
				
		//2)Cart에 담겨져 있지 않는 상품이라면 Cart에 하나씩 직접 담아준다.
		//Cart 를 직접 생성해야 각각의 값을 세팅해야 한다.
		if(newCart){
			cart = new Cart();
			cart.setImage(item.getUrl());
			cart.setName(item.getName());
			cart.setPrice(item.getPrice());
			cart.setQuantity(1);//무조건 1이 된다.
			cartList.add(cart); //이 부분 빠지면 안됨...
		}//if
		//session 에 바인딩....이거 빠지면 장바구니 로직 아무런 의미가 없다.
		session.setAttribute("cartList", cartList);
		
	}//addCart()
	
	public ArrayList<Cart> getCartList(HttpServletRequest request){
		HttpSession session=request.getSession();
		ArrayList<Cart> cartList=(ArrayList<Cart>)session.getAttribute("cartList");
		
		return cartList;
	}
	
	public void upCartQty(HttpServletRequest request,String name){
		/*
		 * 세션에 바인딩 되어 있는 cartList를 받아와서
		 * name에 해당되는 상품을 찾아서 수량을 1만 증가..
		 */
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList=(ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<cartList.size(); i++){
			if(cartList.get(i).getName().equals(name)){
				cartList.get(i).setQuantity(cartList.get(i).getQuantity()+1);				
			}
		}
	}
	public void downCartQty(HttpServletRequest request,String name){
		/*
		 * 세션에 바인딩 되어 있는 cartList를 받아와서
		 * name에 해당되는 상품을 찾아서 수량을 1만 감소..
		 */
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList=(ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<cartList.size(); i++){
			if(cartList.get(i).getName().equals(name)){
				cartList.get(i).setQuantity(cartList.get(i).getQuantity()-1);				
			}
		}
	}
	
	public void removeCartItem(HttpServletRequest request, String[ ] names){
		HttpSession session  = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<names.length; i++){
			for(int j=0; j<cartList.size(); j++){
				if(names[i].equals(cartList.get(j).getName())){
					cartList.remove(cartList.get(j));
				}//if
			}//for
		}//for
	}//removeCartItem
}















