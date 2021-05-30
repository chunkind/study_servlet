package cartbiz;
/*
 * 장바구니의 비지니스 로직 ::
 * 1. item이 장바구니에 추가되는 로직 addCart() /
 * 2. 장바구니에 담겨진 모든 상품들을 다 가지고 오는 로직 getCartList()
 * ----------------------------------------------------
 * 1. 
 *  1) 이미 담겨져 있는 상품을 추가할때와 / 장바구니에 없는 상품을 추가할때
 *	    이것부터 알아야 한다. 
 *	    세션에서 가지고 와서 살펴봐야 한다..
 *	    세션에 상품들을 어떤 이름으로 바인딩 했었는지 미리 알고 있어야 한다.
 *	   cartList로 바인딩 했다고 치고.. 로직을 작성하자.
 */
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Item;
import model.ItemDao;

public class CartBiz {
	private static CartBiz cartBiz = new CartBiz();
	public ArrayList<Cart> cartList = new ArrayList<Cart>();
	private CartBiz(){}
	
	public static CartBiz getInstance(){
		return cartBiz;
	}
	
	public void addCart(int itemnumber,HttpServletRequest request) throws Exception{
		//먼저 세션을 받아와야 한다.
		HttpSession session = request.getSession();
		Item item = ItemDao.getInstance().getItem(itemnumber);
		Cart cart = null;
		boolean isCheck=false;
		if(item!=null)
		{
			cart=new Cart(item.getName(),item.getUrl(),item.getPrice(),1);
			if(cartList!=null)
			{
				for(Cart c:cartList)
				{
					if(c.getName().equals(cart.getName()))
					{
						isCheck=true;
					}
				}
			}
		}else{
			System.out.println("addCart.item==null");
		}
		if(!isCheck)
		{
			cartList.add(cart);
			session.setAttribute("cartList", cartList);
		}
		
		
		
		/*ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("CartList");
		System.out.println(cartList);
		for(int i=0; i<cartList.size(); i++){*/
			/*if(cartList.get(i).getName() == selectedItem.getName()){
				// 존재하는 경우,
				cartList.get(i).setAmount(cartList.get(i).getAmount()+ 1);
			} else{
				// 존재하지 않는 경우
				cartList.add(new Cart(selectedItem.getName(), selectedItem.getUrl(), selectedItem.getPrice(), 1));
			}
		}
		
		//request.getSession().setAttribute("CartList", cartList);*/
	}
	
	public void upAmount(String name,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Cart cart = null;
		ArrayList<Cart> list= (ArrayList<Cart>) session.getAttribute("cartList");
		System.out.println(name);
		System.out.println(list);
		System.out.println("upAnount Call");
		for(Cart c : list)
		{
			if(c.getName().equals(name))
			{
				c.setAmount(c.getAmount()+1);
				System.out.println(c.getAmount());
			}
		}
		session.setAttribute("cartList", cartList);
	}
	
	public void downAmount(String name,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Cart cart = null;
		System.out.println("down Call");
		ArrayList<Cart> list= (ArrayList<Cart>) session.getAttribute("cartList");
		
		for(Cart c : list)
		{
			if(c.getName().equals(name))
			{
				c.setAmount(c.getAmount()-1);
			}
		}
		session.setAttribute("cartList", cartList);
	}
	
	public void deleteCart(String[] arr,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Cart cart = null;
		ArrayList<Cart> list= (ArrayList<Cart>) session.getAttribute("cartList");
		System.out.println(arr.length);
		/*if()
		{
			
		}*/
		System.out.println(list);
		for(int i= 0 ; i < list.size() ; i++)
		{
			list.remove(Integer.parseInt(arr[i])-1);
		}
		
		session.setAttribute("cartList", cartList);
	}
	
	public static ArrayList<Cart> getCartList(HttpServletRequest request ){
		 HttpSession session = request.getSession();
		 ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		 
		 return cartList;
	}
	
	
}
