package controller;
// 이전의 ControllerFactory.
public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance() {
		return handler;
	}
	

	public Controller createController(String command) {
		
		Controller controller = null;
		
		if(command.equals("/itemList.do")) {
			controller = new ItemListController();
			System.out.println("Starts to create ItemListController.");
		} else if(command.equals("/itemView.do")) {
			controller = new ItemViewController();
			System.out.println("Starts to create ItemViewController.");
		
		}else if(command.equals("/itemCartAdd.do")) {
			controller = new ItemCartAddController();
			System.out.println("Starts to ItemCartAddController.");
		
		}else if(command.equals("/itemCartList.do")) {
			controller = new ItemCartListController();
			System.out.println("Starts to create ItemCartListController.");
		
		}else if(command.equals("/amountUp.do")) {
			//System.out.println("1");
			controller = new AmountUpController();
		
		}else if(command.equals("/amountDown.do")) {
			//System.out.println("2");
			controller = new AmountDownController();
		}else if(command.equals("/deleteCart.do")) {
			System.out.println("1");
			controller = new deleteCartController();
		}
		
		return controller;
	}
}
