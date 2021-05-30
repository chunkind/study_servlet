package factory;

import factory.action.Action;
import factory.action.DeleteAction;
import factory.action.InsertAction;
import factory.action.UpdateAction;

/*
 * Action을 만들어 내는 공장.
 * Command 값에 따라서 서로 다른 Action들이 만들어 진다.
 * ::
 * InsertAction, DeleteAction, UpdateAction...이것들은 구상객체...
 * 결과적으로 개발자가 만들어내야 하는 결정체이다.
 */
public class ActionFactory implements Factory{

	private static ActionFactory factory = new ActionFactory();
	
	private ActionFactory() {
		System.out.println("공장 만들어진다..");
	}
	
	public static ActionFactory GetInstance() {
		return factory;
	}
	
	@Override
	public Action createAction(String command) {
		Action action = null;
		if(command.equals("INSERT")) {
			action = new InsertAction();
		}else if(command.equals("DELETE")){
			action = new DeleteAction();
		}else if(command.equals("UPDATE")){
			action = new UpdateAction();
		}
		return action;
	}
}