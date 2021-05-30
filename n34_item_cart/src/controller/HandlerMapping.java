package controller;
//이전의 ControllerFactory이다.
public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return handler;
	}
	
	//Controller를 리턴하는 메소드...
	public Controller createController(String command){
		Controller controller = null;
		if(command.equals("/itemList.do")){ //이부분 주의!!!
			controller=  new ItemListController();
			System.out.println("ItemListController Component 생성됨...");
		}else if (command.equals("/itemView.do")){
			controller = new ItmeViewController();
			System.out.println("ItmeViewController Component 생성됨...");
		}else if (command.equals("/itemCartAdd.do")){
			controller = new ItemCartAddController();
			System.out.println("ItemCartAddController Component 생성됨...");
		}else if (command.equals("/itemCartList.do")){
			controller = new ItemCartListController();
			System.out.println("ItemCartListController Component 생성됨...");
		}else if (command.equals("/itemCartQtyUp.do")){
			controller = new ItemCartQtyUpController();
			System.out.println("ItemCartQtyUpController Component 생성됨...");
		}else if (command.equals("/itemCartQtyDown.do")){
			controller = new ItemCartQtyDownController();
			System.out.println("ItemCartQtyDownController Component 생성됨...");
		}else if (command.equals("/itemCartRemove.do")){
			controller = new ItemCartRemoveController();
			System.out.println("ItemCartRemoveController Component 생성됨...");
		}
		return controller;
	}
}


//itemCartAdd
//itemCartList
//itemCartQtyUp.do
//itemCartQtyDown.do
//itemCartRemove.do








