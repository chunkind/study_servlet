package controller;
//Controller를 생성하는 공장.
public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return handler;
	}
	
	public Controller createController(String command){
		Controller controller = null;
		if(command.equals("write")){
			controller = new WriteController();
		}else if(command.equals("showContent")){
			controller = new ShowContentController();
		}else if(command.equals("showList")){
			controller = new ShowListController();
		}else if(command.equals("deleteCheckPassword")){
			controller = new DeleteCheckPasswordController();
		}else if(command.equals("deletePosting")){
			controller = new DeletePostingController();
		}else if(command.equals("updatePosting")){
			controller = new UpdatePostingController();
		}else if(command.equals("updateView")){
			controller = new UpdateViewController();
		}else if(command.equals("updateCheckPassword")){
			controller = new UpdateCheckPasswordController();
		}
		return controller;
	}
}

//deleteCheckPassword

//deletePosting








