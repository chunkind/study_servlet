package controller;

public class HandlerMapping {
	
	private static HandlerMapping handlerMapper = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return handlerMapper;
	}
	
	
	public Controller createController(String command){
		Controller controller = null;
		
		if(command.equals("find")){
			controller = new FindController();
		}else if(command.equals("login")){
			controller = new LoginController();
		}else if(command.equals("register")){
			controller = new RegisterController();
		}else if(command.equals("checkId")){
			controller = new CheckIdController();
		}else if(command.equals("update")){
			controller = new UpdateController();
		}else if(command.equals("logout")){
			controller = new LogoutController();
		}else if(command.equals("showAllMember")){
			controller = new showAllMemberController();
		}
		
		return controller;
	}
}
